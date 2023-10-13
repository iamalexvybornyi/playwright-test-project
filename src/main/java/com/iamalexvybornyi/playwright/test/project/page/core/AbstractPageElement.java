package com.iamalexvybornyi.playwright.test.project.page.core;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractPageElement {
    private final Locator locator;
}
