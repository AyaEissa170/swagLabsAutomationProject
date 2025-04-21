package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {

//locators
 private final By SauceLabsBackpack =By.id("add-to-cart-sauce-labs-backpack");
 private final By SauceLabsBikeLight =By.id("add-to-cart-sauce-labs-bike-light");


    private final WebDriver driver;
    public P02_HomePage(WebDriver driver) {
        this.driver = driver;

    }


    //actions

    public P02_HomePage addToCart(String button)
    {
        switch(button) {
            case "SauceLabsBackpack":
                Utility.clickElement(driver, SauceLabsBackpack);

            break;

            case "SauceLabsBikeLight":
                Utility.clickElement(driver, SauceLabsBikeLight);
              //  return new P02_HomePage(driver);
                break;

        }
        return new P02_HomePage(driver);

    }
}

