package com.dehsmarket.core.usecases;

import java.util.Comparator;
import java.util.List;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.repositories.IProductRepository;

public class VisualizeProductsUseCase {

    private IProductRepository productRepository;

    public VisualizeProductsUseCase(){

        this(IProductRepository.getDefaultImpl());

    }

    public VisualizeProductsUseCase(IProductRepository productRepository){

        this.productRepository = productRepository;

    }

    public List<Product> getAvailableProducts() {
        return getAvailableProducts("", "default");
    }

    public List<Product> getAvailableProducts(String filter, String sorter) {

        var comparator = (sorter.equals("price")) ? Comparator.comparing(Product::getPrice) : Comparator.comparing(Product::getName);
        return this.productRepository.getProducts().stream().filter((p -> p.getName().contains(filter))).sorted(comparator).toList();
        
    }

}
