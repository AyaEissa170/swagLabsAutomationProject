package TestCases;

import Utilities.LogsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class P03_CartPageTC extends P00_BaseTests{

WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
   private final Logger logger= LogManager.getLogger();
    @Test
    public void comparingPricesTC_001 ()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .addAllProductsToCart().getTotalPriceOfSelectedProducts();
        selectProduct.clickCartICon();

 Assert.assertTrue(Cart.comparingPrices());

    }

    @Test
    public void comparingPricesTC_002 ()
    {
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin()
                .addRandomProducts(3,6);

logger.info(selectProduct.getNumberOfProductsOnCart());
        Assert.assertTrue(Cart.comparingPrices());

       // Assert.assertTrue(selectProduct.getNumberOfProductsOnCart().equals("3"));

    }

}
