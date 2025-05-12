package TestCases;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class P00_BaseTests {
    //drivers
   // ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    public WebDriver driver;

    //objectPages

   protected P01_LoginPage loginPage;
    protected  P02_LandingPage selectProduct;
    protected P03_CartPage Cart;
    protected P04_Checkout Checkout;


   @Parameters(value="browser")

    @BeforeMethod( alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        switch (browser)
        {
            case "edge":
                driver=new EdgeDriver();

                break;
            default:
                driver=new ChromeDriver(new ChromeOptions().addArguments("--incognito"));

        }


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
