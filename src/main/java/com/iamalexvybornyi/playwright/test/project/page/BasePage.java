package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.element.common.HeaderElement;
import lombok.Getter;

@Getter
public abstract class BasePage {

    @PageElement(selector = "//div[@id='root']/div[1]")
    protected HeaderElement headerElement;

}
