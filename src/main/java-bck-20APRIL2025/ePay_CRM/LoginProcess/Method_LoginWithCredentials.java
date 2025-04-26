package ePay_CRM.LoginProcess;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ePay_CRM.CommonPageObjects.ObjRepo_CRM_LoginCredentials;
import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.ScreenShot_Handle;

public class Method_LoginWithCredentials extends BasePageSetup {

	public WebDriver driver;
	ObjRepo_CRM_LoginCredentials obj;
	private Properties prop=new Properties();
	CallListeners event=new CallListeners();
	ScreenShot_Handle screenshot;
	
	InputStream input;
	
	public Method_LoginWithCredentials(WebDriver driver) throws Exception {
		this.driver=driver;
		obj =new ObjRepo_CRM_LoginCredentials(driver);	
		input=new FileInputStream("./src/main/resources/EnviornmentSetup.properties");
		prop.load(input);  
	}

	public void getUrl()
	{
		driver.manage().window().maximize();
		driver.navigate().to(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));// newly added
		event.printSnap("Navigated to URL");
	}
	
	public void EnterMakerUserName() throws Exception
	{
		obj.EnterUsername.sendKeys(getProp().getProperty("MakerUserId"));
		event.printSnap("Maker Username Entered");
		getLog().info("Maker Username Entered");
	}

	public void EnterMakerUserPassword() throws Exception
	{
		obj.EnterPassword.sendKeys(getProp().getProperty("MakerPassword"));
		event.printSnap("Maker Password Entered");
		getLog().info("Maker Password Entered");
	}

	public void EnterCheckerUserName() throws Exception
	{
		obj.EnterUsername.sendKeys(getProp().getProperty("CheckerUsername"));
		getLog().info("Checker Username Entered");
		event.printSnap("Checker Username Entered");
	}
	
	public  void EnterCheckerUserPassword() throws Exception
	{
		obj.EnterPassword.sendKeys(getProp().getProperty("CheckerPassword"));
		getLog().info("Checker Password Entered");
		event.printSnap("Checker Password Entered");
	}
	
	public void clickOnLoginButton() throws Exception {

		obj.ClickLoginButton.click();
		try
		{
			Assert.assertEquals(obj.WelcomeMsg.getText(), "Welcome to epay","On Login-Welcome Message Verification");
			getLog().info("Succesfully Login with Entered Credentials");
			event.printSnap("CRM-Succesful Login");
		}
		catch(Exception e)
		{
			getLog().info("Failed to Login / Invalid Credentials");
			Assert.assertTrue(false,"Verifcation of Login Credentials ");
			
		}
		
		//System.out.println(base.GetLoginErrors.getText());
	//	LoginVerifcation();
		
	}
	
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
