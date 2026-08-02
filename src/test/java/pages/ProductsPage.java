package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void addProduct(String product){
        driver.findElement(By.xpath(String.format(ADD_TO_CART, product))).click();
    }
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
