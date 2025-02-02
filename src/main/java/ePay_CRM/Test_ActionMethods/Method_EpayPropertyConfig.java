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

public class Method_EpayPropertyConfig extends BasePageSetup{

	Repo_EpayPropertyConfig obj;
	WebDriver driver;
	int count=0;
	WebDriverWait wait;
	int errCount=0;
	Method_CRMBaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();

	public Method_EpayPropertyConfig(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_EpayPropertyConfig(driver);	
		baseStep=new Method_CRMBaseSteps(driver);
	}

	public void ClickOnAddButton() throws Exception
	{
		try
		{
			if(addRetryCheck<3)
			{
				wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				Assert.assertTrue(obj.AddButton.isDisplayed(),"AddButton Verification");
				wait.until(ExpectedConditions.elementToBeClickable(obj.AddButton)).click();
				getLog().info("Clicked on Add Button");
			//	event.printSnap("CRM-Add Menu Opened");
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

	public String MakerCaptureMsg() throws Exception
	{
		String alert=obj.ResponseMessage.getText();
		event.printSnap("Maker Status Message");
		return alert;
	}

	public int FieldError() throws Exception
	{
		errCount=0;	
		List<WebElement> errorMsg=obj.GetFieldOnSaveError;

		if(errorMsg.size()!=0)
		{	
			//getLog().info("Error Messages: ");
			for(WebElement ErrList:errorMsg)
			{
				errCount++;
				getLog().info("Error Messages: "+errCount +" :" +ErrList.getText());
				////event.printSnap("Maker Screen-ErrorMsg :"+epay_TestScript_PropertyFileConfig.errCount);
				event.printSnap("Maker Screen ErrorMsg "+errCount);
			}
		}
		else{

			getLog().info("Any Error Messages on Save/Update : "+errCount);
			errCount=0;

		}
		return errCount;

	}

	public void FillInAddDetails(String ApplicationName,String Key,String Value,String Status,String Description,String Remarks) throws Exception {

		event.printSnap("CRM Add Menu Opened");
		obj.EnterApplicationName.sendKeys(ApplicationName);
		Assert.assertEquals(obj.EnterApplicationName.getAttribute("value"),ApplicationName,"Application Name Verification");

		obj.EnterKey.sendKeys(Key);
		Assert.assertEquals(obj.EnterKey.getAttribute("value"),Key,"Application Name Verification");

		obj.EnterValue.sendKeys(Value);
		Assert.assertEquals(obj.EnterValue.getAttribute("value"),Value,"Application Name Verification");

		WebElement selectList=obj.SelectStatus;
		Select selectValue=new Select(selectList);
		selectValue.selectByVisibleText(Status);

		Assert.assertEquals(obj.SelectStatus.getAttribute("value"),"1","Application Name Verification");

		obj.EnterDescription.sendKeys(Description);
		Assert.assertEquals(obj.EnterDescription.getAttribute("value"),Description,"Application Name Verification");

		obj.EnterRemark.sendKeys(Remarks);
		Assert.assertEquals(obj.EnterRemark.getAttribute("value"),Remarks,"Application Name Verification");

		getLog().info("Added all the Details,Proceed to Save");
		event.printSnap("CRM-Added New Details");
	}  

	public boolean clickOnSaveButton() throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(obj.ClickOnSave)).click();
		//	obj.ClickOnSave.click();
		String onSaveNewExpMsg="ePay Property File configuration details added successfully and sent for Checker Approval!";
		String onSaveDupExpMsg="ePay Property File configuration already exists";

		try
		{
			if(onSaveNewExpMsg.equals(obj.ResponseMessage.getText()))
			{
				Assert.assertTrue(onSaveNewExpMsg.equals(obj.ResponseMessage.getText()),"On Save Sucess Msg Verifcation");
				flag=true;
				getLog().info(obj.ResponseMessage.getText());
				event.printSnap("CRM-Save Success Msg");
			}
			else if(onSaveDupExpMsg.equals(obj.ResponseMessage.getText()))
			{
				Assert.assertTrue(onSaveDupExpMsg.equals(obj.ResponseMessage.getText()),"On Duplicate Save Sucess Msg Verifcation");
				getLog().info(obj.ResponseMessage.getText());
				event.printSnap("CRM-Save Duplicate Msg");
			}
		}
		catch(Exception e)
		{
			getLog().info("Unable to Save Records due to error occured");
		}
		
		return flag;


	}

	public boolean clickOnUpdateButton() throws Exception {

		boolean flag=false;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(obj.ClickOnSubmit)).click();

		//obj.ClickOnSubmit.submit(); 
		getLog().info(obj.ResponseMessage.getText());

		String onUpdateNewExpMsg="ePay Property File configuration details edited successfully and sent for Checker Approval!";
		String onUpdateDupExpMsg="Kindly approve/reject previous edited record";


		if(onUpdateNewExpMsg.equals(obj.ResponseMessage.getText()))
		{
			Assert.assertTrue(onUpdateNewExpMsg.equals(obj.ResponseMessage.getText()),"On Edit Sucess Msg Verifcation");
			getLog().info(onUpdateNewExpMsg);
			flag=true;

			event.printSnap("CRM-Update Success Msg");
		}
		else if(onUpdateDupExpMsg.equals(obj.ResponseMessage.getText()))
		{
			//System.out.println("check");  
			Assert.assertTrue(onUpdateDupExpMsg.equals(obj.ResponseMessage.getText()),"On Edit Sucess Msg Verifcation");
			getLog().info(onUpdateDupExpMsg);
			System.out.println("Test Enter");
			event.printSnap("CRM-Update Duplicate Msg");
			flag=false;
		}

		return flag;


	}

	public void clickOnResetButton() throws Exception {
		// TODO Auto-generated method stub

		obj.ClickOnReset.click();

		Assert.assertEquals(obj.EnterApplicationName.getAttribute("value"),"","Application Name Clear Verification");
		Assert.assertEquals(obj.EnterKey.getAttribute("value"),"","Key Clear Verification");
		Assert.assertEquals(obj.EnterValue.getAttribute("value"),"","Value Clear Verification");
		Assert.assertEquals(obj.SelectStatus.getAttribute("value"),"0","Status Clear Verification");
		Assert.assertEquals(obj.EnterDescription.getAttribute("value"),"","Description Clear Verification");
		Assert.assertEquals(obj.EnterRemark.getAttribute("value"),"","Remark Clear Verification");

		getLog().info("Reset Done succesfully!!..");
		event.printSnap("CRM-Data Reset Done");
	}

	public void clickOnBackButton() throws Exception
	{

		//System.out.println("\n Back call");
		obj.ClickOnBack.click();
		Assert.assertTrue(obj.MenuHeaderName.getText().equals("ePay Property File Configuration"));
		getLog().info("Clicked on Back Button");
		event.printSnap("CRM-Navigated Back");
	}

	public void clickOnViewButton() throws Exception {

		obj.ClickOnView.click();
		Assert.assertTrue(obj.OnClickViewLabel.getText().equals("ePay Property File Configuration View"),"View Menu Verifcation");
		getLog().info("Clicked on View Button");
		event.printSnap("CRM-View Mode");

	}

	public void EnterSearchValue(String SearchCriteria) throws Exception
	{
		obj.EnterSearchValue.sendKeys(SearchCriteria);
		getLog().info("Search Criteria Entered : "+SearchCriteria);
		event.printSnap("CRM-Searched Records");
	}

	public boolean EnterSearchCriteria(String ApplicationName,String Key,String Value,String NewValue,String Description,String NewDescription,String Status,String NewStatus,String Remarks) throws Exception {

		int temp=0;
		int flagChk=0;
		boolean flag=false;
		int index=0;
		//	System.out.println("Method Called");
		for(WebElement applNameValues:obj.getApplicationNameList)
		{
			//System.out.println(applNameValues.getText());
			temp++;
			if(applNameValues.getText().equals(ApplicationName))
			{
				//System.out.println("Application Name Value Matched ");
				for(WebElement keyValue:obj.getKeyList)
				{
					index++;
					if(keyValue.getText().equals(Key))
					{
						//System.out.println("Key Value  Matched : "+keyValue.getText());

						for(WebElement valueList:obj.getValue)
						{
							//System.out.println(valueList.getText());
							if(valueList.getText().equals(Value))
							{
								getLog().info("Value  Matched : "+valueList.getText()+" / Available at Index: "+index); 
								driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[1]")).click();
								event.printSnap("Record Selected to Edit");
								obj.EditButton.click();
								FillInEditDetails(ApplicationName,Key,Value,NewValue,Status,NewStatus,Description,NewDescription,Remarks);

								clickOnUpdateButton();
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


	public boolean ViewSearchCriteria(String ApplicationName,String Key,String Value) throws Exception {

		int temp=0;
		int flagChk=0;
		boolean flag=false;
		int index=0;


		for(WebElement applNameValues:obj.getApplicationNameList)
		{
			//System.out.println(applNameValues.getText());
			temp++;
			if(applNameValues.getText().equals(ApplicationName))
			{
				//System.out.println("Application Name Value Matched ");
				for(WebElement keyValue:obj.getKeyList)
				{
					index++;
					if(keyValue.getText().equals(Key))
					{
						//System.out.println("Key Value  Matched : "+keyValue.getText());

						for(WebElement valueList:obj.getValue)
						{
							//System.out.println(valueList.getText());
							if(valueList.getText().equalsIgnoreCase(Value))
							{
								getLog().info("Value  Matched : "+valueList.getText()+" / Available at Index: "+index); 
								driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[1]")).click();
								event.printSnap("Record Selected to View");
								//obj.EditButton.click();
								//FillInEditDetails(ApplicationName,Key,Value,Description,Status);
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



	public void ViewRecords(String ApplicationName,String Key,String Value,String Description,String Status) throws Exception {


		Assert.assertTrue(obj.EnterApplicationName.getAttribute("readonly").equals("true"), "Application Text Verification");
		Assert.assertTrue(obj.EnterKey.getAttribute("readonly").equals("true"), "Key Text Verification");
		Assert.assertTrue(obj.EnterValue.getAttribute("readonly").equals("true"), "Value Text Verification");
		Assert.assertTrue(obj.EnterDescription.getAttribute("readonly").equals("true"), "Description Text Verification");
		Assert.assertTrue(obj.ActiveFlag.getAttribute("readonly").equals("true"), "Status Text Verification");

		Assert.assertTrue(obj.EnterApplicationName.getAttribute("value").equals(ApplicationName), "Application Text Verification");
		Assert.assertTrue(obj.EnterKey.getAttribute("value").equals(Key), "Key Text Verification");
		Assert.assertTrue(obj.EnterValue.getAttribute("value").equalsIgnoreCase(Value), "Value Text Verification");
		Assert.assertTrue(obj.EnterDescription.getAttribute("value").equals(Description), "Description Text Verification");
		Assert.assertTrue(obj.ActiveFlag.getAttribute("value").equals(Status), "Status Text Verification");	
		getLog().info("Records Opened in View Mode");

		clickOnBackButton();	
	}

	public void clickOnEditButton() throws Exception {
		// TODO Auto-generated method stub
		obj.EditButton.click();
		event.printSnap("Edit Mode Opended");
	}

	public void FillInEditDetails(String ApplicationName,String Key,String Value,String Status,String Description,String Remarks,
			String NewValue,String NewDescription,String NewStatus) throws Exception
	{

		getLog().info("Edit Process Started");
		Assert.assertTrue(obj.EnterApplicationName.getAttribute("value").equals(ApplicationName),"Application Name Verification");

		Assert.assertTrue(obj.EnterKey.getAttribute("value").equals(Key),"Key Name Verification");

		Assert.assertTrue(obj.EnterValue.getAttribute("value").equals(Value),"Value Verification");

		if(!obj.EnterValue.getAttribute("value").equals(NewValue))
		{
			obj.EnterValue.clear();
			obj.EnterValue.sendKeys(NewValue);
			Assert.assertTrue(obj.EnterValue.getAttribute("value").equals(NewValue),"Value Verification");
		}


		WebElement selectList=obj.SelectStatus;
		Select selectValue=new Select(selectList);
		System.out.println(selectValue.getFirstSelectedOption().getText());
		Assert.assertEquals(selectValue.getFirstSelectedOption().getText(),Status,"Status Verification");
		if(!selectValue.getFirstSelectedOption().getText().equals(NewStatus))
		{
			selectValue.selectByVisibleText(NewStatus);
			//System.out.println(obj.SelectStatus.getAttribute("value"));
			//System.out.println(selectValue.getFirstSelectedOption().getText());
			Assert.assertEquals(selectValue.getFirstSelectedOption().getText(),NewStatus,"Status Verification");
			//	Assert.assertEquals(false, false);

		}


		if(!obj.EnterDescription.getAttribute("value").equals(NewDescription))
		{
			obj.EnterDescription.clear();
			obj.EnterDescription.sendKeys(NewDescription);
			Assert.assertTrue(obj.EnterDescription.getAttribute("value").equals(NewDescription),"Description Verification");
		}

		Assert.assertTrue(obj.EnterRemark.getAttribute("value").equals(""),"Maker Input Verification");
		obj.EnterRemark.sendKeys(Remarks);
		Assert.assertTrue(obj.EnterRemark.getAttribute("value").equals(Remarks),"Maker Verification");

		event.printSnap("CRM Edited New Records");
	}


	public void ReadRecords() {

		//event.printSnap("Open Records in View Mode");
		getLog().info(obj.EnterApplicationName.getAttribute("value")+" \\ "+obj.EnterKey.getAttribute("value")+" \\ "+obj.EnterValue.getAttribute("value")+" \\ "+obj.EnterDescription.getAttribute("value")+" \\ "+obj.ActiveFlag.getAttribute("value"));
		//event.printSnap("Open Records in View Mode");
		Assert.assertTrue(obj.EnterApplicationName.getAttribute("readonly").equals("true"), "Application Text Verification");
		Assert.assertTrue(obj.EnterKey.getAttribute("readonly").equals("true"), "Key Text Verification");
		Assert.assertTrue(obj.EnterValue.getAttribute("readonly").equals("true"), "Value Text Verification");
		Assert.assertTrue(obj.EnterDescription.getAttribute("readonly").equals("true"), "Description Text Verification");
		Assert.assertTrue(obj.ActiveFlag.getAttribute("readonly").equals("true"), "Status Text Verification");


	}

	public void ViewAllRecords() throws Exception {

		//int tempCount=0;
		//      System.out.println("Search Size :" + obj.SearchGridValues.size() );
		getLog().info("Search Records Found " + driver.findElement(By.id("BBPSConfigData_info")).getText());
		int chk = 0;
		List<WebElement> pageList=driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));

		int tempCount=0;
		int count=0;
		int temp=0;
		int consValue=0;
		int x=1;
		int pageNumber=0;
		int nextCounter=0;
		String countRecord=obj.CountOfRecords.getText();
		//	System.out.println	("\n Count : "+countRecord);
		String recSplit[]=countRecord.split(" ");


		String maxCount=recSplit[5];
		int totalRecords=Integer.parseInt((recSplit[5].toString().replace(",", "")));
		//System.out.println(maxCount);
		//System.out.println("End Value : "+driver.findElement(By.xpath("//*[@data-dt-idx='6']")).getText());
		int lastPage=Integer.parseInt(driver.findElement(By.xpath("//*[@data-dt-idx='6']")).getText().toString());
		//System.out.println("Last Page : "+lastPage);

		for(int i=0;i<totalRecords;i++)
		{

			pageNumber++;
			tempCount++;

			if(tempCount<5)//(tempCount<5)
			{

				getLog().info("Search Process On Page No "+pageNumber);
				event.printSnap("CRM SearchPage "+pageNumber);
				count++;
				//--stem.out.println("\n Loop :"+count);
				//tempCount++;

				//div[@id='BBPSConfigData_paginate']/span/a[]

				// driver.findElement(By.xpath("//div[@id='tblReport_paginate']/span/a["+tempCount+"]")).click();

				driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();

				for(int j=0;j<10;j++)
				{  
					try
					{

						List<WebElement> listRadio=driver.findElements(By.xpath("//*[@id='radio']"));
						//System.out.println("\n j value :" +listRadio.get(j).getText());
						//getLog().info(j +" : ");
						listRadio.get(j).click();

						event.printSnap("Record Selected on Page "+pageNumber+" for Row "+j);
						obj.ClickOnView.click();
						Assert.assertEquals("ePay Property File Configuration View",obj.ViewMenuName.getText());

						event.printSnap("Open Records in View Mode on Page "+pageNumber+" for Row "+j);
						//Thread.sleep(6000);
						//event.printSnap("Open Records in View Mode "+" for Row "+j);
						getLog().info("Open Records in View Mode on Page "+pageNumber+" for Row "+j);

						ReadRecords();
						clickOnBackButton();


						driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();

					}
					catch(Exception e)
					{
						getLog().info("No Further Records to view");
						break;
					}

				} 
			} 
			else if(tempCount==5)
			{
				//tempCount++;
				temp=3;
				consValue=5;
				getLog().info("\n Search Process On Next Page No "+pageNumber);
				event.printSnap("CRM SearchPage "+pageNumber);
				Thread.sleep(5000);
				if(consValue==5)
				{


					driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
					consValue=0;event.printSnap("CRM-Edited New Records");event.printSnap("CRM-Edited New Records");
					for(int j=0;j<10;j++) 
					{

						List<WebElement> listRadio=driver.findElements(By.xpath("//*[@id='radio']"));
						//   System.out.println("\n j value :" +listRadio.get(j).getText());
						//getLog().info(j +" : ");
						listRadio.get(j).click();
						event.printSnap("Record Selected on Page "+pageNumber+" for Row "+j);
						obj.ClickOnView.click();
						Assert.assertEquals("ePay Property File Configuration View",obj.ViewMenuName.getText());
						event.printSnap("Open Records in View Mode on Page "+pageNumber+" for Row "+j);
						//event.printSnap("Open Records in View Mode "+" for Row "+j);
						getLog().info("Open Records in View Mode on Page "+pageNumber+" for Row "+j);

						ReadRecords();
						clickOnBackButton();
						driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();




						/*for(int k=0;k<count;k++)
								{
									driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
								}
								break;*/


						consValue=6;
						//System.out.println("---consValue :"+consValue);
					}

					//System.out.println("Constant Value : "+consValue +" / tempCount : "+tempCount+"LastPage :"+lastPage);


				}
			}
			else if(consValue==6 && tempCount==6)
			{
				getLog().info("Search Process On Next Page No "+pageNumber);
				event.printSnap("CRM SearchPage "+pageNumber);

				Thread.sleep(5000);
				//driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a[5]")).click();
				driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();

				nextCounter++;

				for(int j=0;j<10;j++)
				{
					try
					{
						Thread.sleep(3000);

						List<WebElement> listRadio=driver.findElements(By.xpath("//*[@id='radio']"));
						//   System.out.println("\n j value :" +listRadio.get(j).getText());
						//	getLog().info(j +" : ");
						listRadio.get(j).click();
						event.printSnap("Record Selected on Page "+pageNumber+" for Row "+j);
						obj.ClickOnView.click();
						Assert.assertEquals("ePay Property File Configuration View",obj.ViewMenuName.getText());
						event.printSnap("Open Records in View Mode on Page "+pageNumber+" for Row "+j);
						//event.printSnap("Open Records in View Mode "+" for Row "+j);
						getLog().info("Open Records in View Mode on Page "+pageNumber+" for Row "+j);

						ReadRecords();
						clickOnBackButton();
						for(int k=0;k<tempCount-1;k++)
						{
							driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
						}
					}
					catch(Exception e)
					{
						getLog().info("No Further Records to view");
						break;
					}


				}
				consValue++;

			}

			else if(consValue>6 && (tempCount>6 && tempCount<=lastPage))
			{
				getLog().info("Search Process On Next Page No "+pageNumber);
				event.printSnap("CRM SearchPage "+pageNumber);


				Thread.sleep(5000);
				//driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a[5]")).click();
				driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();

				nextCounter++;

				for(int j=0;j<10;j++)
				{
					try
					{
						Thread.sleep(3000);
						List<WebElement> listRadio=driver.findElements(By.xpath("//*[@id='radio']"));
						//   System.out.println("\n j value :" +listRadio.get(j).getText());
						//getLog().info(j +" : ");
						listRadio.get(j).click();
						event.printSnap("Record Selected on Page "+pageNumber+" for Row "+j);
						obj.ClickOnView.click();
						Assert.assertEquals("ePay Property File Configuration View",obj.ViewMenuName.getText());
						event.printSnap("Open Records in View Mode on Page "+pageNumber+" for Row "+j);
						//event.printSnap("Open Records in View Mode "+" for Row "+j);
						getLog().info("Open Records in View Mode on Page "+pageNumber+" for Row "+j);

						ReadRecords();
						clickOnBackButton();
						for(int k=0;k<tempCount-1;k++)
						{
							driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
						}
					}
					catch(Exception e)
					{
						getLog().info("No Further Records to view");
						break;
					}

				}

			}
			else
			{ 
				break;
			}
		}  

		//	} 
	}
	//}

	public boolean CheckMatchedCriteria(String applicationName, String key, String value, String newValue,
			String description, String newDescription, String status, String newStatus, String remarks) throws Exception {
		// TODO Auto-generated method stub

		boolean flag=false;
		getLog().info("Search Records Found " + driver.findElement(By.id("BBPSConfigData_info")).getText());
		int chk = 0;
		List<WebElement> pageList=driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));

		int tempCount=0;


		int consValue=0; 

		int pageCounter=0;
		String countRecord=obj.CountOfRecords.getText();
		//System.out.println("\n Count : "+countRecord);
		String recSplit[]=countRecord.split(" ");


		String maxCount=recSplit[5];
		int totalRecords=Integer.parseInt((recSplit[5].toString().replace(",", "")));
		//System.out.println(maxCount);
		driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));
		for(WebElement pagNum:pageList)
		{
			pageCounter++;


		}
		//driver.manage().window().fullscreen();
		//System.out.println("Last Page : "+pageCounter);
		//System.out.println("Total Page : "+totalRecords);

		for(int i=0;i<totalRecords;i++)
		{
			tempCount++;
			if(tempCount<5)
			{ 
				getLog().info("Search Process On Page No "+tempCount);
				//event.printSnap("CRM-SearchPage "+tempCount);

				driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
				boolean Verify=EnterSearchCriteria(applicationName,key,value,newValue,status,newStatus,description,newDescription,remarks);
				if(Verify==true)
				{
					getLog().info("Search Record Found & Processed on Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					//event.printSnap("CRM-MakerGridPage "+tempCount);
					flag=true;
					break;
				}	
				else
				{
					getLog().info("No Record Found of Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM-MakerGridPage "+tempCount);
					consValue=5;
				}	
			}
			else if(tempCount==5)
			{
				getLog().info("Search Process On Next Page No "+tempCount);
				flag=true;
				//event.printSnap("CRM-SearchPage "+tempCount);
				Thread.sleep(5000);
				if(consValue==5)
				{
					driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
					boolean Verify=EnterSearchCriteria(applicationName,key,value,newValue,status,newStatus,description,newDescription,remarks);
					if(Verify==true)
					{
						getLog().info("Search Record Found on Page No "+tempCount);
						//LaunchBrowserConfig.WindowScrollHeight();
						//event.printSnap("CRM-MakerGridPage "+tempCount);
						break;
					}
					else
					{
						getLog().info("No Record Found of Page No "+tempCount);
						//LaunchBrowserConfig.WindowScrollHeight();
						event.printSnap("CRM-MakerGridPage "+tempCount);
						consValue=6;

						//break;
					}	
				}

			}

			else if(consValue>=6 && (tempCount>=6 && tempCount<=totalRecords))
			{
				getLog().info("Search Process On Next Page No "+tempCount);
				//	event.printSnap("CRM-SearchPage "+tempCount);
				Thread.sleep(5000);

				//driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a[5]")).click();
				driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
				boolean Verify=EnterSearchCriteria(applicationName,key,value,newValue,status,newStatus,description,newDescription,remarks);
				if(Verify==true)
				{
					getLog().info("Search Record Found on Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					//event.printSnap("CRM-MakerGridPage "+tempCount);
					flag=true;
					break;
				}
				else
				{
					getLog().info("No Record Found of Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM-MakerGridPage "+tempCount);
				}

			}		
		}
		return flag;

	}

	public boolean ViewMatchedCriteria(String applicationName, String key, String value,String Description,String Status) throws Exception {
		// TODO Auto-generated method stub

		boolean flag=false;
		getLog().info("Search Records Found " + driver.findElement(By.id("BBPSConfigData_info")).getText());
		int chk = 0;
		List<WebElement> pageList=driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));

		int tempCount=0;


		int consValue=0; 

		int pageCounter=0;
		String countRecord=obj.CountOfRecords.getText();
		//System.out.println("\n Count : "+countRecord);
		String recSplit[]=countRecord.split(" ");


		String maxCount=recSplit[5];
		int totalRecords=Integer.parseInt((recSplit[5].toString().replace(",", "")));
		//System.out.println(maxCount);
		driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));
		for(WebElement pagNum:pageList)
		{
			pageCounter++;


		}
		//driver.manage().window().fullscreen();
		//System.out.println("Last Page : "+pageCounter);
		//System.out.println("Total Page : "+totalRecords);

		for(int i=0;i<totalRecords;i++)
		{
			tempCount++;
			if(tempCount<5)
			{
				getLog().info("Search Process On Page No "+tempCount);
				//event.printSnap("CRM-SearchPage "+tempCount);

				driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
				boolean Verify=ViewSearchCriteria(applicationName,key,value);
				if(Verify==true)
				{
					getLog().info("Search Record Found & Processed on Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					//event.printSnap("CRM-MakerGridPage "+tempCount);
					flag=true;
					break;
				}	
				else
				{
					getLog().info("No Record Found of Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM-MakerGridPage "+tempCount);
					consValue=5;
				}	
			}
			else if(tempCount==5)
			{
				getLog().info("Search Process On Next Page No "+tempCount);
				flag=true;
				//event.printSnap("CRM-SearchPage "+tempCount);
				Thread.sleep(5000);
				if(consValue==5)
				{
					driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
					boolean Verify=ViewSearchCriteria(applicationName,key,value);
					if(Verify==true)
					{
						getLog().info("Search Record Found on Page No "+tempCount);
						//LaunchBrowserConfig.WindowScrollHeight();
						//event.printSnap("CRM-MakerGridPage "+tempCount);
						break;
					}
					else
					{
						getLog().info("No Record Found of Page No "+tempCount);
						//LaunchBrowserConfig.WindowScrollHeight();
						event.printSnap("CRM-MakerGridPage "+tempCount);
						consValue=6;

						//break;
					}	
				}

			}

			else if(consValue>=6 && (tempCount>=6 && tempCount<=totalRecords))
			{
				getLog().info("Search Process On Next Page No "+tempCount);
				//	event.printSnap("CRM-SearchPage "+tempCount);
				Thread.sleep(5000);

				//driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a[5]")).click();
				driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
				boolean Verify=ViewSearchCriteria(applicationName,key,value);
				if(Verify==true)
				{
					getLog().info("Search Record Found on Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					//event.printSnap("CRM-MakerGridPage "+tempCount);
					flag=true;
					break;
				}
				else
				{
					getLog().info("No Record Found of Page No "+tempCount);
					//LaunchBrowserConfig.WindowScrollHeight();
					event.printSnap("CRM MakerGridPage "+tempCount);
				}

			}		
		}
		return flag;

	}


	public void Logout() throws Exception {
		// TODO Auto-generated method stub
	
		while (retryCount < 5) {
		    try {
		        System.out.println("\n Logout Retry Attempt : " + retryCount);
		        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		     
		       wait.until(ExpectedConditions.visibilityOf(obj.ClickLogout)).click();
		        getLog().info("CRM-Logout Successfully");
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

			public void ClickOnVerifyButton() throws Exception
			{

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				//Assert.assertTrue(obj.AddButton.isDisplayed(),"AddButton Verification");
				wait.until(ExpectedConditions.elementToBeClickable(obj.ClickOnVerifyButton)).click();

				//obj.ClickOnVerifyButton.click();
				Assert.assertEquals(obj.OnClickViewLabel.getText(), "ePay Property File Configuration Checker","Label Verification");
				getLog().info("Checker Verification Process Started");
				event.printSnap("CRM-Verification Page");
			}

			public void CheckerSearchCriteria(String ParentMenu,String ChildMenu,String ApplicationName,String Description,String Key,String Value,
					String MakerRemarks,String Status,String CheckerRemarks,String Action) throws Exception
			{
				int count=0;

				for(WebElement ApplicationNameValue:obj.GetApplicationNameList)
				{
					count++;
					//System.out.println(ApplicationNameValue.getText());
					if(ApplicationNameValue.getText().equals(ApplicationName))
					{
						//System.out.println(ApplicationNameValue.getText());
						for(WebElement DescriptionValue:obj.GetDescriptionList)
						{
							if(DescriptionValue.getText().equals(Description))
							{
								//System.out.println(DescriptionValue.getText());
								for(WebElement KeyValues:obj.GetCheckerKeyList)
								{
									//System.out.println(KeyValues.getText());
									if(KeyValues.getText().equals(Key))
									{

										for(WebElement ListValues:obj.GetValueList)
										{
											//System.out.println("\n Values :"+ListValues.getText());

											if(ListValues.getText().equals(Value))
											{
												driver.findElement(By.xpath("//tbody/tr["+count+"]/td/input[1]")).click();
												if(obj.ApproveBtn.getAttribute("value").equals(Action))
												{
													//System.out.println("Enter-2");
													getLog().info("Action Taken : "+Action);
													obj.CheckerRemarks.sendKeys(CheckerRemarks);
													event.printSnap("CRM-CHeckerRecord-ActionToTaken");
													obj.ApproveBtn.click();
													Thread.sleep(3000);
													Assert.assertEquals(obj.ResponseMessage.getText(),"ePay Property File Configuration Verification Processed Successfully.","Checker Action- Verifcation");
													event.printSnap("CheckerActionTakenMsg");
													baseStep.SelectMainMenu(ParentMenu,ChildMenu);
													CheckerGrid(ApplicationName,Key,Value,Description,Status);
												}
												else if(obj.RejectBtn.getAttribute("value").equals(Action))
												{
													getLog().info("Action Taken : "+Action);
													obj.CheckerRemarks.sendKeys(CheckerRemarks);
													event.printSnap("CRM-CHeckerRecord-ActionToTake");
													obj.RejectBtn.click();
													//Thread.sleep(4000);
													wait=new WebDriverWait(driver,Duration.ofSeconds(20));
													WebElement respMsg=wait.until(ExpectedConditions.visibilityOf(obj.ResponseMessage));
													Assert.assertEquals(respMsg.getText(),"ePay Property File Configuration Verification Processed Successfully.","Checker Action- Verifcation");
													event.printSnap("CheckerActionTakenMsg");
													baseStep.SelectMainMenu(ParentMenu,ChildMenu);
													CheckerGrid(ApplicationName,Key,Value,Description,Status);
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
						break;
					}

					else
					{
						continue;
					}
				}

				getLog().info("Checker Verification Process Completed");
			}

			public void CheckerGrid(String applicationName, String key, String value, String Description, String status) throws Exception {
				// TODO Auto-generated method stub

				obj.EnterSearchValue.sendKeys(applicationName);
				event.printSnap("CRM CheckerGridSearch");

				getLog().info("Search Records Found " + driver.findElement(By.id("BBPSConfigData_info")).getText());
				int chk = 0;
				List<WebElement> pageList=driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));

				int tempCount=0;


				int consValue=0;

				int pageCounter=0;
				String countRecord=obj.CountOfRecords.getText();
				//System.out.println("\n Count : "+countRecord);
				String recSplit[]=countRecord.split(" ");


				String maxCount=recSplit[5];
				int totalRecords=Integer.parseInt((recSplit[5].toString().replace(",", "")));
				//System.out.println(maxCount);
				driver.findElements(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a"));
				for(WebElement pagNum:pageList)
				{
					pageCounter++;


				}

				//System.out.println("Last Page : "+pageCounter);
				//System.out.println("Total Page : "+totalRecords);


				for(int i=0;i<totalRecords;i++)
				{
					tempCount++;
					if(tempCount<5)
					{
						getLog().info("Search Process On Page No "+tempCount);


						try
						{
							driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
							boolean Verify=CheckerCriteria(applicationName,key,value,Description,status);
							if(Verify==true)
							{
								getLog().info("Search Record Found on Page No "+tempCount);
								//LaunchBrowserConfig.WindowScrollHeight();
								event.printSnap("CRM CheckerGridPage "+tempCount);
								break;
							}	
							else
							{
								getLog().info("No Record Found of Page No "+tempCount);
								//LaunchBrowserConfig.WindowScrollHeight();
								event.printSnap("CRM CheckerGridPage "+tempCount);
								consValue=5;
							}
						}
						catch(Exception e)
						{
							getLog().info("Page Not Available to check further");

							event.printSnap("Page Not Available to check further "+tempCount);
							break;
						}
					}
					else if(tempCount==5)
					{
						getLog().info("Search Process On Page No "+tempCount);
						event.printSnap("CRM CheckerGridPage "+tempCount);

						Thread.sleep(5000);
						if(consValue==5)
						{
							driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/span/a["+tempCount+"]")).click();
							boolean Verify=CheckerCriteria(applicationName,key,value,Description,status);
							if(Verify==true)
							{
								getLog().info("Search Record Found on Page No "+tempCount);
								//LaunchBrowserConfig.WindowScrollHeight();
								event.printSnap("CRM CheckerGridPage "+tempCount);
								break;
							}
							else
							{
								getLog().info("No Record Found of Page No "+tempCount);
								//LaunchBrowserConfig.WindowScrollHeight();
								event.printSnap("CRM CheckerGridPage "+tempCount);
								consValue=6;

								//break;
							}	
						}

					}

					else if(consValue>=6 && (tempCount>=6 && tempCount<=totalRecords))
					{
						getLog().info("Search Process On Page No. :"+tempCount);
						event.printSnap("CRM CheckerGridPage "+tempCount);
						Thread.sleep(5000);

						driver.findElement(By.xpath("//*[@id='BBPSConfigData_next']")).click();
						boolean Verify=CheckerCriteria(applicationName,key,value,Description,status);
						if(Verify==true)
						{
							getLog().info("Search Record Found on Page No "+tempCount);
							//LaunchBrowserConfig.WindowScrollHeight();
							event.printSnap("CRM CheckerGridPage "+tempCount);
							break;
						}
						else
						{
							getLog().info("No Record Found of Page No "+tempCount);
							//LaunchBrowserConfig.WindowScrollHeight();
							event.printSnap("CRM CheckerGridPage "+tempCount);
							try
							{
								driver.findElement(By.xpath("//div[@id='BBPSConfigData_paginate']/a[2][contains(@class,'disabled')]"));
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


			public boolean CheckerCriteria(String ApplicationName,String Key,String Value,String Description,String Status) throws Exception {

				int temp=0;
				int flagChk=0;
				boolean flag=false;
				int index=0;
				//System.out.println("Method Called");

				for(WebElement applNameValues:obj.getApplicationNameList)
				{
					//System.out.println(applNameValues.getText());
					temp++;
					if(applNameValues.getText().equals(ApplicationName))
					{
						//System.out.println("Application Name Value Matched ");
						for(WebElement keyValue:obj.getKeyList)
						{
							//System.out.println(keyValue.getText()+" : "+Key);
							index++;
							if(keyValue.getText().equals(Key))
							{
								//System.out.println("Key Value  Matched : "+keyValue.getText());

								for(WebElement valueList:obj.getValue)
								{

									//System.out.println(valueList.getText());
									if(valueList.getText().equals(Value))
									{
										//System.out.println("Value  Matched : "+valueList.getText()+" : "+index); 
										driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td[1]")).click();
										event.printSnap("CRM ToBeViewedRecordSelected");
										clickOnViewButton();

										clickOnBackButton();
										event.printSnap("Back to CheckerGrid");

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

		}
