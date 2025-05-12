package Pages;

import Utilities.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class P02_LandingPage {
    private static final Logger log = LogManager.getLogger(P02_LandingPage.class);
    private List<WebElement> allProducts;
private List<WebElement> selectedProducts;
public float totalPriceLandingPage=0;
//locators_add_buttons
private final By SauceLabsBackpack =By.id("add-to-cart-sauce-labs-backpack");
 private final By SauceLabsBikeLight =By.id("add-to-cart-sauce-labs-bike-light");
 private final By SauceLabsBoltTShirt=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
 private final By SauceLabsFleeceJacket=By.id("add-to-cart-sauce-labs-fleece-jacket");
 private final By SauceLabsOnesie=By.id("add-to-cart-sauce-labs-onesie");
 private final By TShirtRed=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

 //locators_remove_buttons
 private final By SauceLabsBackpack_remove =By.id("remove-sauce-labs-backpack");
    private final By SauceLabsBikeLight_remove =By.id("remove-sauce-labs-bike-light");
    private final By SauceLabsBoltTShirt_remove=By.id("remove-sauce-labs-bolt-t-shirt");
    private final By SauceLabsFleeceJacket_remove=By.id("remove-sauce-labs-fleece-jacket");
    private final By SauceLabsOnesie_remove=By.id("remove-sauce-labs-onesie");
    private final By TShirtRed_remove=By.id("remove-test.allthethings()-t-shirt-(red)");

//
    private final By addTOCartForALLProducts=By.xpath("//button[@class]");
    private final By cartNumbersOfProductsOnCart=By.className("shopping_cart_badge");
    private  final  By NumberOfSelectedProducts=By.xpath("//button[.='Remove']");
    private final By cartProducts= By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private final By priceOfSelectedProductsLocator=By.xpath("//button[.=\"Remove\"]//preceding-sibling::div[@class='inventory_item_price']");
    private final By menu =By.id("react-burger-menu-btn");
    private final By logOut =By.id("logout_sidebar_link");
    private final By resetAppItem=By.id("reset_sidebar_link");





    private final WebDriver driver;
    public P02_LandingPage(WebDriver driver) {
        this.driver = driver;

    }


    //actions

    public P03_CartPage addToCart(String button)
    {
        switch(button) {
            case "SauceLabsBackpack":
                Utility.clickElement(driver, SauceLabsBackpack);

            break;

            case "SauceLabsBikeLight":
                Utility.clickElement(driver, SauceLabsBikeLight);

                break;
            case "SauceLabsBoltTShirt":
                Utility.clickElement(driver, SauceLabsBoltTShirt);

                break;

            case "SauceLabsFleeceJacket":
                Utility.clickElement(driver, SauceLabsFleeceJacket);

                break;
            case "SauceLabsOnesie":
                Utility.clickElement(driver, SauceLabsOnesie);

                break;

            case "TShirtRed":
                Utility.clickElement(driver, TShirtRed);

                break;

        }
        return new P03_CartPage(driver);

    }

    public P02_LandingPage removeFromCart(String button)
    {
        switch(button) {
            case "SauceLabsBackpack_remove":
                Utility.clickElement(driver, SauceLabsBackpack_remove);

                break;

            case "SauceLabsBikeLight_remove":
                Utility.clickElement(driver, SauceLabsBikeLight_remove);

                break;
            case "SauceLabsBoltTShirt_remove":
                Utility.clickElement(driver, SauceLabsBoltTShirt_remove);

                break;

            case "SauceLabsFleeceJacket_remove":
                Utility.clickElement(driver, SauceLabsFleeceJacket_remove);

                break;
            case "SauceLabsOnesie_remove":
                Utility.clickElement(driver, SauceLabsOnesie_remove);

                break;

            case "TShirtRed_remove":
                Utility.clickElement(driver, TShirtRed_remove);

                break;

        }
        return new P02_LandingPage(driver);

    }

public P02_LandingPage addAllProductsToCart()
{
    allProducts=driver.findElements(addTOCartForALLProducts);
    //making dynamic locator
    for(int i=1;i<=allProducts.size();i++)
    {
        By addTOCartForALLProducts=By.xpath("(//button[@class])["+i+"]");
        Utility.clickElement(driver,addTOCartForALLProducts);

    }
    return this;
}
public String getNumberOfProductsOnCart() {
  try {
        return Utility.getText(driver, cartNumbersOfProductsOnCart);
    } catch (Exception e) {
      log.error(e.getMessage());
      return "0";
  }
}
    public String getNumberOfSelectedProducts() {
        try {
            selectedProducts=driver.findElements(NumberOfSelectedProducts);
            return String.valueOf(selectedProducts.size());
        } catch (Exception e) {

            log.error(e.getMessage());
            return "0";
        }
    }
public boolean comparingNumberOfSelectedProductsWithCart()
{
   return getNumberOfProductsOnCart().equals(getNumberOfSelectedProducts());

}

public P02_LandingPage addRandomProducts(int numberOfProductsNeeded, int totalNumberOfProducts) {

    Set<Integer> randomNumbers = Utility.generateUniqueNumber(numberOfProductsNeeded, totalNumberOfProducts);
    for (int random : randomNumbers) {
        By addTOCartForALLProducts = By.xpath("(//button[@class])[" + random + "]");
        Utility.clickElement(driver, addTOCartForALLProducts);
    }
    return this;
}
    public P03_CartPage clickCartICon()
    {
        Utility.clickElement(driver,cartProducts);
        return new P03_CartPage(driver);
    }

public String getTotalPriceOfSelectedProducts() {
    try {
        List<WebElement> PriceOfSelectedProducts = driver.findElements(priceOfSelectedProductsLocator);
        for (int i = 1; i <= PriceOfSelectedProducts.size(); i++) {
            By elements = By.xpath("(//button[.=\"Remove\"]//preceding-sibling::div[@class='inventory_item_price'])["+i+ "]");
            String fullText = Utility.getText(driver, elements);
            totalPriceLandingPage += Float.parseFloat(fullText.replace("$", ""));
        }
        return String.valueOf(totalPriceLandingPage);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}
public P02_LandingPage clickMenu()
{

    Utility.clickElement(driver,menu);

    return this;
}

public P02_LandingPage clickLogOUt()
{

        Utility.clickElement(driver,logOut);

        return this;
}
public P02_LandingPage clickRestAppItem()
    {
        Utility.clickElement(driver,resetAppItem);
        return this;
    }

}


