package com.iamalexvybornyi.playwright.test.project.page;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HomePage implements Page {
    private final String signInLink = "//a[@href='/auth']";
    private final String signOutLink = "//span[contains(text(), 'SIGN OUT')]";
    private final String shopLink = "//a[@href='/shop']";
    private final String homeLink = "//*[@id='Group']/*[@id='Rectangle']";
}
