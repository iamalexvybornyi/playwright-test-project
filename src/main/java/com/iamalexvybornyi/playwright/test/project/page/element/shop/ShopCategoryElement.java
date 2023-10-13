package com.iamalexvybornyi.playwright.test.project.page.element.shop;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.iamalexvybornyi.playwright.test.project.page.element.common.ProductCardElement;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ShopCategoryElement extends AbstractPageElement implements Element {

    @PageElement(selector = "//h2")
    private Locator categoryHeader;
    @PageElements(selector = "//button[text()='Add to cart']/..", elementClass = ProductCardElement.class)
    private PageElementCollection<ProductCardElement> productCardElements;

    public ShopCategoryElement(Locator locator) {
        super(locator);
    }

    @NonNull
    public ProductCardElement getProductCardElementByName(@NonNull String productName) {
        return getProductCardElements().stream().filter(productCardElement ->
                productCardElement.getProductNameLabel().textContent().equals(productName))
                // TODO: Add a new custom exception
                .findFirst().orElseThrow();
    }
}
