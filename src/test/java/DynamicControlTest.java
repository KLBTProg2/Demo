import org.openqa.selenium.Alert;
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

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class DynamicControlTest {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void alertTest(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        actions.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().perform();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(),"You selected a context menu");
        alert.accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/java/bla.txt");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']")));
    }

    @Test
    public void frameTest(){
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("iFrame")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
        String text = driver.findElement(By.xpath("//*[@id = 'tinymce']")).getText();
        assertEquals(text,"Your content goes here.");
        driver.switchTo().defaultContent();
    }
    @Test
    public void checkDynamicControlTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        int numberOfElements = driver.findElements(By.id("checkbox")).size();
//        assertEquals(numberOfElements,0);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

//        driver.switchTo().frame();
//        Actions actions = new Actions(driver);

    }
    @Test
    public void checkEnableField() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        assertFalse(driver.findElement(By.cssSelector("[type='text']")).isEnabled());
        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Boolean isEnable = driver.findElement(By.cssSelector("[type='text']")).isEnabled();
        assertEquals(isEnable,true);


    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
