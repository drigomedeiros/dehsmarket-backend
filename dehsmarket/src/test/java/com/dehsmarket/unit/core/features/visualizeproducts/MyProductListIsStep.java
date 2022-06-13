package com.dehsmarket.unit.core.features.visualizeproducts;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.repositories.IProductRepository;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class MyProductListIsStep {

    private IProductRepository productRepository;
    private List<Product> products;
    private DataTable productsData;

    public MyProductListIsStep(){

        this.productRepository = mock(IProductRepository.class);
        this.products = new ArrayList<>();
        when(this.productRepository.getProducts()).thenReturn(this.products);

    }

    @Given("my product list is")
    public void my_product_list_is(DataTable productsData) {
        
        this.productsData = productsData;
        
        var productMaps = this.productsData.asMaps(String.class, String.class);

        for(var productMap : productMaps){

            this.products.add(new Product(productMap.get("name"), Double.valueOf(productMap.get("price"))));

        }

    }

    public IProductRepository getProductsRepository(){
        return this.productRepository;
    }

    public int getProductsDataTableCount(){
        return this.productsData.asMaps().size();
    }

}
