package org.iamalexvybornyi.playwright.test.project.config.browser.driver;

import org.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "firefox")
public class FirefoxDriver extends Driver {

    public FirefoxDriver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        super(browserConfigurationProvider);
    }

    @Override
    @NonNull
    protected BrowserType getBrowserType(@NonNull Playwright playwright) {
        return playwright.firefox();
    }
}
