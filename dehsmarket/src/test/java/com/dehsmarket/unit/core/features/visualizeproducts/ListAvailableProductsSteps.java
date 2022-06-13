package com.dehsmarket.unit.core.features.visualizeproducts;

import java.util.List;

import org.assertj.core.api.Assertions;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListAvailableProductsSteps {

    private MyProductListIsStep myProductsStep;
    private VisualizeProductsUseCase visualizeProductsUseCase;
    private List<Product> products;

    public ListAvailableProductsSteps(MyProductListIsStep myProductsStep){
        this.myProductsStep = myProductsStep;
    }
    
    @Given("any visitor")
    public void any_visitor() {
        this.visualizeProductsUseCase = new VisualizeProductsUseCase(myProductsStep.getProductsRepository());
    }

    @When("they enter in Deh's Market")
    public void they_enter_in_deh_s_market() {
        this.products = visualizeProductsUseCase.getAvailableProducts();
    }

    @Then("the products are presented")
    public void the_products_are_presented() {
        Assertions.assertThat(this.products).isNotEmpty().hasSize(this.myProductsStep.getProductsDataTableCount());
    }

    public List<Product> getStoreProducts(){

        return this.products;

    }

}
