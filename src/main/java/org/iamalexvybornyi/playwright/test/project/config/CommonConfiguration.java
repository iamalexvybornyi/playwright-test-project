package org.iamalexvybornyi.playwright.test.project.config;

import com.github.javafaker.Faker;
import org.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@ComponentScan(basePackages = "org.iamalexvybornyi.playwright.test.project")
public class CommonConfiguration {

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
