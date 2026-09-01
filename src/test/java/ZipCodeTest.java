import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ZipCodeTest {
//    @Test
//    public void checkZipCode4Digits() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver browser = new ChromeDriver();
//        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
//        browser.get("https://www.sharelane.com/cgi-bin/register.py");
//        browser.findElement(By.name("zip_code")).sendKeys("1234 ");
//        browser.findElement(By.cssSelector("[value=Continue]")).click();
//        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
//        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
//        browser.quit();
//
//    }
//
//    @Test
//    public void checkZipCodeSignUp() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver browser = new ChromeDriver();
//        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
//        browser.get("https://www.sharelane.com/cgi-bin/register.py");
//        browser.findElement(By.name("zip_code")).sendKeys("12345");
//        browser.findElement(By.cssSelector("[value=Continue]")).click();
//
//        //<span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
//        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
//        String number = browser.findElement(By.name("page")).getAttribute("value");
//        if(number.equals("2"))
//            System.out.println("перешел на страницу 2");
//        browser.quit();
        //<input type="text" name="zip_code" value="">
        //<input type="submit" value="Continue">
//    }


}
