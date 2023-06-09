package com.iamalexvybornyi.playwright.test.project.config.browser.driver;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import lombok.NonNull;

public class ChromeDriver extends Driver {

    public ChromeDriver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
        this.browser = ThreadLocal.withInitial(() ->
                this.playwright.get().chromium().launch(browserConfigurationProvider.getLaunchOptions()));
    }
}
