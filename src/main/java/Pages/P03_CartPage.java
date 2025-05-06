package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_CartPage extends P02_LandingPage {
 //locator
    private final By continueShopping=By.id("continue-shopping");
    private final By priceOfSelectedProductsLocator=By.xpath("//button[.=\"Remove\"]//preceding-sibling::div[@class='inventory_item_price']");

    static float totalPriceCartPage=0;

    //Constructor
    private final WebDriver driver;

    public P03_CartPage(WebDriver driver)
    {
        super(driver);

        this.driver=driver;
    }

    //actions

 public P03_CartPage clickContinueShopping()
 {
     Utility.clickElement(driver,continueShopping);
     return new P03_CartPage(driver);

 }


    public String getTotalPriceOnCartPage() {
        try {
            List<WebElement> PriceOfSelectedProducts = driver.findElements(priceOfSelectedProductsLocator);
            for (int i = 1; i <= PriceOfSelectedProducts.size(); i++) {
                By elements = By.xpath("(//button[.=\"Remove\"]//preceding-sibling::div[@class='inventory_item_price'])[" +i+"]");
                String fullText = Utility.getText(driver, elements);
                totalPriceCartPage += Float.parseFloat(fullText.replace("$", ""));
            }
            return String.valueOf(totalPriceCartPage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public boolean comparingPrices()
    {
        return getTotalPriceOnCartPage().equals(getTotalPriceOfSelectedProducts());
    }
}
