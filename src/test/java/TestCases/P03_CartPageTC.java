package TestCases;

import Utilities.LogsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class P03_CartPageTC extends P00_BaseTests{
   private final Logger logger= LogManager.getLogger();
    @Test
    public void comparingPricesTC_001 ()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .addAllProductsToCart().getTotalPriceOfSelectedProducts();
        selectProduct.clickCartICon();
        logger.info("done done done");
        LogsUtil.info("don2");


 Assert.assertTrue(Cart.comparingPrices());

    }
    @Test
    public void comparingPricesTC_002 ()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .addRandomProducts(3,6).clickCartICon();

 logger.debug("hello hello");
        Assert.assertTrue(Cart.comparingPrices());

    }
}
