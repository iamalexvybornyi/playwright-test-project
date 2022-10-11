package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
@Service
public class CommonAction {

    @NonNull
    private final ThreadLocal<Driver> driver;
    @NonNull
    private final HomePage homePage;

    public void verifySignOutLinkIsDisplayed() {
        this.driver.get().getLocator(this.homePage.getSignOutLink()).waitFor();
        boolean signOutLinkIsVisible = this.driver.get().getLocator(this.homePage.getSignOutLink()).isVisible();
        assertThat(signOutLinkIsVisible).isTrue();
    }
}
