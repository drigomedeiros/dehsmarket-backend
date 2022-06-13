package com.dehsmarket.integration.core.features.visualizeproducts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.dehsmarket.core.repositories.IProductRepository;

import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AfterEachScenario {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AfterEachScenario(@Qualifier("readWriteJdbcTemplate") NamedParameterJdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }

    @After
    public void clearRepository() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

        jdbcTemplate.update("DELETE FROM dehsmarket.product", new HashMap<>());

    }
    
}
