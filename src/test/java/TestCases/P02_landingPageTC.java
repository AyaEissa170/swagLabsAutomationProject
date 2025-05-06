package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class P02_landingPageTC extends P00_BaseTests {
@Test
public void comparingNUmberOfSelectedProductsTC()
{
    loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
            .addAllProductsToCart();

    Assert.assertTrue(selectProduct.comparingNumberOfSelectedProductsWithCart());
    Assert.assertEquals(selectProduct.getNumberOfSelectedProducts(),selectProduct.getNumberOfProductsOnCart());

}
@Test
    public void addingRandomProductsToCartTC()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .addRandomProducts(3,6);

        Assert.assertTrue(selectProduct.comparingNumberOfSelectedProductsWithCart());
        Assert.assertEquals(selectProduct.getNumberOfSelectedProducts(),selectProduct.getNumberOfProductsOnCart());

    }
    @Test
    public void clickOnCartIcon()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .clickCartICon();

        Assert.assertEquals(driver.getCurrentUrl(),CartPageURL,"Redirected To Cart Page successfully");

    }

}
