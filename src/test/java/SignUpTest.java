import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignUpTest {
    @Test
    public void checkSignUpValidData(){
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        String number = browser.findElement(By.name("page")).getAttribute("value");
        if(number.equals("2"))
            System.out.println("перешел на страницу 2");
        browser.findElement(By.name("first_name")).sendKeys("Dima");
        browser.findElement(By.name("last_name")).sendKeys("Akurok");
        browser.findElement(By.name("email")).sendKeys("goida@gmail.com");
        browser.findElement(By.name("password1")).sendKeys("hih231");
        browser.findElement(By.name("password2")).sendKeys("hih231");

        browser.findElement(By.cssSelector("[value=Register]")).click();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        String actualMessage = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(actualMessage, "Account is created!");

        String email = browser.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b"))
                .getText();
        String password = browser.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]"))
                .getText();
        browser.get("https://www.sharelane.com/cgi-bin/main.py");
        browser.findElement(By.name("email")).sendKeys(email);
        browser.findElement(By.name("password")).sendKeys(password);
        browser.findElement(By.cssSelector("[value=Login]")).click();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        Assert.assertTrue(logout.isDisplayed(), "не нашел");
    }
}
