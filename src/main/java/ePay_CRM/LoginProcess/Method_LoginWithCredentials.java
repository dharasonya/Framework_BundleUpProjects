package ePay_CRM.LoginProcess;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ePay_CRM.CommonPageObjects.ObjRepo_CRM_LoginCredentials;
import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.CommonLogger;
import ePay_CRM.Reusable_Utils.ScreenShot_Handle;

public class Method_LoginWithCredentials extends BasePageSetup {

	public WebDriver driver;
	ObjRepo_CRM_LoginCredentials obj;
	private Properties prop=new Properties();
	CallListeners event=new CallListeners();
	ScreenShot_Handle screenshot;
	WebDriverWait wait;
	
	InputStream input;
	
	public Method_LoginWithCredentials(WebDriver driver) throws Exception {
		this.driver=driver;
		obj =new ObjRepo_CRM_LoginCredentials(driver);	
		input=new FileInputStream("./src/main/resources/EnviornmentSetup.properties");
		//input=new FileInputStream("./src/main/resources/orangehrm.properties");
		prop.load(input);  
	}

	public void getUrl()
	{
		driver.manage().window().maximize();
		try
		{
			driver.navigate().to(prop.getProperty("URL"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));// newly added
			event.printSnap("Navigated to URL");
		}
		catch(Exception e)
		{
			//getLog().info("Got RunTime Error-on Page Load, Retrying !!..");
			CommonLogger.log("Got RunTime Error-on Page Load, Retrying !!..");
			driver.navigate().refresh();
			driver.navigate().to(prop.getProperty("URL"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));// newly added
			event.printSnap("Navigated to URL");
		}
	}
	
	public void EnterMakerUserName() throws Exception
	{
		try
		{
			obj.EnterUsername.sendKeys(getProp().getProperty("MakerUserId"));
			event.printSnap("Maker Username Entered");
			//getLog().info("Maker Username Entered");
			CommonLogger.log("Maker Username Entered");
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			//getLog().info("RunTime Exception occured-On page load,Retrying!!!...");
			CommonLogger.log("RunTime Exception occured-On page load,Retrying!!!...");
			obj.EnterUsername.sendKeys(getProp().getProperty("MakerUserId"));
			event.printSnap("Maker Username Entered");
			//getLog().info("Maker Username Entered");
		}
	}

	public void EnterMakerUserPassword() throws Exception
	{
		obj.EnterPassword.sendKeys(getProp().getProperty("MakerPassword"));
		event.printSnap("Maker Password Entered");
		//getLog().info("Maker Password Entered");
		CommonLogger.log("Maker Password Entered");
	}

	public void EnterCheckerUserName() throws Exception
	{
		obj.EnterUsername.sendKeys(getProp().getProperty("CheckerUsername"));
		//getLog().info("Checker Username Entered");
		CommonLogger.log("Checker Username Entered");
		event.printSnap("Checker Username Entered");
	}
	
	public  void EnterCheckerUserPassword() throws Exception
	{
		obj.EnterPassword.sendKeys(getProp().getProperty("CheckerPassword"));
		//getLog().info("Checker Password Entered");
		CommonLogger.log("Checker Password Entered");
		event.printSnap("Checker Password Entered");
	}
	
	public void clickOnLoginButton() throws Exception {		
		
		int retryCount = 3;
		for (int attempt = 1; attempt <= retryCount; attempt++) {
		    try {
		        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        wait.until(ExpectedConditions.elementToBeClickable(obj.ClickLoginButton)).click();
		        // obj.ClickLoginButton.click();
		       // getLog().info("Successfully Login with Entered Credentials");
		        CommonLogger.log("Successfully Login with Entered Credentials");
		        Assert.assertEquals(obj.WelcomeMsg.getText(), "Welcome to epay", "On Login-Welcome Message Verification");
		        event.printSnap("CRM-Successful Login");
		        break; // Exit the loop if login is successful
		    } catch (Exception e) {
		        if (attempt > retryCount) {
		        //    getLog().info("Failed to login after " + retryCount + " attempts");
		            CommonLogger.log("Failed to login after " + retryCount + " attempts");
		            // handled case.
		            
		           

		            throw e; // Re-throw the exception if all attempts fail
		        }
		       // getLog().info("Login attempt " + attempt + " failed, retrying...");
		        CommonLogger.log("Login attempt " + attempt + " failed, retrying...");
		        driver.navigate().refresh();
		    }
		}
	}
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
