package ePay_CRM.Test_ActionMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Test_PageObjects.Repo_EpayPropertyConfig;
import ePay_CRM.Test_PageObjects.Repo_ServiceProviderRespCodeMapping;

public class Method_SpRspCodeMapping extends BasePageSetup{

	Repo_ServiceProviderRespCodeMapping obj;
	WebDriver driver;
	int count=0;
	WebDriverWait wait;
	int errCount=0;
	Method_CRMBaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();

	public Method_SpRspCodeMapping(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_ServiceProviderRespCodeMapping(driver);	
		baseStep=new Method_CRMBaseSteps(driver);
	}

	public void ClickOnAddButton() throws Exception
	{
		try
		{
			if(addRetryCheck<3)
			{
				wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				Assert.assertTrue(obj.btnAdd.isDisplayed(),"AddButton Verification");
				wait.until(ExpectedConditions.elementToBeClickable(obj.btnAdd)).click();
				getLog().info("Clicked on Add Button");
				event.printSnap("CRM-Add Menu Opened");
			}
			else
			{
				System.out.println("Add retry Attempt Completed.!!!");
			}
		}
		catch(Exception e)
		{
			addRetryCheck++;
			ClickOnAddButton();
		}
	}

	public void FillInAddDetails(String NetWorkMode,String ServiceProviderName,String ServiceproviderResponsCode,String EuronetResponseCode,String ResponseAction,String ServiceProviderResposneMessage,String Status,String MakerRemark) throws Exception {

		
		if(NetWorkMode.toLowerCase().equalsIgnoreCase("onus"))
		{
			WebElement selectNetworkMode=obj.selectNetworkMode;
			Select selectEnv=new Select(selectNetworkMode);
			selectEnv.selectByVisibleText("ONUS");
			Assert.assertTrue(selectNetworkMode.getAttribute("value").equalsIgnoreCase(NetWorkMode));
			obj.EnterServiceproviderName.sendKeys(ServiceProviderName);
			wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.SelectServiceProvider));
			for(WebElement spname:obj.SelectServiceProvider)
			{
				//	System.out.println("\n Values : --"+spname.getText());
				if(spname.getText().contains("Airtel"))
				{
					spname.click();
				}
			}
		}
		else 
		{
			WebElement selectNetworkMode=obj.selectNetworkMode;
			Select selectEnv=new Select(selectNetworkMode);
			selectEnv.selectByVisibleText("OFFUS");
			Assert.assertTrue(selectNetworkMode.getAttribute("value").equalsIgnoreCase(NetWorkMode));
			Assert.assertEquals(obj.EnterServiceproviderName.getAttribute("disabled"),"true");
			
		}
		
		

	//Thread.sleep(5000);
		//System.out.println("\n Size : "+obj.SelectServiceProvider.size());

		

		obj.EnterServiceProviderResponseCode.sendKeys(ServiceproviderResponsCode);

		obj.EnterEuronetResponseCode.sendKeys("EI");
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.SelectEuronetResponseCode));
		//	System.out.println("--Euronet Response code----:"+obj.SelectEuronetResponseCode.size());
		for(WebElement enrspcode:obj.SelectEuronetResponseCode)
		{
			String tempEnrspcode[]=enrspcode.getText().split(" ");
			//System.out.println("\n 0th Value : "+tempEnrspcode[0]);
			if (tempEnrspcode[0].equalsIgnoreCase(EuronetResponseCode)) {
				enrspcode.click();
				break;
			}
		}


		Select selectResponseAction=new Select(obj.selectResponseAction);
		selectResponseAction.selectByValue(ResponseAction);

		obj.EnterServiceProviderResponseMessage.sendKeys("Failure error message");

		Select selectStatus=new Select(obj.selectStatus);
		selectStatus.selectByValue(Status);


		obj.EnterRemark.sendKeys(MakerRemark);

		getLog().info("Added all the Details,Proceed to Save");
		event.printSnap("CRM-Added New Details");
	}  

	public boolean clickOnSaveButton() throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(obj.clickOnSaveBtn)).click();
		//	obj.ClickOnSave.click();
		String onSaveNewExpMsg="Service Provider Response Code added successfully.";
		String onSaveDupExpMsg="Service Provider Response Code already exists.";


		if(onSaveNewExpMsg.equals(obj.ResponseMsg.getText().trim()))
		{
			Assert.assertTrue(onSaveNewExpMsg.equals(obj.ResponseMsg.getText()),"On Save Sucess Msg Verifcation");
			flag=true;
			getLog().info(obj.ResponseMsg.getText());
			event.printSnap("CRM-Save Success Msg");
		}
		else if(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()))
		{
			Assert.assertTrue(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()),"On Duplicate Save Sucess Msg Verifcation");
			getLog().info(obj.ResponseMsg.getText());
			event.printSnap("CRM-Save Duplicate Msg");
		}
		return flag;


	}

	public int FieldError() throws Exception
	{
		errCount=0;	
		List<WebElement> errorMsg=obj.GetFieldOnSaveError;

		if(errorMsg.size()!=0)
		{	
			getLog().info("Error Messages: ");
			for(WebElement ErrList:errorMsg)
			{
				errCount++;
				getLog().info(ErrList.getText());
				////event.printSnap("Maker Screen-ErrorMsg :"+epay_TestScript_PropertyFileConfig.errCount);
				event.printSnap("Maker Screen-ErrorMsg :"+errCount);
			}
		}
		else{

			getLog().info("Any Error Messages on Save/Update : "+errCount);
			errCount=0;

		}
		return errCount;

	}

	public void Logout() throws Exception {
		// TODO Auto-generated method stub

		while (retryCount < 5) {
			try {
				System.out.println("\n Logout Retry Attempt : " + retryCount);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				wait.until(ExpectedConditions.visibilityOf(obj.ClickLogout)).click();
				getLog().info("CRM-Logout Successfully");
				event.printSnap("CRM-Successful LogOut");
				break; // Exit loop after successful logout
			} catch (Exception e) {
				retryCount++;
				System.out.println("Retry attempt failed. Attempt: " + retryCount);
				if (retryCount >= 5) {
					System.out.println("All retry attempts failed.");
					throw e; // After 3 retries, rethrow the exception
				}
			}
		}
	}

	public String MakerCaptureMsg() throws Exception
	{
		String alert=obj.ResponseMsg.getText();
		event.printSnap("Maker Status Message");
		return alert;
	}


	public void ClickOnVerifyButton() throws Exception
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//Assert.assertTrue(obj.AddButton.isDisplayed(),"AddButton Verification");
		wait.until(ExpectedConditions.elementToBeClickable(obj.ClickOnVerifyBtn)).click();
		Assert.assertEquals(obj.OnClickViewLabel.getText(), "Service Provider Response Code Configuration Checker","Label Verification");
		getLog().info("Checker Verification Process Started");
		event.printSnap("CRM-Verification Page");
	}

	public void GoForCheckerProcess(String ParentMenu,String ChildMenu,String ServiceProviderName ,String ServiceProviderResponseCode, String EuronResponseCode, String Action,String CheckerRemarks) throws Exception {

		getLog().info("Checker Process Started");

		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> Operator=wait.until(ExpectedConditions.visibilityOfAllElements(obj.OperatorList));
		List<WebElement> OperatorResponseCode=wait.until(ExpectedConditions.visibilityOfAllElements(obj.OperatorResponseCodeList));
		List<WebElement> ENResponseCode=wait.until(ExpectedConditions.visibilityOfAllElements(obj.EnrspCodeList));

		
		for(int i=0;i<Operator.size();i++)
		{
			if(Operator.get(i).getText().equalsIgnoreCase(ServiceProviderName) || Operator.get(i).getText().equals(""))
			{
				//	System.out.println("if loop---1");
				//SpNameCounter++;
				//System.out.println(Operator.get(i).getText());

				for(int j=0;j<Operator.size();j++)
				{
					//System.out.println("for loop :"+"ServiceResponseCode :"+ServiceProviderResponseCode+"OperatorResponseCodee :"+OperatorResponseCode.get(j).getText());
					if(OperatorResponseCode.get(j).getText().equals(ServiceProviderResponseCode))
					{
						//System.out.println("if loop---2");
						//SpNameCounter++;
						//System.out.println(OperatorResponseCode.get(j).getText());

						for(int k=0;j<OperatorResponseCode.size();k++)
						{
							String tempEnrspCode=EuronResponseCode.substring(0,2);

							int count=1;
							//System.out.println("for loop :"+"EuronetResponseCode :"+EuronResponseCode+" --tempenrspcode : "+tempEnrspCode+" ENResponseCode Code:"+ENResponseCode.get(k).getText());
							if(ENResponseCode.get(k).getText().equals(tempEnrspCode))
							{	
								int sum=count+k;
								wait=new WebDriverWait(driver,Duration.ofSeconds(10));
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr["+ sum +"]/td/input"))).click();
								
								//driver.findElement(By.xpath("//table/tbody/tr["+ sum +"]/td/input")).click();
								getLog().info("On CheckerView-Record Found: "+ServiceProviderName+" / "+ServiceProviderResponseCode+" / "+EuronResponseCode+" ->"+Action);
								event.printSnap("CRM-Record Selected by Checker to Take Action");
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
		
		obj.CheckerRemarks.sendKeys(CheckerRemarks);
		getLog().info("Checker Remarks entered");

		if(Action.equalsIgnoreCase("Reject"))
		{
			event.printSnap("CRM Action Taken "+Action);
			obj.ClickOnReject.click();
		}
		else if(Action.equalsIgnoreCase("Approve"))
		{
			event.printSnap("CRM-Action Taken "+Action);
			obj.ClickOnApprove.click();
		}

		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String checkerAlert=wait.until(ExpectedConditions.visibilityOf(obj.CheckerAlertMsg)).getText();
		getLog().info(checkerAlert);

		getLog().info("Checker Process Ended");
		event.printSnap("CRM-Checker Process Done");

	}



}
