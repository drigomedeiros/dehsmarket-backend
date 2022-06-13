package com.dehsmarket.data.sql;

public class ProductCommands {

    private ProductCommands(){}

    public static String INSERT = """
                INSERT INTO dehsmarket.product (name, price, turned_on)
                VALUES (:name, :price, true)
            """;

}
