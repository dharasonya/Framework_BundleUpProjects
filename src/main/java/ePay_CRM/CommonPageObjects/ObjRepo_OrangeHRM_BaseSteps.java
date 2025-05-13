package ePay_CRM.CommonPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjRepo_OrangeHRM_BaseSteps {

	public ObjRepo_OrangeHRM_BaseSteps(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li/a/span")
	public List<WebElement> SelectMainMenu;

	@FindBy(xpath="(//h6)[1]")
	public WebElement verifyMenuName;
}
