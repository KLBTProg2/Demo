package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AllureUtils;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");

    private static final String ADD_TO_CART = "//*[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }
    @Step("Добавление товара с именем: {product} в корзину")
    public void addProduct(String product){
        driver.findElement(By.xpath(String.format(ADD_TO_CART, product))).click();

    }
    @Step("Нажатие на кнопку корзины")
    public void openCart(){
        driver.findElement(CART_BUTTON).click();

    }
//    public void addItemToCart(String productName){
//        driver.findElement(By.xpath("//*[text() = '" + productName + "']/ancestor::div[@class = 'inventory_item']//button")).click();
//    }
//    public void openCart(){
//        driver.findElement(By.xpath("//a[@data-test = 'shopping-cart-link']")).click();
//    }
}
