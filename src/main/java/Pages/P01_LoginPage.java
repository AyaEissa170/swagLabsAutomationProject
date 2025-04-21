package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private WebDriver driver;
    private final By userName=By.id("user-name");
    private final By Password=By.id("password");
    private final By loginButton=By.cssSelector("[type='submit']");
  //  private final   By error = By.cssSelector("[data-test='error']");


    //constructor
    public P01_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Actions

    public P01_LoginPage enterUserName(String usernameText)
    {
        Utility.SendData(driver,userName,usernameText);
       // driver.findElement(userName).sendKeys(usernameText);
        return this;

    }

    public P01_LoginPage enterPassword(String passwordText)
    {
        Utility.SendData(driver,Password,passwordText);
        // driver.findElement(Password).sendKeys(passwordText);
        return this;

    }

    public P02_HomePage clickLogin()
    {
        Utility.clickElement(driver,loginButton);
       // driver.findElement(loginButton).click();
        return new P02_HomePage(driver);
    }
}


