package com.iamalexvybornyi.playwright.test.project.config;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.config.browser.factory.DriverFactory;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@AllArgsConstructor
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.iamalexvybornyi.playwright.test.project")
public class DriverConfiguration {

    private final DriverFactory driverFactory;

    @Bean
    @Scope("thread")
    public Driver driver() {
        return driverFactory.create();
    }
}
