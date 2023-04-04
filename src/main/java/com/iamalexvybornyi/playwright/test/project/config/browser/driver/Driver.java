package com.iamalexvybornyi.playwright.test.project.config.browser.driver;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class Driver {
    @NonNull
    private final BrowserConfigurationProvider browserConfigurationProvider;
    @NonNull
    protected final Playwright playwright;
    @NonNull
    protected Browser browser;
    @NonNull
    protected BrowserContext context;
    @NonNull
    protected Page page;

    @NonNull
    public Driver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        this.browserConfigurationProvider = browserConfigurationProvider;
        this.playwright = Playwright.create();
    }

    public void start() {
        this.context = this.browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(
                        browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getWidth(),
                        browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getHeight()
                ));
        this.page = this.context.newPage();
    }

    public Locator getLocator(String locator) {
        return this.page.locator(locator);
    }

    public Locator getLocator(String locator, Page.LocatorOptions locatorOptions) {
        return this.page.locator(locator, locatorOptions);
    }
}
