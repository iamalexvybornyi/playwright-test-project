package org.iamalexvybornyi.playwright.test.project.page;

import org.iamalexvybornyi.playwright.test.project.page.element.HeaderElement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasePage {
    @Autowired
    protected HeaderElement headerElement;
}
