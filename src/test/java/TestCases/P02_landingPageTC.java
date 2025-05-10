package TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.InvocedMethod;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Listeners( InvocedMethod.class)

public class P02_landingPageTC extends P00_BaseTests {

    @Test
public void addingAllProductsToCartTC()
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
    public void clickOnCartIconTC()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .clickCartICon();

        Assert.assertEquals(driver.getCurrentUrl(),CartPageURL,"Redirected To Cart Page successfully");

    }
    @Test

    /*
    public void emptyCartTC()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .clickCartICon();

        Assert.assertEquals(selectProduct.getNumberOfProductsOnCart(),selectProduct.getNumberOfProductsOnCart());


    }
*/
}
