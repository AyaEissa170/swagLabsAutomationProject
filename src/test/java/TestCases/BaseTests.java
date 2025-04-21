package TestCases;

import Pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {
    //drivers
    public WebDriver driver;

    //objectPages
    P01_LoginPage loginPage;

    //Constants
     String loginUsername="error_user";
     String loginPassword="secret_sauce";
      String loginBaseURL="https://www.saucedemo.com/";
      String landingHomeURL="https://www.saucedemo.com/inventory.html";
//methods
    @BeforeMethod( alwaysRun = true)
    public void setup() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage=new P01_LoginPage(driver);
    }

}
