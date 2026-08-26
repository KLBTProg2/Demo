package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class СartPage extends BasePage {

    public СartPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL + "/cart.gtml");
    }

    public boolean isProductInCart(String product){
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//*[text()='%s']",product))).isDisplayed();
    }

    public String getProductFromCart(int index){
        return driver.findElements(By.cssSelector(".inventory_item_name")).get(index).getText();
    }

    public ArrayList<String> getProductsName(){
        List<WebElement> allProductElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for(WebElement product: allProductElements){
            names.add(product.getText());
        }
        return names;
    }

    public double getProductPrice(String product){
        return Double.parseDouble(driver.findElement(By.xpath(String.format("//*[text() = '%s']/ancestor::div[@class = 'cart_item']//" +
                "*[@class = 'inventory_item_price']", product))).getText().replace("$",""));
    }
}
