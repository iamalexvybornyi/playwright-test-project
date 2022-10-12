package com.iamalexvybornyi.playwright.test.project.config;

import com.github.javafaker.Faker;
import com.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.SimpleThreadScope;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.iamalexvybornyi.playwright.test.project")
public class CommonConfiguration {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("thread", new SimpleThreadScope());
        return configurer;
    }

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
