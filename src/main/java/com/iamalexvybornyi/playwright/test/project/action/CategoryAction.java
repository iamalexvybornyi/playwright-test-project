package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.CategoryPage;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final CategoryPage categoryPage;

    @Step("Add product to cart")
    public void addProductToCart(@NonNull String productName) {
        log.info("Adding product {} to cart", productName);
        this.driver.getLocator(categoryPage.getProductNameElement().getProductName(productName)).hover();
        this.driver.getLocator(categoryPage.getAddToCartButtonOfProduct(productName)).click();
    }

    @Step("Open cart from header")
    public void openCartFromHeader() {
        log.info("Opening cart from header");
        this.driver.getLocator(categoryPage.getHeaderElement().getCartIcon()).click();
        log.info("Checking the cart preview is open");
        assertThat(this.driver.getLocator(categoryPage.getHeaderElement().getCartPreviewElement()
                .getGoToCheckoutButton()).isVisible()).isTrue();
    }

    @Step("Verify product is present in cart preview")
    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Checking the product '{}' is present in the cart preview", productName);
        assertThat(this.driver.getLocator(categoryPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).isVisible()).isTrue();
    }
}
