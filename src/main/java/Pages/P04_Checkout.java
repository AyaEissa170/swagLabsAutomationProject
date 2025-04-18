package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_Checkout {

    private final WebDriver driver;

    public P04_Checkout(WebDriver driver)
    {
        this.driver=driver;
    }
//elements
    private final By checkoutButton= By.id("checkout");
    private final By ConfirmOrderFirstName=By.id("first-name");
    private final By ConfirmOrderLastName=By.id("last-name");
    private final By ConfirmOrderPostalCode=By.id("postal-code");
    private final By continueButton=By.id("continue");
    private final By FinishOrder=By.id("finish");
    private final By CancelOrder=By.id("cancel");




    //actions

    public P04_Checkout checkOut()
    {
        Utility.clickElement(driver,checkoutButton);
        return new P04_Checkout (driver);
    }

    public P04_Checkout enterFirstName(String firstNameText)
    {
        Utility.SendData(driver,ConfirmOrderFirstName,firstNameText);
        return this;


    }
    public P04_Checkout enterLastName(String lastNameText)
    {
        Utility.SendData(driver,ConfirmOrderLastName,lastNameText);
        return this;


    }
    public P04_Checkout enterPostalCode(String postalCodeText)
    {
        Utility.SendData(driver,ConfirmOrderPostalCode,postalCodeText);
        return this;


    }
public void ClickContinue()
{
Utility.clickElement(driver,continueButton);
}
public P02_HomePage ClickCancel()
{
        Utility.clickElement(driver,CancelOrder);
    return new P02_HomePage(driver);
}

}
