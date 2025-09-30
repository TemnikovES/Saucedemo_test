package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {
    @Test(description = "проверка товаров")
    public void checkToCartTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart(0);
        productPage.addToCart(1);
        productPage.addToCart(2);
        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }

}
