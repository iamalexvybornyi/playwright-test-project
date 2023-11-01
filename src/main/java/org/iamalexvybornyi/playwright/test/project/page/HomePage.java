package org.iamalexvybornyi.playwright.test.project.page;

import org.iamalexvybornyi.playwright.test.project.page.element.HomeCategoryElement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HomePage extends BasePage implements Page {
    @Autowired
    private HomeCategoryElement homeCategoryElement;
}
