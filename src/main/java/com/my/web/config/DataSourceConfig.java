package com.my.web.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // 作业DB
    @Bean(name = "serviceDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.service") // application.properteis中对应属性的前缀
    public DataSource dataSource3() {
        return DataSourceBuilder.create().build();
    }
}