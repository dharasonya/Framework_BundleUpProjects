package ePay_CRM.CommonPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjRepo_CRMBaseSteps {

	public ObjRepo_CRMBaseSteps(WebDriver driver)
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
	
	@FindBy(xpath="//select[@id='OpURLEnvironmentType']")
	public WebElement SelectEnviornmentType;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/button[1]")
	public WebElement EnvCloseButton;
	
	@FindBy(xpath="//ul[@class='navbar-nav mr-auto mu-navbar-nav']/li/a")
	public List<WebElement> SelectMainMenu;
	
	@FindBy(xpath="//li[@class='nav-item dropdown open']/div/a")
	public List<WebElement> SelectSubMenu;
	
	@FindBy(xpath="//*[@id=\"mu-hero\"]/div/nav/i/img")
	public WebElement ClickLogoutButton;
	
	@FindBy(xpath="//div[@class='validation-summary-errors']/ul/li")
	public WebElement GetLoginErrors;
}
