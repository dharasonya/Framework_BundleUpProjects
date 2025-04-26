package ePay_CRM.CommonPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjRepo_CRM_LoginCredentials {

	public ObjRepo_CRM_LoginCredentials(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='strUserId']")
	public WebElement EnterUsername;
	
	@FindBy(xpath="//input[@id='strPassword']")
	public WebElement EnterPassword;

	@FindBy(xpath="//input[@type='submit']")
	public WebElement ClickLoginButton;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']/ul/li")
	public WebElement GetValidationMsg;
	
	
	@FindBy(xpath="//*[text()=' Welcome to epay']")
	public WebElement WelcomeMsg;
	
}
