package com.dehsmarket.unit.core.features.visualizeproducts;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortListOfProductsSteps {
    
    private AListOfProductsBeingPresentedStep productsBeingPresentedStep;

    SortListOfProductsSteps(AListOfProductsBeingPresentedStep productsBeingPresentedStep){
        this.productsBeingPresentedStep = productsBeingPresentedStep;
    }

    @When("a user sort by <sorter>")
    public void a_user_sort_by_sorter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("products are presented orted by <sorter>")
    public void products_are_presented_orted_by_sorter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
