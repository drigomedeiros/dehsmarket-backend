package com.dehsmarket.unit.core.features.visualizeproducts;

import org.assertj.core.api.Assertions;

import com.dehsmarket.core.usecases.VisualizeProductsUseCase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortListOfProductsSteps {
    
    private MyProductListIsStep myProducts;
    private String sorter;

    public SortListOfProductsSteps(MyProductListIsStep myProducts){
        this.myProducts = myProducts;
    }

    @When("a user sort by {string}")
    public void a_user_sort_by_sorter(String sorter) {
        this.sorter = sorter;
    }

    @Then("products are presented sorted by the user option")
    public void products_are_presented_orted_by_sorter() {
        
        var VisualizeProductsUseCase = new VisualizeProductsUseCase(myProducts.getProductsRepository());
        var sortedProducts = VisualizeProductsUseCase.getAvailableProducts("", this.sorter);

        if(this.sorter.equals("price")){

            Assertions.assertThat(sortedProducts.get(0).getName()).isEqualTo("Product 3");
            Assertions.assertThat(sortedProducts.get(sortedProducts.size()-1).getName()).isEqualTo("Product 1");

        } else {

            Assertions.assertThat(sortedProducts.get(0).getName()).isEqualTo("Product 1");
            Assertions.assertThat(sortedProducts.get(sortedProducts.size()-1).getName()).isEqualTo("Product 3");

        }

    }

}
