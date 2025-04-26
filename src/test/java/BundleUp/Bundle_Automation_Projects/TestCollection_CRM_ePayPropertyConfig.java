	package BundleUp.Bundle_Automation_Projects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.LoginProcess.Method_LoginWithCredentials;
import ePay_CRM.Reusable_Utils.RetryHandling;
import ePay_CRM.Reusable_Utils.TestReader_ExcelData;
import ePay_CRM.Test_ActionMethods.Method_EpayPropertyConfig;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;

  
 
public class TestCollection_CRM_ePayPropertyConfig extends BasePageSetup{

	//@Test(priority=1,dataProvider="Add_Data",groups= {"SanityTest"} ,dataProviderClass=TestData_ePayPropertyConfig.class,enabled=true)
	@Test(priority=1,dataProvider="ExcelDataProvider",groups={"SanityTest"},dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void AddNewRecord(String Environment,String ParentMenu,String ChildMenu,String ApplicationName,String Key,String Value,String Status,String Description,String Remarks,String Action,String CheckerRemarks) throws Exception {  
		{
			Method_LoginWithCredentials login=GetLoginCredentials();
			Method_CRMBaseSteps step=CRMBaseStep();
			Method_EpayPropertyConfig corestep=CRMCoreStep();
			login.getUrl();
			login.EnterMakerUserName();
			login.EnterMakerUserPassword();
			login.clickOnLoginButton();

			step.SelectEnviornmentType(Environment); 
			step.SelectMainMenu(ParentMenu,ChildMenu);
			corestep.ClickOnAddButton();
			corestep.FillInAddDetails(ApplicationName,Key,Value,Status,Description,Remarks);
			boolean flag=corestep.clickOnSaveButton();
			int errCount = corestep.FieldError();
			if(errCount==0 && flag==true)
			{
				String MakerStatusMsg=corestep.MakerCaptureMsg();
				getLog().info("Maker Status Message :-"+MakerStatusMsg);
				corestep.Logout();
				login.EnterCheckerUserName();
				login.EnterCheckerUserPassword();
				login.clickOnLoginButton();	
				step.SelectEnviornmentType(Environment); 
				step.SelectMainMenu(ParentMenu,ChildMenu);
				corestep.ClickOnVerifyButton();
				corestep.CheckerSearchCriteria(ParentMenu,ChildMenu,ApplicationName,Description,Key,Value,Remarks,Status,CheckerRemarks,Action);
			}
			else if(errCount==0 && flag==false)
			{
				getLog().info("On Save : "+corestep.MakerCaptureMsg().toString());
			}
		}	  
	}
	
	//@Test(priority=2,dataProvider="ExcelDataProvider",groups={"NegativeTest"},dataProviderClass=TestReader_ExcelData.class,enabled=true)
	
	@Test(priority=2,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)
	public void ResetRecord(String Environment,String ParentMenu,String ChildMenu,String ApplicationName,String Key,String Value,String Status,String Description,String Remarks) throws Exception
	{

		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_EpayPropertyConfig corestep=CRMCoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();  
		step.SelectEnviornmentType(Environment);
		step.SelectMainMenu(ParentMenu,ChildMenu);
		corestep.ClickOnAddButton();
		corestep.FillInAddDetails(ApplicationName,Key,Value,Status,Description,Remarks);
		corestep.clickOnResetButton();
	}

	@Test(priority=3,groups={"NegativeTest"},enabled=true) ///Working
	public void GoBack() throws Exception
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_EpayPropertyConfig corestep=CRMCoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();  
		step.SelectEnviornmentType("BBPS2.0");
		step.SelectMainMenu("BBPS2.0","ePay Property File Configuration");
		corestep.ClickOnAddButton();
		corestep.clickOnBackButton();
	} 

	@Test(priority=4,dataProvider="ExcelDataProvider",groups={"NegativeTest"},dataProviderClass=TestReader_ExcelData.class,enabled=true)
	public void SearchRecords(String Environment,String ParentMenu,String ChildMenu,String SearchCriteria,String ApplicationName,String Key,String Value,String Description,String Status) throws Exception
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_EpayPropertyConfig corestep=CRMCoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();  
		step.SelectEnviornmentType(Environment);
		step.SelectMainMenu(ParentMenu,ChildMenu);
		corestep.EnterSearchValue(SearchCriteria);
		boolean chk=corestep.ViewMatchedCriteria(ApplicationName,Key,Value,Description,Status);
		
		if(chk)
		{
			corestep.clickOnViewButton();
			corestep.ViewRecords(ApplicationName,Key,Value,Description,Status);
		}  
		
	}
	
	@Test(priority=5,groups={"NegativeTest"},enabled=false,retryAnalyzer=RetryHandling.class)
	public void ViewAllRecords() throws Exception
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_EpayPropertyConfig corestep=CRMCoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();  
		step.SelectEnviornmentType("BBPS2.0");
		step.SelectMainMenu("BBPS2.0","ePay Property File Configuration");
		corestep.ViewAllRecords();
	}  

	@Test(priority=6,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true,retryAnalyzer=RetryHandling.class)
	public void EditRecords(String Enviornment,String ParentMenu,String ChildMenu,String SearchCriteria,String ApplicationName,String Key,String Value,String Status,String Description,String Remarks,
			String NewValue,String NewDescription,String NewStatus,String CheckerRemarks,String Action) throws Exception///Working
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_EpayPropertyConfig corestep=CRMCoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();  
		step.SelectEnviornmentType(Enviornment);
		step.SelectMainMenu(ParentMenu,ChildMenu);
		corestep.EnterSearchValue(SearchCriteria);
		//call.EnterSearchCriteria(ApplicationName,Key,Value);
		boolean flag=corestep.CheckMatchedCriteria(ApplicationName,Key,Value,Status,Description,Remarks,
				NewValue,NewDescription,NewStatus);
		//=call.clickOnUpdateButton();
		//System.out.println("Check flag : -"+call.clickOnUpdateButton());

		//errCount = call.FieldError(); 
		//flag==true && 
		if(flag==true)
		{
			//String MakerStatusMsg=call.MakerCaptureMsg();
			//LaunchBrowserConfig.getLog().info("Maker Status :"+MakerStatusMsg);
			//Thread.sleep(3000);
			corestep.Logout();
			login.EnterCheckerUserName();
			login.EnterCheckerUserPassword();
			login.clickOnLoginButton();
			step.SelectEnviornmentType(Enviornment);
			step.SelectMainMenu(ParentMenu,ChildMenu);
			corestep.ClickOnVerifyButton();
			corestep.CheckerSearchCriteria(ParentMenu,ChildMenu,ApplicationName,NewDescription,Key,NewValue,Remarks,NewStatus,Action,CheckerRemarks);
			//break;
			
		}
		/*else 
		{
			LaunchBrowserConfig.getLog().info("On Save : "+call.MakerCaptureMsg().toString());
			
		}*/
	}

}


/*

	

 */
