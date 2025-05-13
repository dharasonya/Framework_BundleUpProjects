package ePay_CRM.CommonPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjRepo_OrangeHRM_LoginCredentials {

	public ObjRepo_OrangeHRM_LoginCredentials(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='username']")
	public WebElement EnterUsername;
	
	@FindBy(xpath="//*[@name='password']")
	public WebElement EnterPassword;

	@FindBy(xpath="//*[@type='submit']")
	public WebElement ClickLoginButton;
	
	@FindBy(xpath="//*[text()='Required']")
	public WebElement GetValidationMsg;
	
	@FindBy(xpath="(//*[text()='Dashboard'])[2]")
	public WebElement WelcomeToDashboard;
	
	@FindBy(xpath="(//*[text()='pavan Vempalaku'])[1]")
	public WebElement LoggedUserName;
	
	@FindBy(xpath="//h5[text()='Login']")
	public WebElement OnLoadLoginPage;
	
	@FindBy(xpath="//div[@class='orangehrm-login-logo']")
	public WebElement OrangeHRMLogo;
}
