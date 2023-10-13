package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class NavigationAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final HomePage homePage;
    @NonNull
    private UrlConfiguration urlConfiguration;

    @Step("Go to shop page")
    public void goToShopPage() {
        log.info("Navigating to the shop page");
        homePage.getHeaderElement().getShopLink().click();
        log.info("Verifying that the current URL matches the expected");
        assertThat(driver.getPage().get().url()).isEqualTo(urlConfiguration.getShop());
    }

    @Step("Navigate to URL")
    public void navigateToUrl(@NonNull String urlToNavigateTo, @NonNull String expectedUrl) {
        log.info("Navigating to the URL '{}'", urlToNavigateTo);
        driver.getPage().get().navigate(urlToNavigateTo);
        log.info("Verifying that the current URL matches the expected");
        assertThat(driver.getPage().get().url()).startsWith(expectedUrl);
    }
}
