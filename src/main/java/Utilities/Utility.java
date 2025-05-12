package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {
    public static WebDriverWait driverWait;
    public static WebDriver driver;
    private static String SCREENSHOTS_PATH ="src/main/resources/shreenShot_Path/";
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

public static void takeFullScreenShot(WebDriver driver,String screenShotsName) throws IOException {
    File screenSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File screenDest=new File(SCREENSHOTS_PATH+screenShotsName+".png");
    FileUtils.copyFile(screenSrc,screenDest);
    Allure.addAttachment(screenShotsName, Files.newInputStream(Path.of(screenDest.getPath())));
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
