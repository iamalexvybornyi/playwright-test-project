package com.iamalexvybornyi.playwright.test.project.config.browser.driver;

import com.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@Getter
public abstract class Driver {
    @NonNull
    private final BrowserConfigurationProvider browserConfigurationProvider;
    @NonNull
    protected final ThreadLocal<Playwright> playwright;
    @NonNull
    protected ThreadLocal<Browser> browser;
    @NonNull
    protected ThreadLocal<BrowserContext> context;
    @NonNull
    protected ThreadLocal<Page> page;

    @NonNull
    public Driver(@NonNull BrowserConfigurationProvider browserConfigurationProvider) {
        this.browserConfigurationProvider = browserConfigurationProvider;
        this.playwright = ThreadLocal.withInitial(Playwright::create);
    }

    public void start() {
        this.context = ThreadLocal.withInitial(() -> this.browser.get().newContext(new Browser.NewContextOptions()
                .setViewportSize(
                        browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getWidth(),
                        browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getHeight()
                )));
        this.page = ThreadLocal.withInitial(() -> this.context.get().newPage());
    }

    public Locator getLocator(String locator) {
        return this.page.get().locator(locator);
    }

    public Locator getLocator(String locator, Page.LocatorOptions locatorOptions) {
        return this.page.get().locator(locator, locatorOptions);
    }
}
