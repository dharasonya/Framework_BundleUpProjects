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
import org.testng.asserts.SoftAssert;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Test_PageObjects.Repo_BillerConfig_Onus;
import ePay_CRM.Test_PageObjects.Repo_ServiceProviderRespCodeMapping;

public class Method_BillerConfigOnus extends BasePageSetup{

	Repo_BillerConfig_Onus obj;
	WebDriver driver;
	int count=0;
	WebDriverWait wait;
	int errCount=0;
	Method_CRMBaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();

	public Method_BillerConfigOnus(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_BillerConfig_Onus(driver);	
		baseStep=new Method_CRMBaseSteps(driver);
	}

	

	public void FillInAddDetails(String BillerId, String ServiceCode, String ServiceProviderName, String ServiceProviderCode, String ValidateAmountFlag,
			String FetchRequirement, String SubServiceProviderName, String SubServiceProviderCode) 
			throws Exception {

		obj.EnterBillerId.sendKeys(BillerId);
		Assert.assertEquals(obj.EnterBillerId.getAttribute("value"),BillerId,"Verify Biller-ID");
		obj.EnterServiceCode.sendKeys(ServiceCode);
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.SelectServiceCode));
		
		for(WebElement serviceCodeValues:obj.SelectServiceCode)
		{
			String tempName[]=serviceCodeValues.getText().split("-");
			String tempServiceCode=tempName[1].replace("(", "").replace(")", "");
			
			if(tempServiceCode.equalsIgnoreCase(ServiceCode))
			{
				serviceCodeValues.click();
				break;
			}
		}
		
		obj.EnterServiceProviderName.sendKeys(ServiceProviderName);
		Assert.assertTrue(obj.EnterServiceProviderName.getAttribute("value").equals(ServiceProviderName));
		
		obj.EnterServiceProviderCode.sendKeys(ServiceProviderCode);
		Assert.assertTrue(obj.EnterServiceProviderCode.getAttribute("value").equals(ServiceProviderCode));
		
		Select selectValdFlag=new Select(obj.ChooseValidationFlag);
		selectValdFlag.selectByVisibleText(ValidateAmountFlag);
		Assert.assertTrue(selectValdFlag.getFirstSelectedOption().getText().equals(ValidateAmountFlag), "Verify Validation Amount Flag");
		
		Select selectFetchReqMandatory=new Select(obj.SelectFetchRequirement);
		selectFetchReqMandatory.selectByVisibleText(FetchRequirement.toUpperCase());
		Assert.assertTrue(selectFetchReqMandatory.getFirstSelectedOption().getText().equals(FetchRequirement.toUpperCase()), "Verify FetchRequirement Flag");
		
		obj.EnterSubServiceProviderName.sendKeys(SubServiceProviderName);
		Assert.assertTrue(obj.EnterSubServiceProviderName.getAttribute("value").equals(SubServiceProviderName));
		
		obj.EnterSubServiceProviderCode.sendKeys(SubServiceProviderCode);
		Assert.assertTrue(obj.EnterSubServiceProviderCode.getAttribute("value").equals(SubServiceProviderCode));
		
		obj.ClickOnSave1.click();
		
		getLog().info(wait.until(ExpectedConditions.visibilityOf(obj.verifyOnSaveSuccessMsg1)).getText());
		obj.clickOnClose.click();
		if(obj.verifyOnSaveSuccessMsg1.getText().equals("Record Successfully Added for STEP - 1"))
		{
			FillInAddStep2();
		}
		event.printSnap("CRM STEP 1 Details Added");
		
	
	}  

	public void FillInAddStep2()
	{
		System.out.println("\n call");
	}
	/*public boolean clickOnSaveButton() throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(obj.clickOnSaveBtn)).click();
		//	obj.ClickOnSave.click();
		String onSaveNewExpMsg="Service Provider Response Code added successfully.";
		String onSaveDupExpMsg="Service Provider Response Code already exists.";
		
		try
		{
			if(onSaveNewExpMsg.equals(obj.ResponseMsg.getText().trim()))
			{
				Assert.assertTrue(onSaveNewExpMsg.equals(obj.ResponseMsg.getText()),"On Save Sucess Msg Verifcation");
				flag=true;
				getLog().info(obj.ResponseMsg.getText());
				event.printSnap("CRM Save Success Msg");
			}
			else if(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()))
			{
				Assert.assertTrue(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()),"On Duplicate Save Sucess Msg Verifcation");
				getLog().info(obj.ResponseMsg.getText());
				event.printSnap("CRM Save Duplicate Msg");
			}
		}
		catch(Exception e)
		{
			getLog().info("Unable to Save Records due to error occured");
		}
		
		return flag;


	}

	public int FieldError() throws Exception
	{
	
		SoftAssert softAssert=new SoftAssert();

		errCount=0;	
		List<WebElement> errorMsg=obj.GetFieldOnSaveError;

		if(errorMsg.size()!=0)
		{	
			
			for(WebElement ErrList:errorMsg)
			{
				errCount++;
				getLog().info("Error Messages: "+errCount+" - "+ErrList.getText());
				//getLog().info(ErrList.getText());
				////event.printSnap("Maker Screen-ErrorMsg :"+epay_TestScript_PropertyFileConfig.errCount);
				event.printSnap("Maker Screen ErrorMsg "+errCount);
				softAssert.assertEquals(ErrList.getText(),"On Save Sucess Msg Verifcation");
			}
		}
		else{

			getLog().info("Any Error Messages on Save/Update : "+errCount);
			errCount=0;

		}
		softAssert.assertAll();
		return errCount;
		

	}

	public void Logout() throws Exception {
		// TODO Auto-generated method stub
		while (retryCount < 5) {
			try {
				System.out.println("\n Logout Retry Attempt : " + retryCount);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				wait.until(ExpectedConditions.visibilityOf(obj.ClickLogout)).click();
				getLog().info("CRM Logout Successfully");
				event.printSnap("CRM Successful LogOut");
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
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Assert.assertEquals(obj.OnClickVerifyMode.getText(), "Service Provider Response Code Configuration Checker","Label Verification");
		getLog().info("Checker Verification Process Started");
		event.printSnap("CRM Verification Page");
	}

	public void GoForCheckerProcess(String ParentMenu,String ChildMenu,String ServiceProviderName ,String ServiceProviderResponseCode, String EuronResponseCode, String Action,String CheckerRemarks) throws Exception {

		getLog().info("Checker Process Started");
		
		

		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> Operator=wait.until(ExpectedConditions.visibilityOfAllElements(obj.OperatorList));
		List<WebElement> OperatorResponseCode=wait.until(ExpectedConditions.visibilityOfAllElements(obj.OperatorResponseCodeList));
		List<WebElement> ENResponseCode=wait.until(ExpectedConditions.visibilityOfAllElements(obj.EnrspCodeList));

		System.out.println("\n Operator name : "+ServiceProviderName);

		for(int i=0;i<Operator.size();i++)
		{
			if(Operator.get(i).getText().equalsIgnoreCase(ServiceProviderName) || Operator.get(i).getText().equals("NPCI"))
			{
			//	System.out.println("if loop---1");
				//SpNameCounter++;
				//System.out.println(Operator.get(i).getText());

				for(int j=0;j<Operator.size();j++)
				{
					//System.out.println("for loop :"+"ServiceResponseCode :"+ServiceProviderResponseCode+"OperatorResponseCodee :"+OperatorResponseCode.get(j).getText());
					if(OperatorResponseCode.get(j).getText().equals(ServiceProviderResponseCode))
					{
						System.out.println("if loop---2");
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
								event.printSnap("CRM Record Selected by Checker to Take Action");
								

								//
								wait=new WebDriverWait(driver,Duration.ofSeconds(10));
								wait.until(ExpectedConditions.visibilityOf(obj.CheckerRemarks)).sendKeys(CheckerRemarks);
							
							//	obj.CheckerRemarks.sendKeys(CheckerRemarks);
								getLog().info("Checker Remarks entered");

								if(Action.equalsIgnoreCase("Reject"))
								{
									event.printSnap("CRM Action Taken "+Action);
									obj.ClickOnReject.click();
								}
								else if(Action.equalsIgnoreCase("Approve"))
								{
									event.printSnap("CRM Action Taken "+Action);
									obj.ClickOnApprove.click();
								}

								wait=new WebDriverWait(driver,Duration.ofSeconds(20));
								String checkerAlert=wait.until(ExpectedConditions.visibilityOf(obj.CheckerAlertMsg)).getText();
								getLog().info(checkerAlert);

								getLog().info("Checker Process Ended");
								event.printSnap("CRM Checker Process Done");

								//

								baseStep.SelectMainMenu(ParentMenu,ChildMenu);// added new
								
								
								CheckerGrid(ServiceProviderName,ServiceProviderResponseCode,EuronResponseCode,Action,CheckerRemarks);
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
	
	public void CheckerGrid(String ServiceProviderName,String ServiceProviderResponseCode, String EuronResponseCode, String Action,String CheckerRemarks) throws Exception {
		// TODO Auto-generated method stub

		obj.EnterSearchValue.sendKeys(ServiceProviderName);
		event.printSnap("CRM CheckerGridSearch");

		getLog().info("Search Records Found " + driver.findElement(By.id("tblReport_info")).getText());
		int chk = 0;
		List<WebElement> pageList=driver.findElements(By.xpath("//div[@id='tblReport_paginate']/span/a"));

		int pageNum=0;


		int consValue=0;

		int pageCounter=0;
		String countRecord=obj.CountOfRecords.getText();
		//System.out.println("\n Count : "+countRecord);
		String recSplit[]=countRecord.split(" ");


		String maxCount=recSplit[3];
		int totalRecords=Integer.parseInt((recSplit[5].toString().replace(",", "")));
		//System.out.println(maxCount);
		driver.findElements(By.xpath("//div[@id='tblReport_paginate']/span/a"));
		for(WebElement pagNum:pageList)
		{
			pageCounter++;


		}

		//System.out.println("Last Page : "+pageCounter);
		//System.out.println("Total Page : "+totalRecords);


		for(int i=0;i<totalRecords;i++)
		{
			pageNum++;
			if(pageNum<5)
			{
				getLog().info("Search Process On Page No "+pageNum);
				try
				{
					driver.findElement(By.xpath("//div[@id='tblReport_paginate']/span/a["+pageNum+"]")).click();
					boolean Verify=CheckerCriteria(ServiceProviderName,ServiceProviderResponseCode,EuronResponseCode);
					//System.out.println("\n Verify : "+Verify);
					if(Verify==true)
					{
						event.printSnap("Back to CheckerGrid");

						getLog().info("Search Record Found on Page No "+pageNum);
						//LaunchBrowserConfig.WindowScrollHeight();
						//event.printSnap("CRM-CheckerGridPage 2"+tempCount);
						break;
					}	
					else
					{
						getLog().info("No Record Found of Page No "+pageNum);
						//LaunchBrowserConfig.WindowScrollHeight();
						event.printSnap("CRM CheckerGridPage "+pageNum);
						consValue=5;
					}
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					getLog().info("Page Not Available to check further");

					event.printSnap("Page Not Available to check further "+pageNum);
					break;
				}
			}
			else if(pageNum==5 && consValue<6)
			{
				getLog().info("Search Process On Page No "+pageNum);
				event.printSnap("CRM CheckerGridPage "+pageNum);

				Thread.sleep(5000);
				if(consValue==5)
				{
					driver.findElement(By.xpath("//div[@id='tblReport_paginate']/span/a["+pageNum+"]")).click();
					boolean Verify=CheckerCriteria(ServiceProviderName,ServiceProviderResponseCode,EuronResponseCode);
					if(Verify==true)
					{
						getLog().info("Search Record Found on Page No "+pageNum);
						//LaunchBrowserConfig.WindowScrollHeight();
						event.printSnap("CRM CheckerGridPage "+pageNum);
						break;
					}
					else
					{
						getLog().info("No Record Found of Page No "+pageNum);
						//LaunchBrowserConfig.WindowScrollHeight();
						event.printSnap("CRM CheckerGridPage "+pageNum);
						consValue=6;

					//	break;
					}	
				}

			}

			else if(consValue>=6 && (pageNum>=6 && pageNum<=totalRecords))
			{
				getLog().info("Search Process On Page No. :"+pageNum);
				event.printSnap("CRM CheckerGridPage "+pageNum);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//a[@id='tblReport_next']")).click();
				boolean Verify=CheckerCriteria(ServiceProviderName,ServiceProviderResponseCode,EuronResponseCode);
				
				if(Verify==true)
				{
					getLog().info("Search Record Found on Page No "+pageNum);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM CheckerGridPage "+pageNum);
					break;
				}
				else
				{
					getLog().info("No Record Found of Page No "+pageNum);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM CheckerGridPage "+pageNum);
					
					try
					{
						driver.findElement(By.xpath("//div[@id='tblReport_paginate']/a[2][contains(@class, 'disabled')]"));
						break;
					}
					catch(Exception e)
					{
						continue;
					}
				}

			}		
		}
	}


	public boolean CheckerCriteria(String ServiceProviderName,String ServiceProviderResponseCode, String EuronResponseCode) throws Exception {

		int temp=0;
		int flagChk=0;
		boolean flag=false;
		int index=0;
		for(WebElement serviceProviderNameList:driver.findElements(By.xpath("//tbody/tr/td[3]")))
		{
			//System.out.println(serviceProviderNameList.getText());
			temp++;
			if(serviceProviderNameList.getText().equalsIgnoreCase(ServiceProviderName) || serviceProviderNameList.getText().equalsIgnoreCase("NPCI"))
			{
				//System.out.println("ServiceProviderName  Value Matched ");
				for(WebElement ServiceProviderResponseCodeValueList:driver.findElements(By.xpath("//tbody/tr/td[4]")))
				{
				//	System.out.println("\n ServiceProviderResponseCode : "+ServiceProviderResponseCodeValueList.getText());
					index++;
					if(ServiceProviderResponseCodeValueList.getText().equals(ServiceProviderResponseCode))
					{
					//	System.out.println("ServiceProviderResponseCodeValue Value  Matched : "+ServiceProviderResponseCodeValueList.getText());

						for(WebElement EuronResponseCodeList:driver.findElements(By.xpath("//tbody/tr/td[5]")))
						{

							//System.out.println(valueList.getText());
							if(EuronResponseCodeList.getText().equals(EuronResponseCode))
							{
								//System.out.println("Value  Matched : "+valueList.getText()+" : "+index); 
								driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[1]")).click();
								event.printSnap("CRM ToBeViewedRecordSelected");
								clickOnViewButton();

								clickOnBackButton();

								//flagChk=1;
								flag=true;
								break;
							}

						}
						break;
					}

				}
				break;
			}

		}
		return flag;

	}

	public void clickOnViewButton() throws Exception {

		obj.ClickOnView.click();
		Assert.assertTrue(obj.OnClickViewMode.getText().equals("Service Provider Response Code View"),"View Menu Verifcation");
		getLog().info("Clicked on View Button");
		event.printSnap("CRM View Mode");
		
		

	}
	public void clickOnBackButton() throws Exception
	{
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(obj.ClickOnBack)).click();
		//obj.ClickOnBack.click();
		Assert.assertTrue(obj.MenuHeaderName.getText().equals("Service Provider Response Code Mapping"));
		getLog().info("Clicked on Back Button");
		event.printSnap("CRM Navigated Back");
	}*/



	

}
