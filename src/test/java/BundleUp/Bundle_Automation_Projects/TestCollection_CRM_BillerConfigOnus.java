	package BundleUp.Bundle_Automation_Projects;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.LoginProcess.Method_LoginWithCredentials;
import ePay_CRM.Reusable_Utils.RetryHandling;
import ePay_CRM.Reusable_Utils.TestReader_ExcelData;
import ePay_CRM.Test_ActionMethods.Method_BillerConfigOnus;
import ePay_CRM.Test_ActionMethods.Method_EpayPropertyConfig;
import ePay_CRM.Test_ActionMethods.Method_SpRspCodeMapping;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;

  

public class TestCollection_CRM_BillerConfigOnus extends BasePageSetup{
	//@Test(priority=1,dataProvider="Add_Data",groups= {"SanityTest"} ,dataProviderClass=TestData_ePayPropertyConfig.class,enabled=true)
	@Test(priority=1,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void AddNewRecord(String Environment, String ParentMenu,String ChildMenu,String BillerId,String ServiceCode,String ServiceProviderName,
			String ServiceProviderCode,String ValidateAmountFlag,String FetchRequirment,String SubServiceProviderName,String SubServiceProviderCode,
			String Spfield1,String Spfield2,String Spfield3,String Spfield4,String Spfield5,String Spfield6,String Spfield7,
			String Spfield8,String Spfield9,String Spfield10,String selectQuickPayFlag,String selectValidationFlag,
			String SelectAmountFlag,String isMappedResponseCode,String DC_BillValidation_URL,String DR_BillValidation_URL,String DC_Bill_Fetch_URL,
			String DR_Bill_Fetch_URL,String DC_Bill_Payment_URL,String DR_Bill_Payment_URL,String DC_Operator_Validation_URL,String DR_Operator_Validation_URL,
			String DC_Operator_Service_URL,String DR_Operator_Service_URL,String DC_Operator_Status_URL,String DR_Operator_Status_URL,String DC_Bill_Status_Check_URL,
			String DR_Bill_Status_Check_URL,String DC_Operator_Token_URL,String DR_Operator_Token_URL,String DC_Operator_Balance_URL,String DR_Operator_Balance_URL,String DC_Operator_Username,
			String DR_Operator_Username,String DC_Operator_Password,String DR_Operator_Password,String DC_Operator_Token_Session,
			String DR_Operator_Token_Session,String DC_Connection_URL,String DR_Connection_URL,String DC_ProxyIp,String DR_ProxyIp,String DC_ProxyPort,String DR_ProxyPort,
			String DC_BillCancelURL,String DR_BillCancelURL,String DC_BillResendURL,String DR_BillResendURL,String DC_OprCancelURL,String DR_OprCancelURL,String DC_OprResendURL,
			String DR_OprResendURL,String DC_Status,String DR_Status,
			String DC_InActive,String DR_InActive,String DC_Is_WCF_Operator,
			String DR_Is_WCF_Operator,String Remarks,String Action,String CheckerRemarks) throws Exception 
		{
			Method_LoginWithCredentials login=GetLoginCredentials();
			Method_CRMBaseSteps step=CRMBaseStep();
			Method_BillerConfigOnus corestep=CRM_BillerConfigOnus_CoreStep();
			login.getUrl();
			login.EnterMakerUserName();
			login.EnterMakerUserPassword();
			login.clickOnLoginButton();

			step.SelectEnviornmentType(Environment); 
			step.SelectMainMenu(ParentMenu,ChildMenu);
			corestep.FillInAddDetails(BillerId,ServiceCode,ServiceProviderName,ServiceProviderCode,ValidateAmountFlag,
					FetchRequirment,SubServiceProviderName,SubServiceProviderCode);
			
			boolean flag=corestep.clickOnSaveButton();
			int errCount = corestep.FieldError();
			
			///System.out.println("\n Flag : "+flag+" - errcount : "+errCount);
			if(errCount==0 && flag==true)  
			{
				corestep.FillInAddStep2(Spfield1,Spfield2,Spfield3,Spfield4,Spfield5,Spfield6,Spfield7,Spfield8,Spfield9,Spfield10,selectQuickPayFlag,selectValidationFlag,SelectAmountFlag,isMappedResponseCode);
				boolean flag1=corestep.clickOnSaveButton();
				int errCount1 = corestep.FieldError();
				
				if(errCount1==0 && flag1==true)  
				{
					corestep.FillInAddStep3(DC_BillValidation_URL,DR_BillValidation_URL,DC_Bill_Fetch_URL,DR_Bill_Fetch_URL,
							DC_Bill_Payment_URL,DR_Bill_Payment_URL,DC_Operator_Validation_URL,DR_Operator_Validation_URL,
							DC_Operator_Service_URL,DR_Operator_Service_URL,DC_Operator_Status_URL,DR_Operator_Status_URL,DC_Bill_Status_Check_URL,
							DR_Bill_Status_Check_URL,DC_Operator_Token_URL,DR_Operator_Token_URL,DC_Operator_Balance_URL,DR_Operator_Balance_URL,
							DC_Operator_Username,DR_Operator_Username,DC_Operator_Password,DR_Operator_Password,DC_Operator_Token_Session,
							DR_Operator_Token_Session,DC_Connection_URL,DR_Connection_URL,DC_ProxyIp,DR_ProxyIp,DC_ProxyPort,DR_ProxyPort,
							DC_BillCancelURL,DR_BillCancelURL,DC_BillResendURL,DR_BillResendURL,DC_OprCancelURL,DR_OprCancelURL,
							DC_OprResendURL,DR_OprResendURL,DC_Status,DR_Status,DC_InActive,DR_InActive,DC_Is_WCF_Operator,DR_Is_WCF_Operator,
							Remarks);
					boolean flag2=corestep.clickOnSaveButton();
					int errCount2 = corestep.FieldError();
					
				//	System.out.println("\n error count 2 : "+errCount2+" - flag2 : "+flag2);
					if(errCount2==0 && flag2==true)
					{
							corestep.Logout();
							login.EnterCheckerUserName();
							login.EnterCheckerUserPassword();
							login.clickOnLoginButton();	
							step.SelectEnviornmentType(Environment); 
							step.SelectMainMenu(ParentMenu,ChildMenu);
							corestep.GoForCheckerProcess(BillerId, ServiceCode, ServiceProviderName,ServiceProviderCode, SubServiceProviderCode,
								SubServiceProviderName, Action, CheckerRemarks,SelectAmountFlag,ValidateAmountFlag,
								DC_Bill_Fetch_URL,DC_Bill_Payment_URL,DC_Bill_Status_Check_URL,DC_BillValidation_URL,DC_InActive,
								DC_Operator_Balance_URL,DC_Operator_Password,DC_Operator_Service_URL,DC_Operator_Status_URL,
								DC_Operator_Token_Session,DC_Operator_Token_URL,DC_Operator_Username,DC_Operator_Validation_URL,DC_ProxyIp,
								DC_ProxyPort,DC_Is_WCF_Operator, DC_BillCancelURL,DC_BillResendURL,DC_Connection_URL,
								DC_OprCancelURL,DC_OprResendURL,DR_Bill_Fetch_URL,DR_Bill_Payment_URL,DR_Bill_Status_Check_URL,
								DR_BillValidation_URL,DR_InActive,DR_Operator_Balance_URL,DR_Operator_Password,DR_Operator_Service_URL,
								DR_Operator_Status_URL,DR_Operator_Token_Session, DR_Operator_Token_URL,DR_Operator_Username,
								DR_Operator_Validation_URL,DR_ProxyIp,DR_ProxyPort,DR_Is_WCF_Operator,DR_BillCancelURL,DR_BillResendURL,
								DR_Connection_URL,DR_OprCancelURL,DR_OprResendURL,FetchRequirment,isMappedResponseCode,
								selectQuickPayFlag,Remarks,Spfield1,Spfield10,Spfield2,Spfield3,Spfield4,
								Spfield5,Spfield6,Spfield7,Spfield8,Spfield9,selectValidationFlag);
					}				
				//*/
				}	
			}  
			
			/*else if(errCount==0 && flag==false)
			{
				getLog().info("On Save : "+corestep.MakerCaptureMsg().toString());
			}
			*/
		
		}	  
	
	
}

/*

	

 */
