import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NotifMesTest {
//    8. * Notification Messages - кликнуть на кнопку, дождаться появления
//    нотификации, проверить соответствие текста ожиданиям
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        Actions action = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        softAssert.assertTrue(notification.getText().contains("Action succesful"));
        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
