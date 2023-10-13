package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.page.core.Page;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.iamalexvybornyi.playwright.test.project.page.element.common.HeaderElement;
import com.iamalexvybornyi.playwright.test.project.page.element.shop.ShopCategoryElement;
import com.iamalexvybornyi.playwright.test.project.util.Category;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class ShopPage implements Page {

    @PageElement(selector = "//div[@id='root']/div[1]")
    protected HeaderElement headerElement;

    @PageElements(selector = "//h2/..", elementClass = ShopCategoryElement.class)
    private PageElementCollection<ShopCategoryElement> shopCategoryElements;

    @NonNull
    public Locator getAddToCartButtonOfProductFromCategory(@NonNull String productName, @NonNull Category categoryName) {
        return getShopCategoryElementFromName(categoryName)
                .getProductCardElementByName(productName)
                .getAddToCartButton();
    }

    @NonNull
    public ShopCategoryElement getShopCategoryElementFromName(@NonNull Category category) {
        return getShopCategoryElements().stream().filter(shopCategoryElement ->
                shopCategoryElement.getCategoryHeader().textContent().equals(category.name()))
                // TODO: Add a new custom exception
                .findFirst().orElseThrow();
    }
}
