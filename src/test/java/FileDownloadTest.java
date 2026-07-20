import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class FileDownloadTest {
    @Test
    public void text() throws InterruptedException {
        String customDownloadPath = "E:\\IntelliJ IDEA 2026.1\\Project\\Demo\\src\\test\\java";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory",  customDownloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        File folder = new File(customDownloadPath);
        String fileName = "Workbook1.xlsx";
        File file = new File(folder, fileName);
        if (file.exists()) {
            file.delete();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Workbook1.xlsx"))).click();
        wait.until(driver1 -> {
            File crdownload = new File(folder, fileName + ".crdownload");
            return file.exists() && !crdownload.exists() && file.length() > 0;
        });
    }
}
