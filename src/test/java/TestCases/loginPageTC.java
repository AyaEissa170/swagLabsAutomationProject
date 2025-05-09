package TestCases;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.Listeners;
import Listeners.InvocedMethod;
import java.time.Duration;

@Listeners({AllureTestNg.class})
public class loginPageTC extends P00_BaseTests {


    @Test (priority = 1, groups={"loginPageRegressionTC"})
    public void HardValidationTc() {

       // P01_LoginPage loginPage= new P01_LoginPage(driver);
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), landingPageURL);

    }

    @Test (priority = 2, groups={"loginPageRegressionTC"})
    public void HardInvalidLoginTestCase_EmptyUsername() {

        loginPage.enterUserName("").enterPassword(loginPassword).clickLogin();
        boolean expected = driver.getCurrentUrl().equals(loginBaseURL);
        Assert.assertTrue(expected, "User Name is required ");
    }

    @Test (priority = 3, groups={"loginPageRegressionTC"})
    public void HardInvalidLoginTestCase_EmptyPassword() {

        loginPage.enterUserName(loginUsername).enterPassword("").clickLogin();
        boolean expected = driver.getCurrentUrl().equals(loginBaseURL);
        Assert.assertTrue(expected, "Password is required ");
    }
    @Test (priority = 4, groups={"loginPageRegressionTC"})//bug there is no alert message under password filed
    public void HardInvalidLoginTestCase_EmptyFields() {
      loginPage.clickLogin();

        String text= driver.findElement(By.cssSelector("form > div > h3[data-test=\"error\"]")).getText();
        System.out.println("text is"+text);

        boolean expected=text.equals("Username is required,Password is required");
        System.out.println(expected);

        Assert.assertTrue(expected);


    }



}
