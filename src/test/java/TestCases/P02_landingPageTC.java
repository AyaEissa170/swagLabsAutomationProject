package TestCases;

import Utilities.Constants;
import Utilities.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.InvocedMethod;

import java.io.IOException;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Listeners( InvocedMethod.class)

public class P02_landingPageTC extends P00_BaseTests {

    private static final Logger log = LogManager.getLogger(P02_landingPageTC.class);

    @Test
public void addingAllProductsToCartTC()
{
    loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin()
            .addAllProductsToCart();

    Assert.assertTrue(selectProduct.comparingNumberOfSelectedProductsWithCart());
    Assert.assertEquals(selectProduct.getNumberOfSelectedProducts(),selectProduct.getNumberOfProductsOnCart());

}
@Test
    public void addingRandomProductsToCartTC()
    {
        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin()
                .addRandomProducts(3,6);

        Assert.assertTrue(selectProduct.comparingNumberOfSelectedProductsWithCart());
        Assert.assertEquals(selectProduct.getNumberOfSelectedProducts(),selectProduct.getNumberOfProductsOnCart());

    }
    @Test
    public void clickOnCartIconTC()
    {
        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin()
                .clickCartICon();

        Assert.assertEquals(driver.getCurrentUrl(),Constants.CartPageURL,"Redirected To Cart Page successfully");

    }

    @Test
    public void  logOutTC()
    {
        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin()
                .addAllProductsToCart().clickMenu().clickLogOUt();


        Assert.assertEquals(driver.getCurrentUrl(),Constants.loginBaseURL,"Redirected To login Page successfully");
    }
@Test
    public void  resetAppItem() throws IOException {
        loginPage.enterUserName(Constants.loginUsername).enterPassword(Constants.loginPassword).clickLogin()
                .addAllProductsToCart() .clickMenu().clickRestAppItem();



         log.info("Number of products on cart"+ selectProduct.getNumberOfProductsOnCart());
        Assert.assertTrue(selectProduct.getNumberOfProductsOnCart().equals("0"));

    String ButtonStatus= driver.findElement(By.xpath("//button[@class]")).getText();
        log.info(ButtonStatus);

        Utility.takeFullScreenShot(driver,"Remove button dose not rest to Add to cart");
        Assert.assertEquals(ButtonStatus,"Add to cart");

    }

}
