package com.dehsmarket.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dehsmarket.data.mappers.ProductMapper;
import com.dehsmarket.data.sql.ProductCommands;
import com.dehsmarket.data.sql.ProductQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dehsmarket.core.entities.Product;
import com.dehsmarket.core.repositories.IProductRepository;
import com.dehsmarket.utils.Converter;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    
    private NamedParameterJdbcTemplate readOnlyJdbcTemplate;
    private NamedParameterJdbcTemplate readWriteJdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(@Qualifier("readOnlyJdbcTemplate") NamedParameterJdbcTemplate readOnlyJdbcTemplate, @Qualifier(value = "readWriteJdbcTemplate") NamedParameterJdbcTemplate readWriteJdbcTemplate){

        this.readOnlyJdbcTemplate = readOnlyJdbcTemplate;
        this.readWriteJdbcTemplate = readWriteJdbcTemplate;

    }

    @Override
    public void addProduct(Product product) {

        try{

            var params = new HashMap<String, Object>();
            params.put("name", product.getName());
            params.put("price", product.getPrice());

            readWriteJdbcTemplate.update(ProductCommands.INSERT, params);

        } catch (Exception e) {

            throw new UnsupportedOperationException("An error occurred while saving a product: " + e.getMessage());
        }
        
    }

    @Override
    public List<Product> getProducts() {

        try {
            return readOnlyJdbcTemplate.query(ProductQueries.GET_PRODUCTS, new ProductMapper());
        } catch (Exception e) {
            throw new UnsupportedOperationException("An error occurred while saving a product: " + e.getMessage());
        }

    }

}
