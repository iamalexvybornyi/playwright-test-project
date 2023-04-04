package com.iamalexvybornyi.playwright.test.project.page.element;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HeaderElement implements Element {

    protected final String signInLink = "//a[@href='/auth']";
    protected final String signOutLink = "//span[contains(text(), 'SIGN OUT')]";
    protected final String shopLink = "//a[@href='/shop']";
    protected final String homeLink = "//*[@id='Group']/*[@id='Rectangle']";
    protected final String cartIcon = "//*[@class='shopping-icon']/..";

    @Autowired
    protected CartPreviewElement cartPreviewElement;
}
