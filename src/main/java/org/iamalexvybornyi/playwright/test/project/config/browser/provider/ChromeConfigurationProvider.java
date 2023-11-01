package org.iamalexvybornyi.playwright.test.project.config.browser.provider;

import org.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.browser.name", havingValue = "chrome")
public class ChromeConfigurationProvider extends BrowserConfigurationProvider {

    public ChromeConfigurationProvider(@NonNull BrowserConfigurationProperties browserConfigurationProperties) {
        super(browserConfigurationProperties);
    }
}
