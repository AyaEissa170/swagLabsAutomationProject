package TestCases;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class P00_BaseTests {
    //drivers
   // ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    public WebDriver driver;

    //objectPages
   protected P01_LoginPage loginPage;
    protected  P02_LandingPage selectProduct;
    protected P03_CartPage Cart;
    protected P04_Checkout Checkout;


    //Constants
    protected String loginUsername="standard_user";
    protected String loginPassword="secret_sauce";
    protected  String loginBaseURL="https://www.saucedemo.com/";
    protected  String landingPageURL="https://www.saucedemo.com/inventory.html";
    protected String CartPageURL="https://www.saucedemo.com/cart.html";
    protected  String completeOrderPageURL="https://www.saucedemo.com/checkout-complete.html";

      //CheckOut constants
    String checkOut_FirstName="Aya";
    String checkOut_LastName="Eissa";
    String checkOut_PostalCode="2045";

    //product_Items

    String Products_Item1="SauceLabsBackpack";
    String Products_Item2="SauceLabsBikeLight";
    String Products_Item3="SauceLabsBoltTShirt";
    String Products_Item4="SauceLabsFleeceJacket";
    String Products_Item5="SauceLabsOnesie";
    String Products_Item6="TShirtRed";


    String Products_Item1_Remove="SauceLabsBackpack_remove";
    String Products_Item2_Remove="SauceLabsBikeLight_remove";
    String Products_Item3_Remove="SauceLabsBoltTShirt_remove";
    String Products_Item4_Remove="SauceLabsFleeceJacket_remove";
    String Products_Item5_Remove="SauceLabsOnesie_remove";
    String Products_Item6_Remove="TShirtRed_remove";

    //methods

   @Parameters(value="browser")

    @BeforeMethod( alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        switch (browser)
        {
            case "edge":
                driver=new EdgeDriver();
                break;
            default:
                driver=new ChromeDriver();
        }
       // driver=new EdgeDriver();
      //  driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage=new P01_LoginPage(driver);
        selectProduct=new P02_LandingPage(driver);
        Cart=new P03_CartPage(driver);
        Checkout=new P04_Checkout (driver);


    }
    @AfterMethod( alwaysRun = true)
    public void quit() {
        driver.quit();
        Cart=null;
        loginPage=null;
        selectProduct=null;
        Checkout=null;


    }

}
