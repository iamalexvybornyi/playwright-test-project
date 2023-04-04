package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.page.element.HeaderElement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasePage {
    @Autowired
    protected HeaderElement headerElement;
}
