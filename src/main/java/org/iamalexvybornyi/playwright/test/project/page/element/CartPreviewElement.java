package org.iamalexvybornyi.playwright.test.project.page.element;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CartPreviewElement {
    protected final String goToCheckoutButton = "//button[contains(text(), 'GO TO CHECKOUT')]";
    @Autowired
    private ProductNameElement productNameElement;

    public String getProductFromCartPreview(@NonNull String productName) {
        return this.goToCheckoutButton + "/.." + productNameElement.getProductName(productName);
    }
}
