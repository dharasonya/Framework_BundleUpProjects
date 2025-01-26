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
import ePay_CRM.Test_ActionMethods.Method_SpRspCodeMapping;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;

  
 
public class TestCollection_CRM_ServiceProviderResponseCodeMapping extends BasePageSetup{

	//@Test(priority=1,dataProvider="Add_Data",groups= {"SanityTest"} ,dataProviderClass=TestData_ePayPropertyConfig.class,enabled=true)
	@Test(priority=1,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void AddNewRecord(String Environment,String ParentMenu,String ChildMenu,String NetworkMode,String ServiceProvider,String ServiceProviderResponseCode,String EuronetResponseCode,String ResponseAction,String ServiceProviderResponseMessage,String Status,String MakerRemark,String Action,String CheckerRemarks) throws Exception {  
		{
			Method_LoginWithCredentials login=GetLoginCredentials();
			Method_CRMBaseSteps step=CRMBaseStep();
			Method_SpRspCodeMapping corestep=CRM_SpRspCodeMapping_CoreStep();
			login.getUrl();
			login.EnterMakerUserName();
			login.EnterMakerUserPassword();
			login.clickOnLoginButton();

			step.SelectEnviornmentType(Environment); 
			step.SelectMainMenu(ParentMenu,ChildMenu);
			corestep.ClickOnAddButton();
			corestep.FillInAddDetails(NetworkMode,ServiceProvider,ServiceProviderResponseCode,EuronetResponseCode,ResponseAction,ServiceProviderResponseMessage,Status,MakerRemark);
			boolean flag=corestep.clickOnSaveButton();
			int errCount = corestep.FieldError();
			
			//System.out.println("\n Flag : "+flag+" - errcount : "+errCount);
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
				corestep.GoForCheckerProcess(ParentMenu,ChildMenu,ServiceProvider,ServiceProviderResponseCode,EuronetResponseCode,Action,CheckerRemarks) ;
			}
			
			/*else 
			{
				getLog().info("On Save : "+corestep.MakerCaptureMsg().toString());
			}*/
		}	  
	}
	
	


	//@Test(priority=4,dataProvider="ExcelDataProvider",groups={"NegativeTest"},dataProviderClass=TestReader_ExcelData.class,enabled=false)
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
	
	//@Test(priority=6,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=falseē,retryAnalyzer=RetryHandling.class)
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
