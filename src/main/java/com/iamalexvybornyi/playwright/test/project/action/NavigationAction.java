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
    private final ThreadLocal<Driver> driver;
    @NonNull
    private final HomePage homePage;
    @NonNull
    protected UrlConfiguration urlConfiguration;

    public void goToShopPage() {
        this.driver.get().getLocator(homePage.getHeaderElement().getShopLink()).click();
        assertThat(driver.get().getPage().get().url()).isEqualTo(urlConfiguration.getShop());
    }

    public void navigateToUrl(@NonNull String urlToNavigateTo, @NonNull String expectedUrl) {
        driver.get().getPage().get().navigate(urlToNavigateTo);
        assertThat(driver.get().getPage().get().url()).startsWith(expectedUrl);
    }
}
