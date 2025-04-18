package TestCases;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_Cart;
import Pages.P04_Checkout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.Duration;

public class loginPageTC {
    private WebDriver driver;
    P01_LoginPage loginPage;
    P02_HomePage selectProduct;
    P03_Cart Cart;
    P04_Checkout Checkout;
public Logger LOGGER= LogManager.getLogger();
    @BeforeMethod ( alwaysRun = true)
    public void setup() {
        /*
        Logger logger;
        logger=Logger.getLogger(setup.class.getName());
        logger.setLevel(Level.INFO);// we will get a clear view of the test flow and important events that occur during the test execution.
        logger.info("Running test in " + browser);
        */

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test (priority = 1, groups={"regression"}
    public void HardValidationTc() {
        LOGGER.info("Test case is started");
        P01_LoginPage loginPage= new P01_LoginPage(driver);
        loginPage.enterUserName("error_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test (priority = 2, groups={"regression","Broken"})
    public void HardInvalidLoginTestCase_EmptyUsername() {
        P01_LoginPage loginPage= new P01_LoginPage(driver);
        loginPage.enterUserName("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        boolean expected = driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(expected, "User Name is required ");
    }


    @Test
    public void AddToCart() {
        P01_LoginPage loginPage= new P01_LoginPage(driver);
        P02_HomePage selectProduct= new P02_HomePage(driver);
        P03_Cart Cart =new P03_Cart(driver);
        P04_Checkout Checkout=new P04_Checkout (driver);

        loginPage.enterUserName("error_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        selectProduct.addToCart("SauceLabsBackpack");
        selectProduct.addToCart("SauceLabsBikeLight");
        Cart.clickCart();
        Checkout.checkOut();
        Checkout.enterFirstName("Aya");
        Checkout.enterLastName("Ali");
        Checkout.enterPostalCode("1458");
        Checkout.ClickContinue();
        Checkout.ClickCancel();

    }

    @AfterMethod  ( alwaysRun = true)
    public void quit() {
         driver.quit();
    }
}
