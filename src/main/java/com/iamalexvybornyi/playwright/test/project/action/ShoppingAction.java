package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.ShopPage;
import com.iamalexvybornyi.playwright.test.project.util.Category;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
@Service
public class ShoppingAction {
    @NonNull
    private final ThreadLocal<Driver> driver;
    @NonNull
    private final ShopPage shopPage;

    public void addProductFromCategoryToCart(@NonNull String productName, @NonNull Category category) {
        this.driver.get().getLocator(shopPage.getProductNameElement().getProductName(productName)).hover();
        this.driver.get().getLocator(shopPage.getAddToCartButtonOfProductFromCategory(productName, category)).click();
    }

    public void openCartFromHeader() {
        this.driver.get().getLocator(shopPage.getHeaderElement().getCartIcon()).click();
        assertThat(this.driver.get().getLocator(shopPage.getHeaderElement().getCartPreviewElement().getGoToCheckoutButton())
                .isVisible()).isTrue();
    }

    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        assertThat(this.driver.get().getLocator(shopPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName)).isVisible()).isTrue();
    }
}
