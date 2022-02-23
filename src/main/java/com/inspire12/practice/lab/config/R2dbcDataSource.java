package com.inspire12.practice.lab.config;

import com.zaxxer.hikari.HikariDataSource;
import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryMetadata;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@Configuration
@EnableConfigurationProperties
@EnableR2dbcRepositories(
        basePackages = "com.inspire12.practice.lab.database"

)
public class R2dbcDataSource extends AbstractR2dbcConfiguration {
    public final static String TX_MANAGER ="r2dbc_transactionManager";

    @Value("${r2dbc.datasource.jdbc-url}") String r2Url;
    @Value("${r2dbc.datasource.username}") String username;

    @Bean
    public H2ConnectionFactory connectionFactory() {
        H2ConnectionFactory.inMemory("test");
        return new H2ConnectionFactory(
                H2ConnectionConfiguration.builder()
                        .url(r2Url)
                        .username(username)
                        .build()
        );
    }
}
