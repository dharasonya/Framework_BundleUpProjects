package Swag_Labs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class repo_login_Page {

	public repo_login_Page(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	public WebElement Username; 
	
	@FindBy(id="password")
	public WebElement Password; 
	
	@FindBy(id="login-button")
	public WebElement loginButton; 
	
	@FindBy(xpath="//h3[@data-test='error']/button")
	public WebElement LoginErrors;
	
	
}
