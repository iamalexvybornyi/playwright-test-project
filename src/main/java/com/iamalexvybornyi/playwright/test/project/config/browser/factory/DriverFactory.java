package com.iamalexvybornyi.playwright.test.project.config.browser.factory;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DriverFactory {
    protected final BrowserConfigurationProvider browserConfigurationProvider;
    public abstract Driver create();
}
