package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void test() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        SoftAssert softAssert = new SoftAssert();
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        softAssert.assertEquals(title, "Products", "no login");
        String title_product = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText();
        String cash_product = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
        softAssert.assertEquals(title_product, driver.findElement(By.xpath("//*[@id='item_4_title_link']/div")).getText());
        softAssert.assertEquals(cash_product, driver.findElement(By.cssSelector(".inventory_item_price")).getText());
        //*[@id="item_4_title_link"]/div
        softAssert.assertAll();

    }
    @Test
    public void checkLoginWithEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required", "SO BAAAD");
    }

    @Test
    public void checkLoginWithWrongPassword(){
        loginPage.open();
        loginPage.login("standard_user","1212121212121");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "SO BAAAD");
    }
    @DataProvider(name = "негативные тесты для логина")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"standard_user","1212121212121","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @Test(dataProvider = "негативные тесты для логина")
    public void login(String user, String password,String message){
        loginPage.open();
        loginPage.login(user,password);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "SO BAAAD");
    }
    @Test
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Позитивный логин")
    public void checkSuccessLogin(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(), "Products", "Логин не выполнен");
    }
}
