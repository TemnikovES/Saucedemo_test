package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {
    @Test(description = "проверка товаров")
    public void checkToCartTest() {
        System.out.println("AddGoods tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productPage.addToCart(0);
        productPage.addToCart(1);
        productPage.addToCart(2);
        loginPage.open("cart.html");
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
