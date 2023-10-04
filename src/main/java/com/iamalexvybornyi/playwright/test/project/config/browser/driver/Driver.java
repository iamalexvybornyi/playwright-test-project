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
    private final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    @NonNull
    private final ThreadLocal<Browser> browser = new ThreadLocal<>();
    @NonNull
    private final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    @NonNull
    private final ThreadLocal<Page> page = new ThreadLocal<>();

    @NonNull
    public Driver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        this.browserConfigurationProvider = browserConfigurationProvider;
    }

    public void start() {
        this.playwright.set(Playwright.create());
        this.browser.set(getBrowserType(this.playwright.get()).launch(browserConfigurationProvider.getLaunchOptions()));
        this.context.set(
                this.browser.get().newContext(new Browser.NewContextOptions()
                        .setViewportSize(
                                browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getWidth(),
                                browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getHeight()
                        ))
        );
        this.page.set(this.context.get().newPage());
    }

    @NonNull
    public Locator getLocator(@NonNull String locator) {
        return this.page.get().locator(locator);
    }

    @NonNull
    public Locator getLocator(@NonNull String locator, @NonNull Page.LocatorOptions locatorOptions) {
        return this.page.get().locator(locator, locatorOptions);
    }

    @NonNull
    protected abstract BrowserType getBrowserType(@NonNull Playwright playwright);
}
