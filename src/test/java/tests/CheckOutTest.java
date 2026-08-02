package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CheckOutTest extends BaseTest{
        @Test
        public void test(){
            loginPage.open();
            loginPage.login("standard_user","secret_sauce");
            productsPage.addProduct("Sauce Labs Backpack");
            productsPage.addProduct("Sauce Labs Bike Light");
            productsPage.openCart();
            softAssert.assertEquals(2, checkOutPage.getItemsCount());
            checkOutPage.checkOutClick();
            checkOutPage.setUserData("Dima","Don","5555");
            checkOutPage.continueClick();
            double productPrice = checkOutPage.getItemsCost();
            double pageTotalSum = checkOutPage.returnTotalSum();
            softAssert.assertEquals(productPrice, pageTotalSum);
            softAssert.assertAll();
        }

}
