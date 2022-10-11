package com.iamalexvybornyi.playwright.test.project.config;

import com.github.javafaker.Faker;
import com.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@AllArgsConstructor
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.iamalexvybornyi.playwright.test.project")
public class CommonConfiguration {

    @NonNull
    private final UrlConfiguration urlConfiguration;

    @Bean
    @ConfigurationProperties(prefix = "app.browser")
    public BrowserConfigurationProperties browserConfigurationProperties() {
        return new BrowserConfigurationProperties();
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
