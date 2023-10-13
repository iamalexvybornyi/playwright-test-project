package com.iamalexvybornyi.playwright.test.project.annotation;

import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import lombok.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PageElements {
    @NonNull
    String selector();
    @NonNull
    Class<? extends AbstractPageElement> elementClass();
}
