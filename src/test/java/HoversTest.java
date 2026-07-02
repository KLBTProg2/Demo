import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HoversTest {
//    7. * Hovers - Сделать цепочку из действий: наведение на профиль,
//    проверка имени, клик по ссылке, проверка что нет 404 ошибки. Повторить
//
//    для каждого из профилей. Использовать класс Actions и
//    https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function
//            -in-selenium-webdriver-using-java
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();
        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(user1).perform();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText().contains("user1"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        softAssert.assertFalse(driver.getTitle().toLowerCase().contains("404"));
        driver.navigate().back();

        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(user2).perform();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText().contains("user2"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        softAssert.assertFalse(driver.getTitle().toLowerCase().contains("404"));

        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(user3).perform();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText().contains("user3"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        softAssert.assertFalse(driver.getTitle().toLowerCase().contains("404"));

        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

