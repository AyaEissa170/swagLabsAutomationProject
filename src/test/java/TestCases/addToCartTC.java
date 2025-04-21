package TestCases;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_Cart;
import Pages.P04_Checkout;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

@Listeners({AllureTestNg.class})
public class addToCartTC {
    private WebDriver driver;
    P01_LoginPage loginPage;
    P02_HomePage selectProduct;
    P03_Cart Cart;
    P04_Checkout Checkout;

    @BeforeMethod( alwaysRun = true)
    public void setup() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
    @AfterMethod( alwaysRun = true)
    public void quit() {
      //  driver.quit();
    }

}
