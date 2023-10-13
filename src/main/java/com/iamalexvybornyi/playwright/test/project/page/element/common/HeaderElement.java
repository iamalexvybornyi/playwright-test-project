package com.iamalexvybornyi.playwright.test.project.page.element.common;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.iamalexvybornyi.playwright.test.project.page.element.cart.CartPreviewElement;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class HeaderElement extends AbstractPageElement implements Element {
    @PageElement(selector = "//a[@href='/auth']")
    private Locator signInLink;
    @PageElement(selector = "//span[contains(text(), 'SIGN OUT')]")
    private Locator signOutLink;
    @PageElement(selector = "//a[@href='/shop']")
    private Locator shopLink;
    @PageElement(selector = "//*[@id='Group']/*[@id='Rectangle']")
    private Locator homeLink;
    @PageElement(selector = "//*[@class='shopping-icon']/..")
    private Locator cartIcon;
    @PageElement(selector = "//button[contains(text(), 'GO TO CHECKOUT')]/..")
    protected CartPreviewElement cartPreviewElement;

    public HeaderElement(Locator locator) {
        super(locator);
    }
}
