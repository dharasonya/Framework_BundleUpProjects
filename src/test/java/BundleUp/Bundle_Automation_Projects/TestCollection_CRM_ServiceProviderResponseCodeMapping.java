	package BundleUp.Bundle_Automation_Projects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
			
			else if(errCount==0 && flag==false)
			{
				getLog().info("On Save : "+corestep.MakerCaptureMsg().toString());
			}
			
		
		}	  
	}
}
	

/*

	

 */
