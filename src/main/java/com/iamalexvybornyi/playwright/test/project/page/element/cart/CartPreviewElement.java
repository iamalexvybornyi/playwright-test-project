package com.iamalexvybornyi.playwright.test.project.page.element.cart;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class CartPreviewElement extends AbstractPageElement implements Element {

    @PageElement(selector = "//button[contains(text(), 'GO TO CHECKOUT')]")
    private Locator goToCheckoutButton;
    @PageElements(selector = "/div/div", elementClass = ProductItemElement.class)
    private PageElementCollection<ProductItemElement> productItems;

    public CartPreviewElement(Locator locator) {
        super(locator);
    }

    @NonNull
    public ProductItemElement getProductFromCartPreview(@NonNull String productName) {
        return productItems.stream().filter(productItemElement ->
                productItemElement.getProductName().textContent().equals(productName))
                // TODO: Add a new custom exception
                .findFirst().orElseThrow();
    }
}
