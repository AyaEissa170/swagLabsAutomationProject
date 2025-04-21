package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Utility {
    public static WebDriverWait driverWait;
    public static WebDriver driver;
    public static void clickElement(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();

    }
    public static void SendData(WebDriver driver, By locator,String Text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(Text);

    }

}
