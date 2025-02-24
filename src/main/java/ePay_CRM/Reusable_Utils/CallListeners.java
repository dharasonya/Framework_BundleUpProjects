package ePay_CRM.Reusable_Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

import ePay_CRM.CommonPageObjects.ObjRepo_CRMBaseSteps;
import ePay_CRM.LandingPage.BasePageSetup;

public class CallListeners extends BasePageSetup implements ITestListener{

	/*  
	extentTestThreadLocal: Stores the ExtentTest instance for each thread.
	browserNameThreadLocal: Stores the browser name for each thread.
	screenshotHandleThreadLocal: Stores the ScreenShot_Handle instance for each thread.*/
	
    private WebDriver driver;    
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> browserNameThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<ScreenShot_Handle> screenshotHandleThreadLocal = new ThreadLocal<>();
    private static int ScenarioCount = 0;
    private static int stepCount=0;
  //  private static int stepCount = 0;
    private ExtentReporterNG report = new ExtentReporterNG();
    private ExtentReports extent;
    private static String caseName;
    ObjRepo_CRMBaseSteps base =new ObjRepo_CRMBaseSteps(driver);

    public static String getCaseName() {
		return caseName;
	}

	public static void setCaseName(String caseName) {
		CallListeners.caseName = caseName;
	}

	public void setDriver(WebDriver driver) {
        this.driver = driver;
        screenshotHandleThreadLocal.set(new ScreenShot_Handle(driver));  
    }
   
    public void setBrowservalue(String browserName) {
        browserNameThreadLocal.set(browserName);
    }

    public String getBrowservalue() {
     //  System.out.println("Listener Get Browser value: " + browserNameThreadLocal.get());
        return browserNameThreadLocal.get();
    }
   
    @Override
    public void onTestStart(ITestResult result) {
    	ScenarioCount++;
        ExtentTest extentTest = report.getExtent().createTest("Browser Run : "+getBrowservalue().toUpperCase()+ " - " + result.getMethod().getMethodName() + " : " + "Data Set :" + ScenarioCount);
        extentTestThreadLocal.set(extentTest);
        caseName=result.getMethod().getMethodName();
       getLog().info("Method execution started: "+caseName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = extentTestThreadLocal.get();
        extentTest.log(Status.PASS, "Test Case : " + result.getMethod().getMethodName() + " is Passed." + " -Data Set :" + ScenarioCount);
  
    }

    public void printSnap(String MethodName) {
        try {
        	stepCount++;
        	String path = screenshotHandleThreadLocal.get().TakeScreen(MethodName);
            ExtentTest extentTest = extentTestThreadLocal.get();
            extentTest.log(Status.PASS,"Test Step :- " + MethodName+" || Executed on Browser : "+getBrowservalue().toUpperCase());
            extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = extentTestThreadLocal.get();
        extentTest.log(Status.FAIL,"Test Case : " + result.getMethod().getMethodName() + " is Failed."+ " / Executed on Browser : "+getBrowservalue().toUpperCase());
        extentTest.log(Status.FAIL, result.getThrowable());
        try {
            String path = screenshotHandleThreadLocal.get().TakeScreen("Failed Snap");
            extentTest.addScreenCaptureFromPath(path, "Test Step Failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReporterNG.getReportObject();
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
        System.out.println("Report got flushed");
        ScenarioCount=0;
    }

	public void createAlertTest(String path, String screenshotPath,String Enviornment, String DataCentre) {
		// TODO Auto-generated method stub
		  ExtentTest extentTest = extentTestThreadLocal.get();
         // extentTest.log(Status.PASS,"Alert :- " +" || Executed on Browser : "+getBrowservalue().toUpperCase());
          //extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		  System.out.println("\n -- called----");
          try {
        	  extentTest.log(Status.PASS,"On Env :"+Enviornment+"To Confirm AlertBox Appears to Switch on Centre :-  "+DataCentre+"|| Executed on Browser : "+getBrowservalue().toUpperCase());
              
        	  extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
          } catch (Exception e) {
              extentTest.log(Status.FAIL, "Failed to attach screenshot: " + e.getMessage());
          }

       
	}

	
	
    

}
