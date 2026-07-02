import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TyposTest {
    /*Typos - Проверить соответствие параграфа орфографии
    Локатор: By.tagName(“p”)*/
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.tagName("p"));
        SoftAssert softAssert = new SoftAssert();
        String paragraph = typos.getText();
        JLanguageTool langTool = new JLanguageTool( new BritishEnglish());
        try {
            List<RuleMatch> matches = langTool.check(paragraph);
            softAssert.assertEquals(matches.size(),0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        input.clear();
//        softAssert.assertEquals(input.getText(),"");

        softAssert.assertAll();
        System.out.println("Сделано");
    }
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
}
