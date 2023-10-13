package com.iamalexvybornyi.playwright.test.project.action;

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
    private final CategoryPage categoryPage;

    @Step("Add product to cart")
    public void addProductToCart(@NonNull String productName) {
        log.info("Adding product {} to cart", productName);
        categoryPage.getProductCardElementByName(productName).getLocator().hover();
        categoryPage.getProductCardElementByName(productName).getAddToCartButton().click();
    }

    @Step("Open cart from header")
    public void openCartFromHeader() {
        log.info("Opening cart from header");
        categoryPage.getHeaderElement().getCartIcon().click();
        log.info("Checking the cart preview is open");
        assertThat(categoryPage.getHeaderElement().getCartPreviewElement()
                .getGoToCheckoutButton().isVisible()).isTrue();
    }

    @Step("Verify product is present in cart preview")
    public void verifyProductIsPresentInCartPreview(@NonNull String productName) {
        log.info("Checking the product '{}' is present in the cart preview", productName);
        assertThat(categoryPage.getHeaderElement().getCartPreviewElement()
                .getProductFromCartPreview(productName).getLocator().isVisible()).isTrue();
    }
}
