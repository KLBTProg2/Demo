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

public class DataTableTest {
    /*6. * Sortable Data Tables - Проверить содержимое нескольких (3-5) ячеек
    таблицы. Использовать xpath типа //table//tr[1]//td[1] - получение первой
    ячейки из первого ряда первой таблицы и так далее*/
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/tables");
//        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]")).getText(), "Smith");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[2]/td[3]")).getText(), "fbach@yahoo.com");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[4]")).getText(), "$100.00");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[4]/td[5]")).getText(), "http://www.timconway.com");

        softAssert.assertAll();
        System.out.println("Сделано");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
