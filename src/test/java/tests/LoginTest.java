package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.*;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void checkCorrectLogin() {
        System.out.println("Login tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productPage.isTitlePresent());
        assertEquals(productPage.getTitle(), "Products", "Название заголовка не соответствует ожидаемому");
    }

    @DataProvider()
    public Object[][] loginData() {
        User lockUser = withLockUserPermission();
        User emptyUser = withEmptyUser();
        User emptyPassword = withEmptyPassword();

        return new Object[][]{
                {lockUser, "Epic sadface: Sorry, this user has been locked out."},
                {emptyUser, "Epic sadface: Username is required"},
                {emptyPassword, "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData", description = "Проверка некорректной авторизации")
    public void checkIncorrectLogin(User user, String errorMsg) {
        System.out.println("Login negative tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}