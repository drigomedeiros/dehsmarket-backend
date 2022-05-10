package com.dehsmarket.unit.core.features.visualizeproducts;

import java.util.List;

import com.dehsmarket.core.DehsMarketApp;
import com.dehsmarket.core.Product;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortListOfProductsSteps {
    
    private List<Product> productsBeingPresented;
    private String sorter;

    public SortListOfProductsSteps(AListOfProductsBeingPresentedStep productsBeingPresentedStep){
        this.productsBeingPresented = productsBeingPresentedStep.getProducts();
    }

    @When("a user sort by {string}")
    public void a_user_sort_by_sorter(String sorter) {
        this.sorter = sorter;
    }

    @Then("products are presented sorted by the user option")
    public void products_are_presented_orted_by_sorter() {
        
        var dehsmarketApp = new DehsMarketApp();
        var sortedProducts = dehsmarketApp.getAvalilableProducts("", this.sorter);

        var atLeastOneDifference = false;
        
        for(var i = 0; i < productsBeingPresented.size(); i++) {

            if(!this.productsBeingPresented.get(i).getName().equals(sortedProducts.get(0).getName()))
                atLeastOneDifference = true;

        }

        Assertions.assertThat(atLeastOneDifference).isTrue();

    }

}
