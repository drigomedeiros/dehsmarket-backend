package com.dehsmarket.core.repositories;

import java.util.List;
import java.util.ServiceLoader;

import com.dehsmarket.core.entities.Product;

public interface IProductRepository {

    void addProduct(Product product);
    List<Product> getProducts();

    static IProductRepository getDefaultImpl(){

        IProductRepository repositoryService = null;

        for(var repositoryImpl : ServiceLoader.load(IProductRepository.class)){
            repositoryService = repositoryImpl;
        }

        if(repositoryService != null)
            return repositoryService;

        throw new IllegalArgumentException("Implementation for IProductRepository.class not found");

    }

}
