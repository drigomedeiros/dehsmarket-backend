package com.dehsmarket.unit.core.features.visualizeproducts;

import java.util.List;
import java.util.stream.Collectors;

import com.dehsmarket.core.DehsMarketApp;
import com.dehsmarket.core.Product;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAvailableProductsSteps {

    private List<Product> productsBeingPresented;
    private String filter;

    public FilterAvailableProductsSteps(AListOfProductsBeingPresentedStep productsBeingPresentedStep){
        this.productsBeingPresented = productsBeingPresentedStep.getProducts();
    }

    @When("a user types a filter {string}")
    public void a_user_types_a_filter(String filter) {
        this.filter = filter;
    }

    @Then("only products that match the filter are presented")
    public void only_products_that_match_are_presented() {
        var dehsMarketApp = new DehsMarketApp();
        var filteredProducts = dehsMarketApp.getAvalilableProducts(this.filter, "");
        Assertions.assertThat(filteredProducts).hasSameSizeAs(this.productsBeingPresented.stream().filter((p) -> p.getName().equals(this.filter)).collect(Collectors.toList()));
    }

}
