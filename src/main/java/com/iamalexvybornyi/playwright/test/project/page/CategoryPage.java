package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.page.core.Page;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.iamalexvybornyi.playwright.test.project.page.element.common.HeaderElement;
import com.iamalexvybornyi.playwright.test.project.page.element.common.ProductCardElement;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class CategoryPage implements Page {

    @PageElement(selector = "//div[@id='root']/div[1]")
    protected HeaderElement headerElement;

    @PageElements(selector = "//button[text()='Add to cart']/..", elementClass = ProductCardElement.class)
    private PageElementCollection<ProductCardElement> productCardElements;

    @NonNull
    public ProductCardElement getProductCardElementByName(@NonNull String productName) {
        return getProductCardElements().stream().filter(productCardElement ->
                productCardElement.getProductNameLabel().textContent().equals(productName))
                // TODO: Add a new custom exception
                .findFirst().orElseThrow();
    }
}
