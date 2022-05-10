package com.dehsmarket.unit.core.features.visualizeproducts;

import java.util.List;

import com.dehsmarket.core.DehsMarketApp;
import com.dehsmarket.core.Product;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListAvailableProductsSteps {

    private DehsMarketApp dehsMarketApp;
    private List<Product> products;
    
    @Given("any visitor")
    public void any_visitor() {
        dehsMarketApp = new DehsMarketApp();
    }

    @When("they enter in Deh's Market")
    public void they_enter_in_deh_s_market() {
        this.products = dehsMarketApp.getAvalilableProducts();
    }

    @Then("the products are presented")
    public void the_products_are_presented() {
        Assertions.assertThat(this.products).isNotEmpty();
    }

}
