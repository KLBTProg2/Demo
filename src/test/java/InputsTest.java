import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class InputsTest {
//    4. Inputs - Проверить на возможность ввести различные цифровые и
//    нецифровые значения, используя Keys.ARROW_UP И
//    Keys.ARROW_DOWN
//    Локатор: By.tagName(“input”)
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        SoftAssert softAssert = new SoftAssert();

        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(input.getAttribute("value"),"1");
        input.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(input.getAttribute("value"),"0");
        input.clear();
        input.sendKeys("1.4e.");

        softAssert.assertEquals(input.getAttribute("value"),"");
//        input.clear();
//        softAssert.assertEquals(input.getText(),"");

        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
