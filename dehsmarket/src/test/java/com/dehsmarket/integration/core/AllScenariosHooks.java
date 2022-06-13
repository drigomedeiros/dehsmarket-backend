package com.dehsmarket.integration.core;

import static org.mockito.Mockito.mockStatic;

import org.mockito.MockedStatic;
import org.testcontainers.containers.PostgreSQLContainer;

import com.dehsmarket.utils.SystemEnv;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class AllScenariosHooks {

    private static final MockedStatic<SystemEnv> systemEnvMocked = mockStatic(SystemEnv.class);
    private static final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.3-alpine")
                                                                                                .withDatabaseName("dehsmarket")
                                                                                                .withUsername("postgres")
                                                                                                .withPassword("postgres")
                                                                                                .withExposedPorts(5432);

    @BeforeAll(order = 1)
    public static void runPostgres(){
        
        postgreSQLContainer.start();

    }

    @BeforeAll(order = 2)
    public static void mockEnv(){
        
        systemEnvMocked.when(() -> SystemEnv.get("RO_DATASOURCE_JDBC_URL")).thenReturn("jdbc:postgresql://localhost:" + postgreSQLContainer.getMappedPort(5432) + "/dehsmarket");
        systemEnvMocked.when(() -> SystemEnv.get("RO_DATASOURCE_USER")).thenReturn("postgres");
        systemEnvMocked.when(() -> SystemEnv.get("RO_DATASOURCE_PASSWORD")).thenReturn("postgres");

        systemEnvMocked.when(() -> SystemEnv.get("RW_DATASOURCE_JDBC_URL")).thenReturn("jdbc:postgresql://localhost:" + postgreSQLContainer.getMappedPort(5432) + "/dehsmarket");
        systemEnvMocked.when(() -> SystemEnv.get("RW_DATASOURCE_USER")).thenReturn("postgres");
        systemEnvMocked.when(() -> SystemEnv.get("RW_DATASOURCE_PASSWORD")).thenReturn("postgres");

    }

    @AfterAll(order = 2)
    public static void tearDownEnv(){
        systemEnvMocked.close();
    }    

    @AfterAll(order = 1)
    public static void tearDownPostgres(){

        postgreSQLContainer.close();
        
    }

}
