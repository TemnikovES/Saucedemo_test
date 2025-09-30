package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    final By title = By.xpath("//span[@data-test='title']");
    final By title2 = By.xpath("//*[text()='Products']");
    final By goodsTitle = By.xpath("//*[@data-test = 'shopping-cart-badge']");
    final By linkToCart = By.xpath("//*[@data-test='shopping-cart-link']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Add to cart']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//*[text() = '%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By CART_BADGE = By.xpath("//*[@data-test = 'shopping-cart-badge']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
    }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int goodsIndex) {
        driver.findElements(ADD_TO_CART_BUTTON).get(goodsIndex).click();
    }

    public void openCart() {
        driver.findElement(linkToCart).click();
    }

    public void addToCartByProductIndex(int goodsIndex) {
        By ADD_TO_CART_BTN = By.xpath("//*[text()='Add to cart']");
        driver.findElements(ADD_TO_CART_BTN).get(goodsIndex).click();
    }

    public void addProductsToCart(int goodsNumber) {
        for (int i = 0; i < goodsNumber; i++) {
            this.addToCartByProductIndex(0);
        }

    }

    public String getNumberCart() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(CART_BADGE)).getText();
    }

    public String getProductName(int goodIndex) {
        return driver.findElements(goodsTitle).get(goodIndex).getText();
    }

    public int getProductQuantity() {
        return driver.findElements(goodsTitle).size();
    }

}
