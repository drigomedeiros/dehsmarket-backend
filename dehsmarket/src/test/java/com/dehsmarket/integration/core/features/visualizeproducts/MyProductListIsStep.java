package com.dehsmarket.integration.core.features.visualizeproducts;

import org.springframework.beans.factory.annotation.Autowired;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.repositories.IProductRepository;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.springframework.transaction.annotation.Transactional;


public class MyProductListIsStep {

    private IProductRepository productRepository;
    private DataTable productsData;

    @Autowired
    public MyProductListIsStep(IProductRepository productRepository){

        this.productRepository = productRepository;

    }

    @Given("my product list is")
    public void my_product_list_is(DataTable productsData) {
        
        this.productsData = productsData;
        
        var productMaps = this.productsData.asMaps(String.class, String.class);

        for(var productMap : productMaps){

            this.productRepository.addProduct(new Product(productMap.get("name"), Double.valueOf(productMap.get("price"))));

        }

    }

    public int getProductsDataTableCount(){
        return this.productsData.asMaps().size();
    }

}
