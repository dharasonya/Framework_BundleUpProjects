package ePay_CRM.Test_ActionMethods;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.WaitUtils;
import ePay_CRM.Test_PageObjects.Repo_AirtelDataCenterMigration;
import ePay_CRM.Test_PageObjects.Repo_BillerConfig_Onus;
import ePay_CRM.Test_PageObjects.Repo_ServiceProviderRespCodeMapping;

public class Method_AirtelConfiguration extends BasePageSetup{

	Repo_AirtelDataCenterMigration obj;
	WebDriver driver;
	int count=0;
	//WebDriverWait wait;
	int errCount=0;
	Method_CRMBaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();
	SoftAssert softAssert;
	WaitUtils wait;
	String screenshotPath;


	public Method_AirtelConfiguration(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_AirtelDataCenterMigration(driver);	
		baseStep=new Method_CRMBaseSteps(driver);
		wait=new WaitUtils(driver);	
	}



	public void clickOnEditButton(String DataCentre)
	{
		int counter=0;
		for(WebElement dataCentreValues:obj.Maker_Grid_DataCenter)
		{
			counter++;
			//System.out.println("\n DataCentre : "+dataCentreValues.getText()+" - counter : -"+counter);
			if(dataCentreValues.getText().equalsIgnoreCase(DataCentre))
			{
				System.out.println("\n enter");
				driver.findElement(obj.getButtonLocator(counter)).click();
				
					Assert.assertEquals(wait.waitForElementToBeVisible(obj.MakerEditMenuName, 10).getText(), "Airtel DataCentre Migration Edit","Verification of Edit Menu Name");
					break;
				
				
			}
		}
	}
	// Method to click the button
	public void UpdateEditDetails(String DataCentre, String DebitAccount, String SourceOrigin, String UserName, String ServiceUrl,
			String MakerRemark, String StatusUrl) 
					throws Exception {

		SoftAssert softAssert=new SoftAssert();
		try
		{

			softAssert.assertEquals(obj.PreDefinedDataCenter.getAttribute("value"),DataCentre,"Verify Airtel Data Centre");
		}
		catch(Exception e)
		{
			softAssert.assertEquals(obj.PreDefinedDataCenter.getAttribute("value"),DataCentre,"Verify Airtel Data Centre");
		}

		if(!obj.EnterDebitAccount.getAttribute("value").equalsIgnoreCase(DebitAccount))
		{
			obj.EnterDebitAccount.clear();
			obj.EnterDebitAccount.sendKeys(DebitAccount);
			softAssert.assertTrue(obj.EnterDebitAccount.getAttribute("value").equalsIgnoreCase(DebitAccount),"Verify DebitAccount");
			getLog().info("Edited Debit Account");

		}

		if(!obj.EnterSourceOrigin.getAttribute("value").equalsIgnoreCase(SourceOrigin))
		{
			obj.EnterSourceOrigin.clear();
			obj.EnterSourceOrigin.sendKeys(SourceOrigin);
			softAssert.assertTrue(obj.EnterSourceOrigin.getAttribute("value").equalsIgnoreCase(SourceOrigin),"Verify SourceOrigin");
			getLog().info("Edited Source Origin");
		}

		if(!obj.EnterOprUserName.getAttribute("value").equalsIgnoreCase(UserName))
		{
			obj.EnterOprUserName.clear();
			obj.EnterOprUserName.sendKeys(UserName);
			softAssert.assertTrue(obj.EnterOprUserName.getAttribute("value").equalsIgnoreCase(UserName),"Verify Username");
			getLog().info("Edited User Name");
		}


		if(!obj.EnterOprServiceUrl.getAttribute("value").equalsIgnoreCase(ServiceUrl))
		{
			obj.EnterOprServiceUrl.clear();
			obj.EnterOprServiceUrl.sendKeys(ServiceUrl);
			softAssert.assertTrue(obj.EnterOprServiceUrl.getAttribute("value").equalsIgnoreCase(ServiceUrl),"Verify ServiceUrl");
			getLog().info("Edited Service Url");
		}


		Assert.assertTrue(obj.EnterMakerRemark.getAttribute("value").equals(""));
		obj.EnterMakerRemark.sendKeys(MakerRemark);
		softAssert.assertTrue(obj.EnterMakerRemark.getAttribute("value").equalsIgnoreCase(MakerRemark),"Verify MakerRemark");
		getLog().info("Edited Maker Remark");


		if(!obj.EnterOprStatusUrl.getAttribute("value").equalsIgnoreCase(StatusUrl))
		{
			obj.EnterOprStatusUrl.clear();
			obj.EnterOprStatusUrl.sendKeys(StatusUrl);
			softAssert.assertTrue(obj.EnterOprStatusUrl.getAttribute("value").equalsIgnoreCase(StatusUrl),"Verify StatusUrl");
			getLog().info("Edited Status Url");
		}	
		getLog().info("CRM-Edited Details Filled Succesfully");
		event.printSnap("CRM-Edited New Details");

		softAssert.assertAll();

	}  

	public boolean clickOnUpdateButton()
	{
		boolean flag=false;

		wait.waitForElementToBeClickableByWebElement(obj.clickOnSaveButton, 10).click();;

		String onSaveNewExpMsg="Please procced for checker screen";

		try
		{
			if(onSaveNewExpMsg.equals(obj.OnSaveMessage.getText().trim()))
			{
				Assert.assertTrue(onSaveNewExpMsg.equals(obj.OnSaveMessage.getText()),"On Save Sucess Msg Verifcation");
				flag=true;
				getLog().info(obj.OnSaveMessage.getText());
				event.printSnap("CRM Save Success Msg");
			}
		}
		catch(Exception e)
		{
			getLog().info("Unable to Save Records due to CRM Validation-error occured");
		}

		return flag;
	}

	public String MakerCaptureMsg() throws Exception
	{
		String alert=obj.OnSaveMessage.getText();
		event.printSnap("Maker Status Message");
		return alert;
	}

	public int FieldError(String DataCentre,String DebitAccount,String SourceOrigin,String UserName,String ServiceUrl,String MakerRemark,String StatusUrl) throws Exception
	{
		softAssert=new SoftAssert();
		errCount=0;	
		List<WebElement> errorMsg=obj.ListOfValidationError;

		if(errorMsg.size()!=0)
		{	
			for(WebElement ErrList:errorMsg)
			{
				errCount++;
				getLog().info("Error Messages: "+errCount+" - "+ErrList.getText());

				switch(ErrList.getText())
				{
				case "Please enter debit account":
				{
					softAssert.assertTrue(obj.EnterDebitAccount.getAttribute("value").length()==0,"Verify Debit Account");
					event.printSnap(ErrList.getText());
					break;
				}

				case "Debit account should be between 5 to 20 characters":
				{
					softAssert.assertTrue(obj.EnterDebitAccount.getAttribute("value").length()<5 || obj.EnterDebitAccount.getAttribute("value").length()>20,"Verify Debit Account Length :"+obj.EnterDebitAccount.getAttribute("value").length());
					event.printSnap(ErrList.getText());
					break;
				}
				case "Please enter source origin":
				{
					softAssert.assertTrue(obj.EnterSourceOrigin.getAttribute("value").length()==0,"Verify Source Origin");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Source origin should be between 5 to 20 characters":
				{
					softAssert.assertTrue(obj.EnterSourceOrigin.getAttribute("value").length()<5 || obj.EnterSourceOrigin.getAttribute("value").length()>20,"Verify SourceOrigin Length");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Please enter username":
				{
					softAssert.assertTrue(obj.EnterOprUserName.getAttribute("value").length()==0,"Verify Username");
					event.printSnap("Maker Screen ErrorMsg "+errCount);
					break;
				}
				case "User name should be between 5 to 20 characters":
				{
					softAssert.assertTrue(obj.EnterOprUserName.getAttribute("value").length()>=5  ||  obj.EnterOprUserName.getAttribute("value").length()<=20,"Verify OprUserName Length");
					event.printSnap(ErrList.getText());
					break;
				}

				case "Please enter serviceurl":
				{
					softAssert.assertTrue(obj.EnterOprServiceUrl.getAttribute("value").length()==0,"Verify Service Url");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Length of service url should be between 10 to 150 characters":
				{
					softAssert.assertTrue(obj.EnterOprServiceUrl.getAttribute("value").length()>=5  ||  obj.EnterOprServiceUrl.getAttribute("value").length()<=20,"Verify OprServiceUrl Length");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Please enter maker remark":
				{
					softAssert.assertTrue(obj.EnterMakerRemark.getAttribute("value").length()==0,"Verify Maker Remark");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Maker remark should be between 5 to 100 characters":
				{
					softAssert.assertTrue(obj.EnterMakerRemark.getAttribute("value").length()>=5  ||  obj.EnterMakerRemark.getAttribute("value").length()<=20,"Verify MakerRemark Length");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Please enter statusurl":
				{
					softAssert.assertTrue(obj.EnterOprStatusUrl.getAttribute("value").length()==0,"Verify Status Url");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Length of status url should be between 10 to 150 characters":
				{
					softAssert.assertTrue(obj.EnterOprStatusUrl.getAttribute("value").length()>=5  || obj.EnterMakerRemark.getAttribute("value").length()<=20,"Verify StatusUrl Length");
					event.printSnap(ErrList.getText());
					break;
				}
				case "Special characters not allowed":
				{
					String labelName=driver.findElement(By.xpath("//span[@class='field-validation-error'][text()='Special characters not allowed']")).getAttribute("data-valmsg-for");

					switch(labelName)
					{
					case "DebitAccount":
					{
						checkSpecialCharacters("Debit Account", obj.EnterDebitAccount.getAttribute("value"));
						break;
					}
					case "SourceOrigin":
					{
						checkSpecialCharacters("Source Origin", obj.EnterSourceOrigin.getAttribute("value"));
						break;
					}
					case "OprUserName":
					{
						checkSpecialCharacters("UserName", obj.EnterOprUserName.getAttribute("value"));
						break;
					}
					case "OprServiceUrl":
					{
						checkSpecialCharacters("Service Url", obj.EnterOprServiceUrl.getAttribute("value"));
						break;
					}
					case "MakerRemark":
					{
						checkSpecialCharacters("Maker remark", obj.EnterMakerRemark.getAttribute("value"));
						break;
					}
					case "OprStatusUrl":
					{
						checkSpecialCharacters("Status Url", obj.EnterOprStatusUrl.getAttribute("value"));
						break;
					}
					} 
				}	
				}
			}
		}
		else{
			getLog().info("Any Error Messages on Save/Update : "+errCount);
			errCount=0;
		}
		softAssert.assertAll();
		return errCount;
	}

	public void checkSpecialCharacters(String labelName, String value) {
		int count = 0;
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isLetterOrDigit(value.charAt(i)) && !Character.isWhitespace(value.charAt(i))) {
				count++; // Increment count for special characters
			}
		}
		softAssert.assertTrue(count>0, "Verify Special Characters: " + labelName);
		event.printSnap("Special characters not allowed");
	}

	public void ClickOnVerifyButton() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.waitForElementToBeClickableByWebElement(obj.ClickOnVerifyButton, 20).click();
		Assert.assertEquals(wait.waitForElementToBeVisible(obj.OnClickVerifyMode, 20).getText(), "Airtel Datacenter Migration Checker", "Label Verification");
		getLog().info("Checker Verification Process Started");
		event.printSnap("CRM Verification Page");
	}

	public void GoForCheckerProcess(String DataCentre,String DebitAccount,String SourceOrigin,String UserName,String ServiceUrl,String MakerRemark,String StatusUrl, String Action,String CheckerRemarks) throws Exception {

		getLog().info("Checker Process Started");
		int counter=0;

		List<WebElement> List_DataCenter=wait.waitForListOfElementToBeVisible(obj.Col_DataCenter, 10);
		List<WebElement> List_DebitAccount=wait.waitForListOfElementToBeVisible(obj.Col_DebitAccount, 10);
		List<WebElement> List_SourceOrigin=wait.waitForListOfElementToBeVisible(obj.Col_SourceOrigin, 10);
		List<WebElement> List_UserName=wait.waitForListOfElementToBeVisible(obj.Col_UserName, 10);
		List<WebElement> List_ServiceUrl=wait.waitForListOfElementToBeVisible(obj.Col_ServiceUrl, 10);
		List<WebElement> List_StatusUrl=wait.waitForListOfElementToBeVisible(obj.Col_StatusUrl, 10);

		for(int i=0;i<List_DataCenter.size();i++)
		{
			counter++;
			if(List_DataCenter.get(i).getText().equalsIgnoreCase(DataCentre))
			{
				for(int j=0;j<List_DebitAccount.size();j++)
				{
					if(List_DebitAccount.get(j).getText().equals(DebitAccount))
					{
						for(int k=0;j<List_SourceOrigin.size();k++)
						{
							if(List_SourceOrigin.get(k).getText().equals(SourceOrigin))
							{
								for(int m=0;m<List_UserName.size();m++)
								{
									if(List_UserName.get(m).getText().equals(UserName))
									{
										for(int n=0;n<List_ServiceUrl.size();n++)
										{
											if(List_ServiceUrl.get(n).getText().equals(ServiceUrl))
											{
												for(int r=0;r<List_StatusUrl.size();r++)
												{
													if(List_StatusUrl.get(r).getText().equals(StatusUrl))
													{
														System.out.println("\n Reaced Final destination");

														WebElement editBox=wait.waitForElementToBeClickable(obj.getCheckboxValue(counter), 10);

														editBox.click();	
														Assert.assertTrue(editBox.isSelected(),"Verify Click");

														getLog().info("On CheckerView-Record Match Found: "+DataCentre+" / "+DebitAccount+" / "+SourceOrigin+" / "+UserName+" / "+ServiceUrl+" / "+StatusUrl+" ->"+Action);
														event.printSnap("CRM Record Selected by Checker to Take Action");

														wait.waitForElementToBeVisible(obj.CheckerRemarks, 10).sendKeys(CheckerRemarks);
														getLog().info("Checker Remarks entered");

														if(Action.equalsIgnoreCase("Reject"))
														{
															getLog().info("Action Taken : "+Action);
															event.printSnap("CRM Action Taken "+Action);
															obj.ClickOnReject.click();
															String checkerAlert=wait.waitForElementToBeVisible(obj.CheckerAlertMsg, 20).getText();

															Assert.assertEquals(checkerAlert,"Record Rejected", "Verification of Reject-Taken Message");
															getLog().info(checkerAlert);
														}
														else if(Action.equalsIgnoreCase("Approve"))
														{
															getLog().info("Action Taken : "+Action);
															event.printSnap("CRM Action Taken "+Action);
															obj.ClickOnApprove.click();
															String checkerAlert=wait.waitForElementToBeVisible(obj.CheckerAlertMsg, 20).getText();

															Assert.assertEquals(checkerAlert,"Response Updated", "Verification of Approve-Taken Message");
															getLog().info(checkerAlert);

														}



														getLog().info("Checker Process Ended");
														event.printSnap("CRM Checker Process Done");
													}
												}
												break;
											}
										}
										break;
									}
								}
								break;
							}
							else
							{
								continue;
							}
						}

						break;
					}
					else
					{
						continue;
					}
				}

				break;
			}
			else
			{
				continue;
			}
		}
	}


	public void Logout() throws Exception {
		while (retryCount < 5) {
			try {
				System.out.println("\n Logout Retry Attempt : " + retryCount);

				wait.waitForElementToBeVisible(obj.ClickLogout, 10).click();

				getLog().info("CRM Logout Successfully");
				event.printSnap("CRM Successful LogOut");
				break; // Exit loop after successful logout
			} catch (Exception e) {
				retryCount++;
				System.out.println("Retry attempt failed. Attempt: " + retryCount);
				if (retryCount >= 5) {
					System.out.println("All retry attempts failed.");
					throw e; // After 3 retries, re-throw the exception
				}
			}
		}
	}

	public void switchBalWallets() throws Exception {

		List<WebElement> getEnvList=obj.Get_BAL_ListOfEnviornments;
		List<String> SwitchedDataCentres=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int counter=0;
		String dataCentreText ;


		for(int i=0;i<getEnvList.size();i++)
		{
			boolean staleElement = true;
		    int retries = 3; // Number of retries
		        try {
		            System.out.println("\n Current Environment : " + getEnvList.get(i).getText());
		            staleElement = false; // If no exception, set flag to false
		        } catch (StaleElementReferenceException e) {
		            retries--;
		            List<WebElement> getEnvList1=obj.Get_BAL_ListOfEnviornments;
		              // Refresh the element list and re-locate the element
		          //  getEnvList = obj.Get_BAL_ListOfEnviornments;
		            //getEnv_Values = getEnvList.get(i);
		            System.out.println("\n retry Current Environment : " + getEnvList1.get(i).getText());
				          
		        }
		    
			for (int j = 1; j <= 1; j++) {
				String currentDataCentre,currentEnviornment;
				counter++;
				
				
					currentDataCentre = obj.getBal_Current_DataCentre(counter).getText();
					currentEnviornment=obj.getBal_CurrentEnviornment(counter).getText();
					System.out.println("\n Process started -Centre :"+currentDataCentre+" -- env--:"+currentEnviornment);
				
				if ("Banglore".equals(currentDataCentre) && !SwitchedDataCentres.contains("Banglore")) {
					logInfo("Current Data_Centre: " + currentDataCentre+"--counter--"+counter);
					event.printSnap("On Environment " + currentEnviornment + "_Current Datacentre " + currentDataCentre);
					assertEquals(currentDataCentre, "Banglore", "Verify Currently Mapped Centre");

					handleDataCentreSwitch(counter,currentEnviornment,currentDataCentre);
					scrollToElementAndSnap(obj.getBal_Current_DataCentre(counter),counter);
					SwitchedDataCentres.add(currentDataCentre);
					//break;
				}
				else
				{
					break;
				}
				

			}
			SwitchedDataCentres.remove("Banglore");
			SwitchedDataCentres.remove("Chennai");	
		}
		

		//--optimized ----
		

	}

	private void handleDataCentreSwitch(int counter,String Environment,String DataCentre) throws Exception {
		
		System.out.println("\n Button clicked : "+obj.getBal_Switch_DataCentre(counter).getText());
			
		obj.getBal_Switch_DataCentre(counter).click();
		handleAlert(counter,Environment,DataCentre);
		
	}

	private void handleAlert(int counter,String Environment,String DataCentre) throws Exception {
		Alert alert = wait.waitForAlertIsPresent(10);
		logInfo("Fetch Alert Text: " + alert.getText());
		//captureScreenshot("alertscreentestnew4_" + counter);


		System.out.println("\n Your code that might trigger the alert");
		Thread.sleep(4000);
		captureScreenshot("alertscreentestnew10_" + counter);
	
		event.createAlertTest("Capture Alert Screenshot Test", screenshotPath,Environment,DataCentre);
		//Thread.sleep(4000);

		driver.switchTo().alert().accept();
		getLog().info("Records Updated Succesfully to Centre: "+obj.getBal_Current_DataCentre(counter).getText()+"_On Enviornment "+obj.getBal_CurrentEnviornment(counter).getText());
		event.printSnap("Records Updated Successfully on Enviorment "+obj.getBal_CurrentEnviornment(counter).getText());
		getLog().info("----Switched to DatCentre----: "+obj.getBal_Current_DataCentre(counter).getText()+"_On Enviornment "+obj.getBal_CurrentEnviornment(counter).getText());
	}


	private void captureScreenshot(String fileName) throws Exception {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screens = ge.getScreenDevices();
		Rectangle allScreenBounds = new Rectangle();
		for (GraphicsDevice screen : screens) {
			Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
			allScreenBounds = allScreenBounds.union(screenBounds);
		}
		Robot robot = new Robot();
		BufferedImage screenFullImage = robot.createScreenCapture(allScreenBounds);
		screenshotPath = System.getProperty("user.dir")+"/CRM_Screenshots/"+"_"+fileName+".jpeg";
		//"C://Users//sdhara//OneDrive - Euronet Worldwide//Documents//New_Auto_WorkSpace/Framework_BundleUpProjects-main//CRM_Screenshots//" + fileName + ".jpeg";
		ImageIO.write(screenFullImage, "jpeg", new File(screenshotPath));

		System.out.println("\n Screenshot taken");
	}

	private void scrollToElementAndSnap(WebElement element,int counter) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			event.printSnap("Switch To Datacentre " + element.getText() + "_On Environment " + obj.getBal_CurrentEnviornment(counter).getText());
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			event.printSnap("Switch To Datacentre " + element.getText() + "_On Environment " + obj.getBal_CurrentEnviornment(counter).getText());
		}
	}
	private void logInfo(String message) {
		getLog().info(message);
	}

	private void assertEquals(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

}

