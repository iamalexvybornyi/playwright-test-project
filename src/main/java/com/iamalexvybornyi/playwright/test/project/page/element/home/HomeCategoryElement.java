package com.iamalexvybornyi.playwright.test.project.page.element.home;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Element;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class HomeCategoryElement extends AbstractPageElement implements Element {

    @PageElement(selector = "//h2[text()]")
    private Locator categoryCardElement;

    public HomeCategoryElement(Locator locator) {
        super(locator);
    }
}
