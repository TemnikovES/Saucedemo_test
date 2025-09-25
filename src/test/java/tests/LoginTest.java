package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        assertTrue(productPage.isTitlePresent());
    }

    @Test(description = "Проверка авторизации заблокированного пользователя")
    public void checkLockedOutUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Проверка авторизации без ввода Логина")
    public void checkWithoutUsernameLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test(description = "Проверка авторизации без ввода Пароля")
    public void checkWithoutPasswordLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("locked_out_user", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Password is required");
    }

}