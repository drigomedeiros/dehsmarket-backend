package com.dehsmarket.integration.core.features.visualizeproducts;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dehsmarket.core.repositories.IProductRepository;
import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAvailableProductsSteps {

    private String filter;
    private IProductRepository productRepository;

    @Autowired
    public FilterAvailableProductsSteps(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @When("a user types a filter {string}")
    public void a_user_types_a_filter(String filter) {
        this.filter = filter;
    }

    @Then("only {int} products that match the filter are presented")
    public void only_products_that_match_are_presented(int quantity) {
        var visualizeProductsUseCase = new VisualizeProductsUseCase(productRepository);
        var filteredProducts = visualizeProductsUseCase.getAvailableProducts(this.filter, "");
        Assertions.assertThat(filteredProducts).hasSize(quantity);
    }

}
