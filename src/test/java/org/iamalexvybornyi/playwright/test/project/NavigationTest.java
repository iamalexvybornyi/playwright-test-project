package org.iamalexvybornyi.playwright.test.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class NavigationTest extends BaseTest {

    @Test
    public void navigateToShop() {
        navigationAction.navigateToUrl(urlConfiguration.getShop(), urlConfiguration.getShop());
    }

    @Test
    public void navigateToSignIn() {
        navigationAction.navigateToUrl(urlConfiguration.getAuth(), urlConfiguration.getAuth());
    }

    @Test
    public void navigateToHome() {
        navigationAction.navigateToUrl(urlConfiguration.getHome(), urlConfiguration.getHome());
    }
}
