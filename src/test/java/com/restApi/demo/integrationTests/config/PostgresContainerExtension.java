package com.restApi.demo.integrationTests.config;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.startupcheck.MinimumDurationRunningStartupCheckStrategy;

import java.time.Duration;

public class PostgresContainerExtension implements BeforeAllCallback {
    private static final PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:14.5");

    @Override
    public void beforeAll(ExtensionContext context) {
        POSTGRES_SQL_CONTAINER.start();
        setProperties();
    }

    static {
        POSTGRES_SQL_CONTAINER.withStartupCheckStrategy(
                new MinimumDurationRunningStartupCheckStrategy(Duration.ofSeconds(3)));
        POSTGRES_SQL_CONTAINER.start();
    }

    private void setProperties() {
        System.setProperty(
                "spring.datasource.url",
                POSTGRES_SQL_CONTAINER.getJdbcUrl());
        System.setProperty(
                "spring.datasource.username",
                POSTGRES_SQL_CONTAINER.getUsername());
        System.setProperty(
                "spring.datasource.password",
                POSTGRES_SQL_CONTAINER.getPassword());
    }
}
