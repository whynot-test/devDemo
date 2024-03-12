package com.example.devdemo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Author: bi
 * @createTime: 2024年03月11日 11:25:24
 * @version: 1.0
 * @Description:
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Value("${dataSource.jdbcUrl}")
    private String dataSourceUrl;

    @Value("${dataSource.password}")
    private String dataSourcePwd;

    @Value("${dataSource.user}")
    private String dataSourceUser;

    @Value("${dataSource.driverClass}")
    private String dataSourceDriver;

    @Value("${dataSource.maxPoolSize:15}")
    private int maxPoolSize;

    @Value("${dataSource.initPoolSize:3}")
    private int initPoolSize;


    @Bean
    public DataSource dataSource() throws Exception {
        Class.forName(dataSourceDriver);

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create().type(ComboPooledDataSource.class);

        // user
        dataSourceBuilder.username(dataSourceUser);

        // password
        dataSourceBuilder.password(dataSourcePwd);

        dataSourceBuilder.url(dataSourceUrl);
        dataSourceBuilder.driverClassName(dataSourceDriver);

        ComboPooledDataSource dataSource = (ComboPooledDataSource) dataSourceBuilder.build();
        dataSource.setIdleConnectionTestPeriod(1800);
        dataSource.setPreferredTestQuery("select 1");
        dataSource.setInitialPoolSize(initPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);

        return dataSource;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public boolean isDMDatabase() {
        return dataSourceUrl.startsWith("jdbc:dm")||dataSourceUrl.startsWith("jdbc:log4jdbc:dm");
    }
}
