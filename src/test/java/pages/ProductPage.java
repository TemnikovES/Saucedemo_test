package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    final By title = By.xpath("//span[@data-test='title']");
    final By titleProducts = By.xpath("//*[text()='Products']");
    private static final String ADD_TO_CART_BTN_PATTERN = "//*[@data-test='add-to-cart-%s']";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleProducts)).isDisplayed();
    }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BTN_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }
}
