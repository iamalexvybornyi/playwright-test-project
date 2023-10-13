package com.iamalexvybornyi.playwright.test.project.page.core;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@AllArgsConstructor
public class PageElementCollection<T extends AbstractPageElement> {

    @NonNull
    private final Supplier<Locator> elementSupplier;
    @NonNull
    private final Function<Locator, T> elementsInitializer;

    @NonNull
    public Stream<T> stream() {
        return elementSupplier.get().all().stream().map(elementsInitializer);
    }
}
