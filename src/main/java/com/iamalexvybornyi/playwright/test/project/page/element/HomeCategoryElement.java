package com.iamalexvybornyi.playwright.test.project.page.element;

import com.iamalexvybornyi.playwright.test.project.util.Category;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class HomeCategoryElement implements Element {

    private static final String CATEGORY_HEADER_TEMPLATE = "//h2[text()='%s']";

    @NonNull
    public String getCategory(@NonNull Category categoryName) {
        return String.format(CATEGORY_HEADER_TEMPLATE, categoryName.toString().toLowerCase());
    }
}
