package com.iamalexvybornyi.playwright.test.project.config.browser.driver;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import lombok.NonNull;

public class FirefoxDriver extends Driver {

    public FirefoxDriver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
        this.browser = this.playwright.firefox().launch(browserConfigurationProvider.getLaunchOptions());
    }
}
