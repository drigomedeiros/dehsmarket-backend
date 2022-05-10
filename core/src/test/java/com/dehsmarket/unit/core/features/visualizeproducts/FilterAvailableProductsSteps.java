package com.dehsmarket.unit.core.features.visualizeproducts;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAvailableProductsSteps {

    private AListOfProductsBeingPresentedStep productsBeingPresentedStep;

    FilterAvailableProductsSteps(AListOfProductsBeingPresentedStep productsBeingPresentedStep){
        this.productsBeingPresentedStep = productsBeingPresentedStep;
    }

    @When("a user types a filter \\{string}")
    public void a_user_types_a_filter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("only products that match \\{string} are presented")
    public void only_products_that_match_are_presented() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
