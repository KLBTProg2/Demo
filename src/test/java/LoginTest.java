import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test
    public void test() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        softAssert.assertEquals(title, "Products", "no login");
        String title_product = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText();
        String cash_product = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
        softAssert.assertEquals(title_product, driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText());
        softAssert.assertEquals(cash_product, driver.findElement(By.cssSelector(".inventory_item_price")).getText());
        //*[@id="item_4_title_link"]/div
        softAssert.assertAll();

    }
    @Test
    public void checkLoginEmptyPassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String title = driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText();
        Assert.assertEquals(title,"Epic sadface: Password is required");

    }
}
