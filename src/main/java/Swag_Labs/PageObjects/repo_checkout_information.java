package Swag_Labs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class repo_checkout_information {

	
	public repo_checkout_information(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	public WebElement Enter_firstName;
	
	@FindBy(id="last-name")
	public WebElement Enter_lastName;
	
	@FindBy(id="postal-code")
	public WebElement Enter_PostalCode;
	
	@FindBy(id="cabcel")
	public WebElement ClickOnCancelButton;
	
	@FindBy(id="continue")
	public WebElement ClickOnContinueButton;
	
	@FindBy(xpath="//h3[@data-test='error']/button")
	public WebElement errorMsg;
}
