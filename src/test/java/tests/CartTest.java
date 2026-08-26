package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    @Epic("Корзина")
    @Feature("Добавление товара")
    @Story("Отображение товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("кекв ситуэйшн")
    @Description("проверка товара")
    @Link(name = "документация", url = "https://www.saucedemo.com/")
    @TmsLink("TMS_T10")
    @Issue("TMS_T11")
    public void test(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
    }
}
