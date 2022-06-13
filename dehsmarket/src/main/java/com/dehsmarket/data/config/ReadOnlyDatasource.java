package com.dehsmarket.data.config;

import com.dehsmarket.utils.SystemEnv;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class ReadOnlyDatasource {

    @Bean(name = "readOnlyJdbcTemplate")
    public NamedParameterJdbcTemplate readonlyJdbcTemplate(@Qualifier("readonlyDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    @Bean
    @ConfigurationProperties("datasource.readonly")
    public DataSourceProperties readonlyDataSourceProperties(){
        var readOnlyProperties = new DataSourceProperties();
        readOnlyProperties.setName("readonlyDatasource");
        readOnlyProperties.setDriverClassName("org.postgresql.Driver");
        readOnlyProperties.setUrl(SystemEnv.get("RO_DATASOURCE_JDBC_URL"));
        readOnlyProperties.setUsername(SystemEnv.get("RO_DATASOURCE_USER"));
        readOnlyProperties.setPassword(SystemEnv.get("RO_DATASOURCE_PASSWORD"));
        return readOnlyProperties;
    }

    @Bean(name = "readonlyDataSource")
    @ConfigurationProperties("datasource.readonly.default")
    public DataSource readonlyDataSource(DataSourceProperties readonlyDataSourceProperties){
        return readonlyDataSourceProperties.initializeDataSourceBuilder().build();
    }

}
