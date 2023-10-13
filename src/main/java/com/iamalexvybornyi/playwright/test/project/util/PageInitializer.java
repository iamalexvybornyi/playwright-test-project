package com.iamalexvybornyi.playwright.test.project.util;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.annotation.PageElements;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.page.core.AbstractPageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Page;
import com.iamalexvybornyi.playwright.test.project.page.core.PageElementCollection;
import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PageInitializer {

    @NonNull
    private final Driver driver;
    @NonNull
    private final List<Page> allPages;

    public void initPages() {
        allPages.forEach(this::initElements);
    }

    public <T> T initElements(@NonNull T pageOrElement) {
        final List<Field> allObjectFields = getAllObjectFields(pageOrElement.getClass());

        allObjectFields.forEach(field -> {
            field.trySetAccessible();
            if (Locator.class.isAssignableFrom(field.getType()) && field.isAnnotationPresent(PageElement.class)) {
                final String selector = field.getAnnotation(PageElement.class).selector();
                if (pageOrElement instanceof Page) {
                    initLocator(field, pageOrElement, driver.getLocator(selector));
                } else {
                    initLocator(field, pageOrElement, ((AbstractPageElement) pageOrElement).getLocator().locator(selector));
                }
            } else if (field.isAnnotationPresent(PageElement.class)) {
                final String selector = field.getAnnotation(PageElement.class).selector();
                if (pageOrElement instanceof Page) {
                    initElement(field, pageOrElement, driver.getLocator(selector));
                } else {
                    initElement(field, pageOrElement, ((AbstractPageElement) pageOrElement).getLocator().locator(selector));
                }
            } else if (field.isAnnotationPresent(PageElements.class)) {
                final String selector = field.getAnnotation(PageElements.class).selector();
                if (pageOrElement instanceof Page) {
                    initElements(field, pageOrElement, driver.getLocator(selector));
                } else {
                    initElements(field, pageOrElement, ((AbstractPageElement) pageOrElement).getLocator().locator(selector));
                }
            }
        });
        return pageOrElement;
    }

    @NonNull
    private List<Field> getAllObjectFields(@NonNull Class<?> aClass) {
        final List<Field> fields = new ArrayList<>(Arrays.asList(aClass.getDeclaredFields()));

        if (aClass.getSuperclass() != null) {
            fields.addAll(getAllObjectFields(aClass.getSuperclass()));
        }

        return fields;
    }

    private <T> void initElement(@NonNull Field field, @NonNull T page, @NonNull Locator locator) {
        try {
            field.set(page, field.getType().getConstructor(Locator.class).newInstance(locator));
            initElements(field.get(page));
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void initLocator(@NonNull Field field, @NonNull T pageOrElement, @NonNull Locator locator) {
        try {
            field.set(pageOrElement, locator);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void initElements(@NonNull Field field, @NonNull T pageOrElement, @NonNull Locator elementsLocator) {
        final Class<? extends AbstractPageElement> elementClass = field.getAnnotation(PageElements.class).elementClass();
        try {
            field.set(pageOrElement, new PageElementCollection<>(() -> elementsLocator, (Locator locator) -> {
                final AbstractPageElement pageElement;
                try {
                    pageElement = elementClass.getConstructor(Locator.class).newInstance(locator);
                } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                return initElements(pageElement);
            }));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
