import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class DropDownTest {
    /*3. Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
    Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что
    он выбран
    Локатор: By.id(“dropdown”)*/
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
//        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));

        WebElement dd = driver.findElement(By.id("dropdown"));
        Select select = new Select(dd);
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> options = select.getOptions();
        softAssert.assertEquals(options.size(), 3);
        select.selectByIndex(1);
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Option 1");
        select.selectByIndex(2);
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
