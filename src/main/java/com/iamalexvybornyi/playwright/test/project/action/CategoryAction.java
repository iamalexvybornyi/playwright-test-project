package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.CategoryPage;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
@Service
public class CategoryAction {
    @NonNull
    private final Driver driver;
    @NonNull
    private final CategoryPage categoryPage;

    public void addProductToCart(@NonNull String productName) {
        this.driver.getLocator(categoryPage.getProductNameElement().getProductName(productName)).hover();
        this.driver.getLocator(categoryPage.getAddToCartButtonOfProduct(productName)).click();
    }

    public void openCartFromHeader() {
        this.driver.getLocator(categoryPage.getHeaderElement().getCartIcon()).click();
        assertThat(this.driver.getLocator(categoryPage.getHeaderElement().getCartPreviewElement()
                .getGoToCheckoutButton()).isVisible()).isTrue();
    }

    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        assertThat(this.driver.getLocator(categoryPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).isVisible()).isTrue();
    }
}
