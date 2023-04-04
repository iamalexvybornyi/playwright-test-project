package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import com.iamalexvybornyi.playwright.test.project.util.Category;
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
    @NonNull
    protected UrlConfiguration urlConfiguration;

    public void verifySignOutLinkIsDisplayed() {
        this.driver.get().getLocator(this.homePage.getHeaderElement().getSignOutLink()).waitFor();
        boolean signOutLinkIsVisible = this.driver.get().getLocator(this.homePage.getHeaderElement().getSignOutLink())
                .isVisible();
        assertThat(signOutLinkIsVisible).isTrue();
    }

    public void navigateToCategoryFromHomePage(@NonNull Category category) {
        this.driver.get().getLocator(homePage.getHomeCategoryElement().getCategory(category)).click();
        assertThat(driver.get().getPage().get().url())
                .isEqualTo(urlConfiguration.getShop() + "/" + category.toString().toLowerCase());
    }
}
