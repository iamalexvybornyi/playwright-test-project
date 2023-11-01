package org.iamalexvybornyi.playwright.test.project.config.browser.driver;

import org.iamalexvybornyi.playwright.test.project.config.browser.provider.BrowserConfigurationProvider;
import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.debug("Initializing Playwright");
        this.getPlaywright().set(Playwright.create());
        this.getBrowser().set(getBrowserType(this.playwright.get()).launch(browserConfigurationProvider.getLaunchOptions()));
        this.getContext().set(
                this.browser.get().newContext(new Browser.NewContextOptions()
                        .setViewportSize(
                                browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getWidth(),
                                browserConfigurationProvider.getBrowserConfigurationProperties().getResolution().getHeight()
                        ))
        );
        this.getPage().set(this.context.get().newPage());
    }

    public void quit() {
        log.debug("Closing Playwright");
        if (this.getPage().get() != null) {
            this.getPage().get().close();
        }
        if (this.getContext().get() != null) {
            this.getContext().get().close();
        }
        if (this.getBrowser().get() != null) {
            this.getBrowser().get().close();
        }
        if (this.getPlaywright().get() != null) {
            this.getPlaywright().get().close();
        }
    }

    @NonNull
    public Locator getLocator(@NonNull String selector) {
        log.debug("Getting locator using selector '{}'", selector);
        return this.page.get().locator(selector);
    }

    @NonNull
    public Locator getLocator(@NonNull String selector, @NonNull Page.LocatorOptions locatorOptions) {
        log.debug("Getting locator using selector '{}' and options {}", selector, locatorOptions);
        return this.page.get().locator(selector, locatorOptions);
    }

    @NonNull
    protected abstract BrowserType getBrowserType(@NonNull Playwright playwright);
}
