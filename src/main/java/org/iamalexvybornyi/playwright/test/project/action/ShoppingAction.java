package org.iamalexvybornyi.playwright.test.project.action;

import org.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import org.iamalexvybornyi.playwright.test.project.page.ShopPage;
import org.iamalexvybornyi.playwright.test.project.util.Category;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class ShoppingAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final ShopPage shopPage;

    @Step("Add product from category to cart")
    public void addProductFromCategoryToCart(@NonNull String productName, @NonNull Category category) {
        log.info("Adding product '{}' from category '{}' to cart", productName, category);
        this.driver.getLocator(shopPage.getProductNameElement().getProductName(productName)).hover();
        this.driver.getLocator(shopPage.getAddToCartButtonOfProductFromCategory(productName, category)).click();
    }

    @Step("Open cart from header")
    public void openCartFromHeader() {
        log.info("Opening cart from header");
        this.driver.getLocator(shopPage.getHeaderElement().getCartIcon()).click();
        log.info("Verifying that the checkout button is displayed");
        assertThat(this.driver.getLocator(shopPage.getHeaderElement().getCartPreviewElement().getGoToCheckoutButton())
                .isVisible()).isTrue();
    }

    @Step("Verify product is present in cart preview")
    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Verifying that the product '{}' is present in the cart", productName);
        assertThat(this.driver.getLocator(shopPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).isVisible()).isTrue();
    }
}
