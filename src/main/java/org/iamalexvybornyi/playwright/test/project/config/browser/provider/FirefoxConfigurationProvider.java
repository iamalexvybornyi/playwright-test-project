package org.iamalexvybornyi.playwright.test.project.config.browser.provider;

import org.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "firefox")
public class FirefoxConfigurationProvider extends BrowserConfigurationProvider {

    public FirefoxConfigurationProvider(@NonNull BrowserConfigurationProperties browserConfigurationProperties) {
        super(browserConfigurationProperties);
    }
}
