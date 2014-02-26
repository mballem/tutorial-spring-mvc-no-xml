package com.wp.mb.tutorial.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 15:00
 * http://static.springsource.org/spring/docs/3.0.0.M4/reference/html/ch12s08.html
 */
@Configuration
@ComponentScan(basePackages = "com.wp.mb.tutorial")
public class BeanDataSource {

    private DataSource dataSource;

    @Value("#{propriedades['jdbc.url']}")
    private String url;
    @Value("#{propriedades['jdbc.username']}")
    private String user;
    @Value("#{propriedades['jdbc.password']}")
    private String pass;
    @Value("#{propriedades['jdbc.driver']}")
    private String driver;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setPassword(pass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        return this.dataSource = dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean(name = "transaction")
    public PlatformTransactionManager transactionManager() {
        if (dataSource == null) {
            dataSource();
        }

        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "propriedades")
    public PropertiesLoaderSupport jdbcProperties() {
        PropertiesFactoryBean props = new PropertiesFactoryBean();
        props.setLocation(new ClassPathResource("/jdbc.properties"));
        return props;
    }
}

