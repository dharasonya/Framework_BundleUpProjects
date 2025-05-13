package ePay_CRM.LoginProcess;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ePay_CRM.CommonPageObjects.ObjRepo_OrangeHRM_LoginCredentials;
import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.CommonLogger;
import ePay_CRM.Reusable_Utils.ScreenShot_Handle;
import ePay_CRM.Reusable_Utils.WaitUtils;
import ePay_CRM.WrapMethods.WrapperMethods;

public class Method_OrangeHRM_LoginWithCredentials extends BasePageSetup {

	public WebDriver driver;
	ObjRepo_OrangeHRM_LoginCredentials obj;
	private Properties prop=new Properties();
	CallListeners event=new CallListeners();
	ScreenShot_Handle screenshot;
	WaitUtils wait;
	WrapperMethods action;
	InputStream input;

	public Method_OrangeHRM_LoginWithCredentials(WebDriver driver) throws Exception {
		this.driver=driver;
		obj =new ObjRepo_OrangeHRM_LoginCredentials(driver);	
		input=new FileInputStream("./src/main/resources/orangehrm.properties");
		prop.load(input); 
		wait=new WaitUtils(driver);
		action=new WrapperMethods(driver);
	}

	public void getUrl() throws InterruptedException
	{
		driver.manage().window().maximize();
		try
		{
			driver.navigate().to(prop.getProperty("URL"));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));// newly added
			Thread.sleep(5000);
			event.printSnap("Navigated to URL");
		}
		catch(Exception e)
		{
			CommonLogger.log("Got RunTime Error-on Page Load, Retrying !!..");
			driver.navigate().refresh();
			driver.navigate().to(prop.getProperty("URL"));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));// newly added
			//wait.waitForElementToBeVisible(obj.OrangeHRMLogo, 10);
			Thread.sleep(8000);
			event.printSnap("Navigated to URL");
		}
	}

	public void EnterAdminUserName() throws Exception
	{
		action.enterAndVerify(obj.EnterUsername, getProp().getProperty("AdminUserId"), "AdminUserId");
		event.printSnap("Admin_UserId Entered");	
	}

	public void EnterAdminUserPassword() throws Exception
	{
		action.enterAndVerify(obj.EnterPassword, getProp().getProperty("AdminPassword"), "AdminPassword");
		event.printSnap("Admin_Password Entered");
	}


	public void clickOnLoginButton() throws Exception {		
		action.clickOnButtonAndVerify(obj.ClickLoginButton, "Login Button");
		CommonLogger.log("Successfully Login with Entered Credentials");
		action.getTextAndVerify(obj.WelcomeToDashboard, "On Login-Dashboard Message Verification");
		Assert.assertEquals(obj.WelcomeToDashboard.getText(), "Dashboard", "On Login-Dashboard Message Verification");
		event.printSnap("Dashboard View");

	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
