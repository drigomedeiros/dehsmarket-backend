package com.dehsmarket.unit.core.features.visualizeproducts;

import java.util.ArrayList;
import java.util.List;

import com.dehsmarket.core.DehsMarketApp;
import com.dehsmarket.core.Product;

import io.cucumber.java.en.Given;

public class AListOfProductsBeingPresentedStep {

    public AListOfProductsBeingPresentedStep(){
        
    }
    
    private List<Product> products;

    @Given("a list of products being presented")
    public void a_list_of_products_being_presented() {
        
        var dehsMarketApp = new DehsMarketApp();
        products = dehsMarketApp.getAvalilableProducts();

    }

    public List<Product> getProducts(){
        return new ArrayList<>(this.products);
    }

}
