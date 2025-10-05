package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.*;
import user.User;

import static enums.DepartmentNaming.*;
import static enums.ErrorMessage.*;
import static org.testng.Assert.*;
import static user.UserFactory.*;

@Listeners(AllureTestNg.class)
public class LoginTest extends BaseTest {

    @Epic("Модуль логин")
    @Feature("Физические лица")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Temnikov Evgeniy, Gism092@mail.ru")
    @TmsLink("Saucedemo_test")
    @Issue("Saucedemo_test")
    @Test(description = "Проверка корректной авторизации")
    public void checkCorrectLogin() {
        System.out.println("Login tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productPage.isTitlePresent());
        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName(), "Название заголовка не соответствует ожидаемому");
    }

    @DataProvider()
    public Object[][] loginData() {
        User lockUser = withLockUserPermission();
        User emptyUser = withEmptyUser();
        User emptyPassword = withEmptyPassword();

        return new Object[][]{
                {lockUser, USER_LOCK_MSG.getDisplayName()},
                {emptyUser, EMPTY_USER_MSG.getDisplayName()},
                {emptyPassword, EMPTY_PASSWORD_MSG.getDisplayName()}
        };
    }

    @Epic("Модуль логин")
    @Feature("Физические лица")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Temnikov Evgeniy, Gism092@mail.ru")
    @TmsLink("Saucedemo_test")
    @Issue("Saucedemo_test")
    @Test(dataProvider = "loginData", description = "Проверка некорректной авторизации")
    public void checkIncorrectLogin(User user, String errorMsg) {
        System.out.println("Login negative tests are running in thread:" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}