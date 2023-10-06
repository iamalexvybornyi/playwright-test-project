package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import com.iamalexvybornyi.playwright.test.project.util.Category;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class CommonAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final HomePage homePage;
    @NonNull
    protected UrlConfiguration urlConfiguration;

    @Step("Verify sign out link is displayed")
    public void verifySignOutLinkIsDisplayed() {
        log.info("Verifying the sign out link is displayed");
        this.driver.getLocator(this.homePage.getHeaderElement().getSignOutLink()).waitFor();
        boolean signOutLinkIsVisible = this.driver.getLocator(this.homePage.getHeaderElement().getSignOutLink())
                .isVisible();
        assertThat(signOutLinkIsVisible).isTrue();
    }

    @Step("Navigate to category from home page")
    public void navigateToCategoryFromHomePage(@NonNull Category category) {
        log.info("Navigating to the category {} from home page", category);
        this.driver.getLocator(homePage.getHomeCategoryElement().getCategory(category)).click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(driver.getPage().get().url())
                .isEqualTo(urlConfiguration.getShop() + "/" + category.toString().toLowerCase());
    }
}
