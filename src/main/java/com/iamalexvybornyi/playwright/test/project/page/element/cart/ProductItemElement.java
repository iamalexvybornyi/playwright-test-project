package com.iamalexvybornyi.playwright.test.project.page.element.cart;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class ProductItemElement extends AbstractPageElement implements Element {

    @PageElement(selector = "//span[1]")
    private Locator productName;
    @PageElement(selector = "//span[2]")
    private Locator priceAndQuantityInfo;

    public ProductItemElement(Locator locator) {
        super(locator);
    }
}
