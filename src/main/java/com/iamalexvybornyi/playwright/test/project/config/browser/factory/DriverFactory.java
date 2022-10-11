package com.iamalexvybornyi.playwright.test.project.config.browser.factory;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public abstract class DriverFactory {
    protected final BrowserConfigurationProvider browserConfigurationProvider;
    @Bean
    public abstract Driver create();
}
