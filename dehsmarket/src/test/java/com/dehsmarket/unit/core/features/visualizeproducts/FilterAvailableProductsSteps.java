package com.dehsmarket.unit.core.features.visualizeproducts;

import org.assertj.core.api.Assertions;

import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAvailableProductsSteps {

    private String filter;
    private MyProductListIsStep myProducts;

    public FilterAvailableProductsSteps(MyProductListIsStep myProducts){
        this.myProducts = myProducts;
    }

    @When("a user types a filter {string}")
    public void a_user_types_a_filter(String filter) {
        this.filter = filter;
    }

    @Then("only {int} products that match the filter are presented")
    public void only_products_that_match_are_presented(int quantity) {
        var visualizeProductsUseCase = new VisualizeProductsUseCase(myProducts.getProductsRepository());
        var filteredProducts = visualizeProductsUseCase.getAvailableProducts(this.filter, "");
        Assertions.assertThat(filteredProducts).hasSize(quantity);
    }

}
