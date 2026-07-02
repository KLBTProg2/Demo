import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class CheckBoxTest {
    /*2. Checkboxes - проверить, что первый чекбокс unchecked, отметить
    первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
    checked, сделать unheck, проверить, что он unchecked
    Локатор: By.cssSelector("[type=checkbox]”)*/
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        List<WebElement> checkboxs = driver.findElements(By.cssSelector("[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(checkboxs.get(0).isSelected());
        checkboxs.get(0).click();
        softAssert.assertTrue(checkboxs.get(0).isSelected());

        softAssert.assertTrue(checkboxs.get(0).isSelected());
        checkboxs.get(0).click();
        softAssert.assertFalse(checkboxs.get(0).isSelected());
        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
