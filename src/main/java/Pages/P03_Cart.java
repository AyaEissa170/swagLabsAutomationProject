package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_Cart {
 //locator
    private final By cartProducts= By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    //Constructor
    private final WebDriver driver;

    public P03_Cart(WebDriver driver)
    {
        this.driver=driver;
    }

    //actions
 public P03_Cart clickCart()
 {
     Utility.clickElement(driver,cartProducts);
     return new P03_Cart(driver);
 }

}
