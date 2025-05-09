package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ITest implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getTestName());

    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("Bravo Aya.......^-^");

        // not implemented
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Bug or Bad Assertion ?.......^-^");
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }


    public void onStart(ITestContext context) {

        System.out.println(Arrays.toString(context.getAllTestMethods()));
        // not implemented
    }

    public void onFinish(ITestContext context) {

        System.out.println("We are finished this class testcases...........");
        // not implemented
    }
}
