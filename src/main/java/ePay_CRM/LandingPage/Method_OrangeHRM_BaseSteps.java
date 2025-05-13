package ePay_CRM.LandingPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ePay_CRM.CommonPageObjects.ObjRepo_CRMBaseSteps;
import ePay_CRM.CommonPageObjects.ObjRepo_OrangeHRM_BaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.CommonLogger;
import ePay_CRM.Reusable_Utils.WaitUtils;

public class Method_OrangeHRM_BaseSteps extends OrangeHRM_BasePageSetup {

	ObjRepo_OrangeHRM_BaseSteps obj;
	boolean flagchk=false;
	WebDriver driver;
	int retryAttempt=0;
	WaitUtils wait;

	
	CallListeners event=new CallListeners();
	public Method_OrangeHRM_BaseSteps(WebDriver driver) throws Exception  {

		this.driver=driver;
		obj =new ObjRepo_OrangeHRM_BaseSteps(driver);
		wait=new WaitUtils(driver);
	}

	public void SelectMainMenu(String MainMenu) throws Exception 
	{
		boolean flag=false;
			for(WebElement mainValuesList: obj.SelectMainMenu)
		{
			if(mainValuesList.getText().equalsIgnoreCase(MainMenu))
			{
				mainValuesList.click();
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			CommonLogger.log("Main Menu Selected : - "+MainMenu);
			wait.waitForElementToBeVisible(obj.verifyMenuName, 5);
			event.printSnap("CRM-Menu Selected");
		}
		else
		{
			CommonLogger.log("Unable to Find the Main Menu");
			event.printSnap("CRM-Menu Not Found");
		}
	}	
	
	public void waitForPageToLoad()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}



}
