package com.iamalexvybornyi.playwright.test.project.page.element;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProductNameElement implements Element {
    private static final String PRODUCT_NAME_TEMPLATE = "//span[text()='%s']";

    public String getProductName(@NonNull String productName) {
        return String.format(PRODUCT_NAME_TEMPLATE, productName);
    }
}
