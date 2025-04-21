package TestCases;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_Cart;
import Pages.P04_Checkout;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class loginPageTC extends BaseTests{

    @Test (priority = 1, groups={"loginPageRegressionTC"})
    public void HardValidationTc() {

       // P01_LoginPage loginPage= new P01_LoginPage(driver);
        loginPage.enterUserName(loginUsername).enterPassword(loginPassword).clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), landingHomeURL);

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
        loginPage.enterUserName("").enterUserName("").clickLogin();
        boolean expected = driver.getCurrentUrl().equals(loginBaseURL);
        Assert.assertTrue(expected,"Username is required,Password Name is required");

    }

    @AfterMethod  ( alwaysRun = true)
    public void quit() {
         driver.quit();
    }

}
