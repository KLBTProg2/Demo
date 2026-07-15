package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECK_OUT = By.id("checkout");
    private static final By CONTINUE = By.id("continue");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By POSTAL_CODE = By.id("postal-code");
    private static final String TOTAL = "[data-test = 'subtotal-label']";
    private final By inventoryItemsSelector = By.cssSelector("[data-test='inventory-item']");

    public void checkOutClick(){
        driver.findElement(CHECK_OUT).click();
    }
    public void setUserData(String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }
    public void continueClick(){
        driver.findElement(CONTINUE).click();
    }
    public double returnTotalSum(){
        String total = driver.findElement(By.cssSelector(TOTAL)).getText();
        String priceText = total.replaceAll("[^0-9.]", "");
        double sum;
        return sum = Double.parseDouble(priceText);
    }
    public int getItemsCount() {
        return driver.findElements(inventoryItemsSelector).size();
    }
    public double getItemsCost(){
        List<WebElement> items = driver.findElements(inventoryItemsSelector);
        double sum = 0;
        for (WebElement item : items) {

            WebElement priceElement = item.findElement(By.cssSelector("[data-test='inventory-item-price']"));
            String priceText = priceElement.getText();
            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
            sum+= price;
        }
        return sum;
    }
    //*[@id="checkout_summary_container"]/div/div[2]/div[6]/text()[2]
}
