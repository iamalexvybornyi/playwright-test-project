package com.iamalexvybornyi.playwright.test.project.page.element.common;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class ProductCardElement extends AbstractPageElement implements Element {

    @PageElement(selector = "//button[text()='Add to cart']")
    private Locator addToCartButton;
    @PageElement(selector = "//span[1]")
    private Locator productNameLabel;
    @PageElement(selector = "//span[2]")
    private Locator productPriceLabel;

    public ProductCardElement(Locator locator) {
        super(locator);
    }
}
