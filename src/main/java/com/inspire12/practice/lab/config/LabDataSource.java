package com.inspire12.practice.lab.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
//@EnableTransactionManagement
@EnableConfigurationProperties
@EnableJpaRepositories(
        basePackages = "com.inspire12.practice.lab.database",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = LabDataSource.TX_MANAGER
)
public class LabDataSource {
    public final static String TX_MANAGER ="transactionManager";

    @Bean
    @ConfigurationProperties(prefix = "primary.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.inspire12.practice.lab.database");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        entityManager.setJpaPropertyMap(new HashMap<String, String>() {{

            put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            put("hibernate.id.new_generator_mappings", "false");
            put("hibernate.show_sql", "true");
            put("hibernate.hbm2ddl.auto", "create");
        }});
        return entityManager;
    }

    @Bean
    @Primary
    PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
