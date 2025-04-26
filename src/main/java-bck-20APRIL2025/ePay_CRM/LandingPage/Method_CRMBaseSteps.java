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
import ePay_CRM.Reusable_Utils.CallListeners;

public class Method_CRMBaseSteps extends BasePageSetup {

	ObjRepo_CRMBaseSteps Base;
	boolean flagchk=false;
	WebDriver driver;
	WebDriverWait wait;
	int retryAttempt=0;

	CallListeners event=new CallListeners();
	public Method_CRMBaseSteps(WebDriver driver) throws Exception  {
		
		this.driver=driver;
		Base =new ObjRepo_CRMBaseSteps(driver);
	}

	
	public void SelectEnviornmentType(String EnvType) throws Exception
	{
		String selectedValue = null;
		Select env=new Select(Base.SelectEnviornmentType);
		
		try
		{	 
			
			
				env.selectByVisibleText(EnvType);
				//Utility_ScreenShot_Handle.TakeScreen("CRM-Enivornment Selected");
				event.printSnap("CRM-Enivornment Selected");
				selectedValue=env.getFirstSelectedOption().getText();
				wait=new WebDriverWait(driver,Duration.ofSeconds(180));  
				wait.until(ExpectedConditions.elementToBeClickable(Base.EnvCloseButton)).click();
				Assert.assertTrue(selectedValue.equals(EnvType),"Environment Selection Verification");
				getLog().info("Enviornment Selected :-"+EnvType);
		}
		catch(Exception e)
		{
			//LaunchBrowserConfig.getLog().info("Invalid Environment Type Provided :"+EnvType);
			Assert.assertTrue(false,"Unable to Select Enviornment");
		}
	}
	
	public void SelectMainMenu(String MainMenu,String SubMenu) throws Exception 
	{
		boolean flag=false;
			int temp1=0;
			int temp2=0;
			
			//System.out.println("\n -------------MENU NAME : "+MainMenu);
			List<WebElement> mainMenuList;
			//System.out.println("Size :"+ Base.SelectMainMenu.size());
			//wait=new WebDriverWait(LaunchBrowserConfig.getDriver(),Duration.ofSeconds(10));
			//Thread.sleep(5000);
			waitForPageToLoad();
			
				mainMenuList=driver.findElements(By.xpath("//div[@id='navbarSupportedContent']/ul/li/a"));
			
			
			for(WebElement mainMenuValues:mainMenuList)
			{
				temp1++;
				//System.out.println(mainMenuValues.getText());
				
					if(mainMenuValues.getText().equalsIgnoreCase(MainMenu))
					{
						//System.out.println("\n----BLOCK 2-------");
						Assert.assertTrue(mainMenuValues.getText().equalsIgnoreCase(MainMenu),"Menu Verification");
						//System.out.println("Temp Count :"+temp1);
						wait=new WebDriverWait(driver,Duration.ofSeconds(20));
						wait.until(ExpectedConditions.elementToBeClickable(mainMenuValues)).click();
						//mainMenuValues.click();
						getLog().info("Main Menu Selected :-"+MainMenu);
						
						waitForPageToLoad();
						List<WebElement> subMenuList=driver.findElements(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li["+temp1+"]/div/a"));
						
						//System.out.println("SubMenuValues size :"+subMenuValues.size());
						waitForPageToLoad();
						for(WebElement subMenuValues:subMenuList)
						{
							//System.out.println(subMenuValues.getText());
							
							if(subMenuValues.getText().equals(SubMenu))
							{
								Assert.assertTrue(mainMenuValues.getText().equalsIgnoreCase(MainMenu),"Sub-Menu Verification");
								wait=new WebDriverWait(driver,Duration.ofSeconds(20));
								wait.until(ExpectedConditions.elementToBeClickable(subMenuValues)).click();
								//subMenuValues.click();
								getLog().info("Child Menu Opened :-"+SubMenu);
									//Utility_ScreenShot_Handle.TakeScreen("CRM-Menu Selected");
								event.printSnap("CRM-Menu Selected");
								
									flag=true;
									break;
							}
							
						}
						//flag=true;
						break;
						
						//break;
					}		
				}
				

			
		
		if(flag==false && retryAttempt<=3)
		{
			retryAttempt++;
			getLog().info("Menu/Sub-Menu Not availabele for Selection , Retry Attempt :"+retryAttempt);
			SelectMainMenu(MainMenu,SubMenu);
		}
		
		else if(retryAttempt>=4 && flag==false)
		{
			getLog().info("Menu/Sub-Menu Seach Selection Stopped-RETRY ATTEMPT REACH MAX LIMIT : "+retryAttempt);
			Assert.assertTrue(false,"Specified Main Menu/SubMenu-Not found");
		}
		
		
	}	public void waitForPageToLoad()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}



}





