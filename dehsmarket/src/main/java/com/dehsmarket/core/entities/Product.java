package com.dehsmarket.core.entities;

public class Product {

    private String name;
    private Double price;

    public Product(){
        this("", 0.0);
    }

    public Product(String name, Double price){
        this.setName(name)
            .setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return this.price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

}
