package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static String getText(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
      return   driver.findElement(locator).getText();

    }

public static void takeFullScreenShot(WebDriver driver,By locator)
{
    Shutterbug.shootPage(driver, Capture.FULL_SCROLL).
            highlight(driver.findElement(locator)).save();
}
public static int generateRandomNumber(int upperBound){
        return new Random().nextInt(upperBound)+1;
}

public static Set<Integer> generateUniqueNumber(int numberOfProductNeeded, int totalNumberOfProducts)
{
    Set<Integer>generateNumbers= new HashSet<>();
    while (generateNumbers.size() <numberOfProductNeeded)
    {
        int randomNumber=generateRandomNumber(totalNumberOfProducts);
        generateNumbers.add(randomNumber);
    }
    return generateNumbers;
}

}
