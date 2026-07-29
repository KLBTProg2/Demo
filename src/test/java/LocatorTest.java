import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class LocatorTest extends BaseTest {
    @Test
    public void test() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Linked"));
        driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//button[text()='Add to cart']"));
        driver.findElement(By.xpath("//div[contains(@class,'app_logo')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
        driver.findElement(By.xpath("//*[text() = 'Swag Labs']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class = 'inventory_item_description']//descendant::div"));
        driver.findElement(By.xpath("//*[text() = 'Swag Labs']//following::div"));
        driver.findElement(By.xpath("//*[text() = 'Swag Labs']//parent::div"));
        driver.findElement(By.xpath("//*[text() = 'Swag Labs']//preceding::div"));

        driver.findElement(By.cssSelector(".inventory_list"));
        driver.findElement(By.cssSelector("div.inventory_list .inventory_item"));
        driver.findElement(By.cssSelector("button.btn.btn_primary"));
        driver.findElement(By.cssSelector("#shopping_cart_container"));
        driver.findElement(By.cssSelector("div"));
        driver.findElement(By.cssSelector("div.inventory_list"));
        driver.findElement(By.cssSelector("[class = 'header_label']"));
        driver.findElement(By.cssSelector("[class ~= 'btn_primary']"));
        driver.findElement(By.cssSelector("[data-test |= 'inventory']"));
        driver.findElement(By.cssSelector("[class ^= 'inventory']"));
        driver.findElement(By.cssSelector("[data-test $= 'name']"));
        driver.findElement(By.cssSelector("[data-test *= 'name']"));

    }

}
