package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
@Service
public class NavigationAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final HomePage homePage;
    @NonNull
    protected UrlConfiguration urlConfiguration;

    public void goToShopPage() {
        this.driver.getLocator(homePage.getHeaderElement().getShopLink()).click();
        assertThat(driver.getPage().url()).isEqualTo(urlConfiguration.getShop());
    }

    public void navigateToUrl(@NonNull String urlToNavigateTo, @NonNull String expectedUrl) {
        driver.getPage().navigate(urlToNavigateTo);
        assertThat(driver.getPage().url()).startsWith(expectedUrl);
    }
}
