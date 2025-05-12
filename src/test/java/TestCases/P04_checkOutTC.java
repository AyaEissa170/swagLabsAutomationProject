package TestCases;

import Utilities.Constants;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({AllureTestNg.class})
public class P04_checkOutTC extends P00_BaseTests {

    @Test
    public void validShoppingJourney_01() {

        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin();
        selectProduct.addToCart(Constants.Products_Item1).addToCart(Constants.Products_Item2);
        Cart.clickCartICon();
        Checkout.checkOut().enterFirstName(Constants.checkOut_FirstName).enterLastName(Constants.checkOut_LastName).
        enterPostalCode(Constants.checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),Constants.completeOrderPageURL,"Thank you for your order!");

    }
    @Test
    public void validShoppingJourney_02() {

        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin();
        selectProduct.addToCart(Constants.Products_Item1).addToCart(Constants.Products_Item2).addToCart(Constants.Products_Item5)
                .addToCart(Constants.Products_Item6).
       removeFromCart(Constants.Products_Item1_Remove).removeFromCart(Constants.Products_Item6_Remove);

        Cart.clickCartICon();

        Checkout.checkOut().enterFirstName(Constants.checkOut_FirstName).enterLastName(Constants.checkOut_LastName).
                enterPostalCode(Constants.checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),Constants.completeOrderPageURL,"Thank you for your order!");

    }
    @Test
    public void validShoppingJourney_03() {

        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin();
        selectProduct.addToCart(Constants.Products_Item1).addToCart(Constants.Products_Item5).addToCart(Constants.Products_Item3);

        Cart.clickCartICon().removeFromCart(Constants.Products_Item3_Remove);


        Checkout.checkOut().enterFirstName(Constants.checkOut_FirstName).enterLastName(Constants.checkOut_LastName).
                enterPostalCode(Constants.checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(), Constants.completeOrderPageURL, "Thank you for your order!");

    }

    @Test
    public void validShoppingJourney_04() {

        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin();
        selectProduct.addToCart(Constants.Products_Item1).addToCart(Constants.Products_Item5).addToCart(Constants.Products_Item3).
         addToCart(Constants.Products_Item2).removeFromCart(Constants.Products_Item2_Remove);

        Cart.clickCartICon().removeFromCart(Constants.Products_Item1);
        Cart.clickContinueShopping().addToCart(Constants.Products_Item4).clickCartICon();


        Checkout.checkOut().enterFirstName(Constants.checkOut_FirstName).enterLastName(Constants.checkOut_LastName).
                enterPostalCode(Constants.checkOut_PostalCode).ClickContinue().clickFinishOrderButton();

        Assert.assertEquals(driver.getCurrentUrl(),Constants.completeOrderPageURL,"Thank you for your order!");



    }






}
