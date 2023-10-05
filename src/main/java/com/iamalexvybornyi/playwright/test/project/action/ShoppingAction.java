package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.ShopPage;
import com.iamalexvybornyi.playwright.test.project.util.Category;
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

    public void addProductFromCategoryToCart(@NonNull String productName, @NonNull Category category) {
        log.info("Adding product '{}' from category '{}' to cart", productName, category);
        this.driver.getLocator(shopPage.getProductNameElement().getProductName(productName)).hover();
        this.driver.getLocator(shopPage.getAddToCartButtonOfProductFromCategory(productName, category)).click();
    }

    public void openCartFromHeader() {
        log.info("Opening cart from header");
        this.driver.getLocator(shopPage.getHeaderElement().getCartIcon()).click();
        log.info("Verifying that the checkout button is displayed");
        assertThat(this.driver.getLocator(shopPage.getHeaderElement().getCartPreviewElement().getGoToCheckoutButton())
                .isVisible()).isTrue();
    }

    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Verifying that the product '{}' is present in the cart", productName);
        assertThat(this.driver.getLocator(shopPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).isVisible()).isTrue();
    }
}
