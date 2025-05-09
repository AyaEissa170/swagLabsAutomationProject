package TestCases;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({AllureTestNg.class})
public class P04_checkOutTC extends P00_BaseTests {

    @Test
    public void validShoppingJourney_01() {

        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        selectProduct.addToCart(Products_Item1).addToCart(Products_Item2);
        Cart.clickCartICon();
        Checkout.checkOut().enterFirstName(checkOut_FirstName).enterLastName(checkOut_LastName).
        enterPostalCode(checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),completeOrderPageURL,"Thank you for your order!");

    }
    @Test
    public void validShoppingJourney_02() {

        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        selectProduct.addToCart(Products_Item1).addToCart(Products_Item2).addToCart(Products_Item5)
                .addToCart(Products_Item6).
       removeFromCart(Products_Item1_Remove).removeFromCart(Products_Item6_Remove);

        Cart.clickCartICon();

        Checkout.checkOut().enterFirstName(checkOut_FirstName).enterLastName(checkOut_LastName).
                enterPostalCode(checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),completeOrderPageURL,"Thank you for your order!");

    }
    @Test
    public void validShoppingJourney_03() {

        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        selectProduct.addToCart(Products_Item1).addToCart(Products_Item5).addToCart(Products_Item3);

        Cart.clickCartICon().removeFromCart(Products_Item3_Remove);


        Checkout.checkOut().enterFirstName(checkOut_FirstName).enterLastName(checkOut_LastName).
                enterPostalCode(checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(), completeOrderPageURL, "Thank you for your order!");

    }

    @Test
    public void validShoppingJourney_04() {

        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        selectProduct.addToCart(Products_Item1).addToCart(Products_Item5).addToCart(Products_Item3).
         addToCart(Products_Item2).removeFromCart(Products_Item2_Remove);

        Cart.clickCartICon().removeFromCart(Products_Item1);
        Cart.clickContinueShopping().addToCart(Products_Item4).clickCartICon();


        Checkout.checkOut().enterFirstName(checkOut_FirstName).enterLastName(checkOut_LastName).
                enterPostalCode(checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),completeOrderPageURL,"Thank you for your order!");



    }






}
