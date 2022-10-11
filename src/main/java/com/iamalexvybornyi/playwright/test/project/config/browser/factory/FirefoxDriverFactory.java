package com.iamalexvybornyi.playwright.test.project.config.browser.factory;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "firefox")
public class FirefoxDriverFactory extends DriverFactory {

    public FirefoxDriverFactory(BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
    }

    @Override
    @Bean
    public Driver create() {
        return new FirefoxDriver(this.browserConfigurationProvider);
    }
}
