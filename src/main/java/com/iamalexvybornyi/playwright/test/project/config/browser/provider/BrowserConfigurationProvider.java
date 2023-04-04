package com.iamalexvybornyi.playwright.test.project.config.browser.provider;

import com.iamalexvybornyi.playwright.test.project.config.browser.BrowserConfigurationProperties;
import com.microsoft.playwright.BrowserType;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

@Getter
public abstract class BrowserConfigurationProvider {

    @NonNull
    private final BrowserConfigurationProperties browserConfigurationProperties;

    @NonNull
    private final BrowserType.LaunchOptions launchOptions;

    public BrowserConfigurationProvider(@NonNull BrowserConfigurationProperties browserConfigurationProperties) {
        this.browserConfigurationProperties = browserConfigurationProperties;
        this.launchOptions = new BrowserType.LaunchOptions()
                .setArgs(Arrays.asList(browserConfigurationProperties.getMaximized() ? "--start-fullscreen" : ""))
                .setHeadless(browserConfigurationProperties.getHeadless());
    }
}
