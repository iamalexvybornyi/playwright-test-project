package com.iamalexvybornyi.playwright.test.project.config.browser.driver;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "chrome")
public class ChromeDriver extends Driver {

    public ChromeDriver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
    }

    @Override
    @NonNull
    protected BrowserType getBrowserType(@NonNull Playwright playwright) {
        return playwright.chromium();
    }
}
