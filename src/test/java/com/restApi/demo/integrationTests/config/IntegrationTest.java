package com.restApi.demo.integrationTests.config;

import com.restApi.demo.DemoApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(PostgresContainerExtension.class)
@AutoConfigureMockMvc
public @interface IntegrationTest {}
