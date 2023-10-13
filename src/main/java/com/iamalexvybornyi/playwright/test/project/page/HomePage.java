package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.page.core.Page;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.iamalexvybornyi.playwright.test.project.page.element.common.HeaderElement;
import com.iamalexvybornyi.playwright.test.project.page.element.home.HomeCategoryElement;
import com.iamalexvybornyi.playwright.test.project.util.Category;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class HomePage implements Page {

    @PageElement(selector = "//div[@id='root']/div[1]")
    protected HeaderElement headerElement;

    @PageElements(selector = "//h2[text()]/../..", elementClass = HomeCategoryElement.class)
    private PageElementCollection<HomeCategoryElement> homeCategoryElements;

    @NonNull
    public HomeCategoryElement getHomeCategoryElementByName(@NonNull Category category) {
        return getHomeCategoryElements().stream().filter(homeCategoryElement ->
                homeCategoryElement.getCategoryCardElement().textContent().equals(category.name()))
                // TODO: Add a new custom exception
                .findFirst().orElseThrow();
    }
}
