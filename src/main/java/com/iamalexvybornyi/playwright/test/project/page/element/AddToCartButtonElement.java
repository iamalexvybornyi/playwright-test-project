package com.iamalexvybornyi.playwright.test.project.page.element;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AddToCartButtonElement implements Element {
    private final String button = "//button[text()='Add to cart']";
}
