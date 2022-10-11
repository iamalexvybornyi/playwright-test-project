package com.iamalexvybornyi.playwright.test.project.config.browser.factory;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.ChromeDriver;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "chrome")
public class ChromeDriverFactory extends DriverFactory {

    public ChromeDriverFactory(BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
    }

    @Override
    @Bean
    public Driver create() {
        return new ChromeDriver(this.browserConfigurationProvider);
    }
}
