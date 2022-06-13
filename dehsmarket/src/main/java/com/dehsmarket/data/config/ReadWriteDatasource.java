package com.dehsmarket.data.config;

import com.dehsmarket.utils.SystemEnv;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class ReadWriteDatasource {

    @Bean(name = "readWriteJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate readWriteJdbcTemplate(@Qualifier("readWriteDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    @Bean
    @ConfigurationProperties("datasource.readwrite")
    @Primary
    public DataSourceProperties readWriteDataSourceProperties(){
        var readWriteProperties = new DataSourceProperties();
        readWriteProperties.setName("readonlyDatasource");
        readWriteProperties.setDriverClassName("org.postgresql.Driver");
        readWriteProperties.setUrl(SystemEnv.get("RW_DATASOURCE_JDBC_URL"));
        readWriteProperties.setUsername(SystemEnv.get("RW_DATASOURCE_USER"));
        readWriteProperties.setPassword(SystemEnv.get("RW_DATASOURCE_PASSWORD"));
        return readWriteProperties;
    }

    @Bean(name = "readWriteDataSource")
    @ConfigurationProperties("datasource.readwrite.default")
    @Primary
    public DataSource readWriteDataSource(DataSourceProperties readWriteDataSourceProperties){
        return readWriteDataSourceProperties.initializeDataSourceBuilder().build();
    }


}