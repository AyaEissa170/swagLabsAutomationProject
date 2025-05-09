package Listeners;

import org.testng.ISuiteListener;
import org.testng.ITestNGListener;

public class ISuite implements ISuiteListener {

   public  void onStart(org.testng.ISuite suite) {
       System.out.println(suite.getAllInvokedMethods());
    }


    public void onFinish(org.testng.ISuite suite) {
        System.out.println(suite.getSuiteState());
        // not implemented
    }

    }

