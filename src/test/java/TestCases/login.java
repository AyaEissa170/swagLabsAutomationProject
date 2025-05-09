package TestCases;

import Pages.P01_LoginPage;
import Pages.P02_LandingPage;
import Pages.P03_CartPage;
import Pages.P04_Checkout;
import Utilities.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class login extends  P00_BaseTests{
    private static final Logger log = LogManager.getLogger(login.class);
    ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    @BeforeMethod( alwaysRun = true)
    public void setup() {

        driverThreadLocal.set(new EdgeDriver());
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://www.saucedemo.com");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



    }
    @Test

    public void loginTC_01()
    {
        driverThreadLocal.get().findElement(By.id("user-name")).sendKeys("standard_user");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("secret_sauce");
        driverThreadLocal.get().findElement(By.cssSelector("[type='submit']")).click();



        selectProduct.addRandomProducts(3,6);

        Assert.assertTrue(Cart.comparingPrices());

        Set<Integer> randomNumbers = Utility.generateUniqueNumber(3, 6);
        for (int random : randomNumbers) {
            By addTOCartForALLProducts = By.xpath("(//button[@class])[" + random + "]");

            log.info("hello hello");
            driverThreadLocal.get().findElement(addTOCartForALLProducts).click();


    }





    }
    @Test

    public void loginTC_02()
    {
        driverThreadLocal.get().findElement(By.id("user-name")).sendKeys("standard_user");
        driverThreadLocal.get().findElement(By.id("password")).sendKeys("secret_sauce");
        driverThreadLocal.get().findElement(By.cssSelector("[type='submit']")).click();


    }
    @AfterMethod( alwaysRun = true)
    public void quit() {
        //  driver.quit();
    }

}
