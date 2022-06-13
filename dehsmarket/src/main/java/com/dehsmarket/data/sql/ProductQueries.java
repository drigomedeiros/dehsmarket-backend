package com.dehsmarket.data.sql;

public class ProductQueries {

    private ProductQueries(){}

    public static final String GET_PRODUCTS = """
            
                SELECT * FROM dehsmarket.product p WHERE p.turned_on = true;

            """;
    
}
