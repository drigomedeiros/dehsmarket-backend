package com.dehsmarket.integration.core.features.visualizeproducts;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dehsmarket.core.repositories.IProductRepository;
import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortListOfProductsSteps {
    
    private IProductRepository productRepository;
    private String sorter;

    @Autowired
    public SortListOfProductsSteps(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @When("a user sort by {string}")
    public void a_user_sort_by_sorter(String sorter) {
        this.sorter = sorter;
    }

    @Then("products are presented sorted by the user option")
    public void products_are_presented_orted_by_sorter() {
        
        var visualizeProductsUseCase = new VisualizeProductsUseCase(productRepository);
        var sortedProducts = visualizeProductsUseCase.getAvailableProducts("", this.sorter);

        if(this.sorter.equals("price")){

            Assertions.assertThat(sortedProducts.get(0).getName()).isEqualTo("Product 3");
            Assertions.assertThat(sortedProducts.get(sortedProducts.size()-1).getName()).isEqualTo("Product 1");

        } else {

            Assertions.assertThat(sortedProducts.get(0).getName()).isEqualTo("Product 1");
            Assertions.assertThat(sortedProducts.get(sortedProducts.size()-1).getName()).isEqualTo("Product 3");

        }

    }

}
