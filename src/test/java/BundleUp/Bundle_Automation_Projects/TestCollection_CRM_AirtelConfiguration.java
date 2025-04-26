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
import ePay_CRM.Test_ActionMethods.Method_AirtelConfiguration;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;

  
 
public class TestCollection_CRM_AirtelConfiguration extends BasePageSetup{

	//@Test(priority=1,dataProvider="Add_Data",groups= {"SanityTest"} ,dataProviderClass=TestData_ePayPropertyConfig.class,enabled=true)
	@Test(priority=1,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void AddNewRecord(String Environment,String ParentMenu,String ChildMenu,String DataCentre,String DebitAccount,String SourceOrigin,
			String UserName,String ServiceUrl,String MakerRemark,
			String StatusUrl,String Action,String CheckerRemarks) throws Exception 
		{
			Method_LoginWithCredentials login=GetLoginCredentials();
			Method_CRMBaseSteps step=CRMBaseStep();
			Method_AirtelConfiguration corestep=CRM_AirtelConfiguration_CoreStep();
			login.getUrl();
			login.EnterMakerUserName();
			login.EnterMakerUserPassword();
			login.clickOnLoginButton();
			step.SelectEnviornmentType(Environment); 
			step.SelectMainMenu(ParentMenu,ChildMenu);
			corestep.clickOnEditButton(DataCentre);
			corestep.UpdateEditDetails(DataCentre,DebitAccount,SourceOrigin,UserName,ServiceUrl,MakerRemark,StatusUrl);
			boolean flag=corestep.clickOnUpdateButton();
			int errCount = corestep.FieldError(DataCentre,DebitAccount,SourceOrigin,UserName,ServiceUrl,MakerRemark,StatusUrl);
			
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
				corestep.GoForCheckerProcess(DataCentre,DebitAccount,SourceOrigin,UserName,ServiceUrl,MakerRemark,StatusUrl,Action,CheckerRemarks) ;
			}
			
			else if(errCount==0 && flag==false)
			{
				getLog().info("On Save : "+corestep.MakerCaptureMsg().toString());
			}
			
		
		}

	@Test(priority=2,enabled=true)
	public void Verify_BAL_Wallets_Switch() throws Exception
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_AirtelConfiguration corestep=CRM_AirtelConfiguration_CoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();
		step.SelectEnviornmentType("ConWallet"); 
		step.SelectMainMenu("Operator","Airtel DataCentre Migration");
		corestep.switchBalWallets();
		//corestep.Logout();
		
		
	}

}

/*

	

 */
