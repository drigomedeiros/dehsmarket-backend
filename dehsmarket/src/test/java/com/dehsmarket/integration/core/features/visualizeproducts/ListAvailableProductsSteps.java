package com.dehsmarket.integration.core.features.visualizeproducts;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.repositories.IProductRepository;
import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListAvailableProductsSteps {

    private MyProductListIsStep myProducts;
    private IProductRepository productRepository;;
    private VisualizeProductsUseCase visualizeProductsUseCase;
    private List<Product> products;

    @Autowired
    public ListAvailableProductsSteps(IProductRepository productRepository, MyProductListIsStep myProducts){
        this.productRepository = productRepository;
        this.myProducts = myProducts;
    }
    
    @Given("any visitor")
    public void any_visitor() {
        this.visualizeProductsUseCase = new VisualizeProductsUseCase(productRepository);
    }

    @When("they enter in Deh's Market")
    public void they_enter_in_deh_s_market() {
        this.products = visualizeProductsUseCase.getAvailableProducts();
    }

    @Then("the products are presented")
    public void the_products_are_presented() {
        Assertions.assertThat(this.products).isNotEmpty().hasSize(this.myProducts.getProductsDataTableCount());
    }

    public List<Product> getStoreProducts(){

        return this.products;

    }

}
