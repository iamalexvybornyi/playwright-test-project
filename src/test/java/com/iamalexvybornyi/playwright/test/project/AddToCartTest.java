package com.iamalexvybornyi.playwright.test.project;

import com.iamalexvybornyi.playwright.test.project.action.CategoryAction;
import com.iamalexvybornyi.playwright.test.project.action.CommonAction;
import com.iamalexvybornyi.playwright.test.project.action.ShoppingAction;
import com.iamalexvybornyi.playwright.test.project.util.Category;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@Slf4j
public class AddToCartTest extends BaseTest {

    @Autowired
    private ShoppingAction shoppingAction;
    @Autowired
    private CommonAction commonAction;
    @Autowired
    private CategoryAction categoryAction;

    @ParameterizedTest
    @MethodSource("provideCategoriesWithProducts")
    public void addProductToCartFromShop(@NonNull Category categoryName, @NonNull String productName) {
        navigationAction.goToShopPage();
        shoppingAction.addProductFromCategoryToCart(productName, categoryName);
        shoppingAction.openCartFromHeader();
        shoppingAction.verifyProductIsPresentInCartPreview(productName);
    }

    @ParameterizedTest
    @MethodSource("provideCategoriesWithProducts")
    public void addProductToCartFromCategory(@NonNull Category categoryName, @NonNull String productName) {
        commonAction.navigateToCategoryFromHomePage(categoryName);
        categoryAction.addProductToCart(productName);
        categoryAction.openCartFromHeader();
        categoryAction.verifyProductIsPresentInCartPreview(productName);
    }

    private static Stream<Arguments> provideCategoriesWithProducts() {
        return Stream.of(
                Arguments.of(Category.HATS, "Brown Brim"),
                Arguments.of(Category.JACKETS, "Black Jean Shearling"),
                Arguments.of(Category.MENS, "Camo Down Vest"),
                Arguments.of(Category.SNEAKERS, "Adidas NMD"),
                Arguments.of(Category.WOMENS, "Blue Tanktop")
        );
    }
}
