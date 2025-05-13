package BundleUp.Bundle_Automation_Projects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
import ePay_CRM.Test_ActionMethods.Method_BillerConfigOnus;
import ePay_CRM.Test_ActionMethods.Method_EpayPropertyConfig;
import ePay_CRM.Test_ActionMethods.Method_SpRspCodeMapping;
import ePay_CRM.Test_DataDriven.TestData_ePayPropertyConfig;

public class TestCollection_CRM_BillerConfigOnus extends BasePageSetup{
	//@Test(priority=1,dataProvider="Add_Data",groups= {"SanityTest"} ,dataProviderClass=TestData_ePayPropertyConfig.class,enabled=true)

	boolean executionStatusFlag=false;
	@Test(priority=1,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void AddNewRecord(String ... testData) throws Exception 
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		Method_CRMBaseSteps step=CRMBaseStep();
		Method_BillerConfigOnus corestep=CRM_BillerConfigOnus_CoreStep();
		login.getUrl();
		login.EnterMakerUserName();
		login.EnterMakerUserPassword();
		login.clickOnLoginButton();
		Map<String, String> testFields = mapTestData(testData);
		
		step.SelectEnviornmentType(testFields.get("Environment")); 
		step.SelectMainMenu(testFields.get("ParentMenu"),testFields.get("ChildMenu"));
		corestep.FillInAddDetails(testFields.get("BillerId"),testFields.get("ServiceCode"),testFields.get("ServiceProviderName"),
				testFields.get("ServiceProviderCode"),testFields.get("ValidateAmountFlag"),
				testFields.get("FetchRequirment"),testFields.get("SubServiceProviderName"),testFields.get("SubServiceProviderCode"));

		boolean flag=corestep.clickOnSaveButton();
		int errCount = corestep.FieldError();
		
		System.out.println("\n Expected Pass :"+testFields.get("ExpectedExecutionStatus"));
		
		if(errCount==0 && flag==true)  
		{
			corestep.FillInAddStep2(testFields.get("Spfield1"),testFields.get("Spfield2"),testFields.get("Spfield3"),
					testFields.get("Spfield4"),testFields.get("Spfield5"),testFields.get("Spfield6"),testFields.get("Spfield7"),
					testFields.get("Spfield8"),testFields.get("Spfield9"),testFields.get("Spfield10"),testFields.get("selectQuickPayFlag"),
					testFields.get("selectValidationFlag"),testFields.get("SelectAmountFlag"),testFields.get("isMappedResponseCode"));
			boolean flag1=corestep.clickOnSaveButton();
			int errCount1 = corestep.FieldError();

			if(errCount1==0 && flag1==true)  
			{
				corestep.FillInAddStep3(testFields.get("DC_BillValidation_URL"),testFields.get("DR_BillValidation_URL"),
						testFields.get("DC_Bill_Fetch_URL"),testFields.get("DR_Bill_Fetch_URL"),
						testFields.get("DC_Bill_Payment_URL"),testFields.get("DR_Bill_Payment_URL"),testFields.get("DC_Operator_Validation_URL"),
						testFields.get("DR_Operator_Validation_URL"),testFields.get("DC_Operator_Service_URL"),
						testFields.get("DR_Operator_Service_URL"),testFields.get("DC_Operator_Status_URL"),testFields.get("DR_Operator_Status_URL"),testFields.get("DC_Bill_Status_Check_URL"),
						testFields.get("DR_Bill_Status_Check_URL"),testFields.get("DC_Operator_Token_URL"),testFields.get("DR_Operator_Token_URL"),testFields.get("DC_Operator_Balance_URL"),testFields.get("DR_Operator_Balance_URL"),
						testFields.get("DC_Operator_Username"),testFields.get("DR_Operator_Username"),testFields.get("DC_Operator_Password"),testFields.get("DR_Operator_Password"),testFields.get("DC_Operator_Token_Session"),
						testFields.get("DR_Operator_Token_Session"),testFields.get("DC_Connection_URL"),testFields.get("DR_Connection_URL"),testFields.get("DC_ProxyIp"),testFields.get("DR_ProxyIp"),testFields.get("DC_ProxyPort"),testFields.get("DR_ProxyPort"),
						testFields.get("DC_BillCancelURL"),testFields.get("DR_BillCancelURL"),testFields.get("DC_BillResendURL"),testFields.get("DR_BillResendURL"),testFields.get("DC_OprCancelURL"),testFields.get("DR_OprCancelURL"),
						testFields.get("DC_OprResendURL"),testFields.get("DR_OprResendURL"),testFields.get("DC_Status"),testFields.get("DR_Status"),testFields.get("DC_InActive"),testFields.get("DR_InActive"),testFields.get("DC_Is_WCF_Operator"),testFields.get("DR_Is_WCF_Operator"),
						testFields.get("Remarks"));
				
				boolean flag2=corestep.clickOnSaveButton();
				int errCount2 = corestep.FieldError();
				if(errCount2==0 && flag2==true)
				{
					corestep.Logout();
					login.EnterCheckerUserName();
					login.EnterCheckerUserPassword();
					login.clickOnLoginButton();	
					step.SelectEnviornmentType(testFields.get("Environment")); 
					step.SelectMainMenu(testFields.get("ParentMenu"),testFields.get("ChildMenu"));
					corestep.GoForCheckerProcess(testFields.get("BillerId"), testFields.get("ServiceCode"), testFields.get("ServiceProviderName"),testFields.get("ServiceProviderCode"), testFields.get("SubServiceProviderCode"),
							testFields.get("SubServiceProviderName"),testFields.get("Action") ,testFields.get("CheckerRemarks") ,testFields.get("SelectAmountFlag"),testFields.get("ValidateAmountFlag"),
							testFields.get("DC_Bill_Fetch_URL"),testFields.get("DC_Bill_Payment_URL"),testFields.get("DC_Bill_Status_Check_URL"),testFields.get("DC_BillValidation_URL"),testFields.get("ServiceCode"),
							testFields.get("DC_Operator_Balance_URL"),testFields.get("DC_Operator_Password"),testFields.get("DC_Operator_Service_URL"),testFields.get("DC_Operator_Status_URL"),
							testFields.get("DC_Operator_Token_Session"),testFields.get("DC_Operator_Token_URL"),testFields.get("DC_Operator_Username"),testFields.get("DC_Operator_Validation_URL"),testFields.get("DC_ProxyIp"),
							testFields.get("DC_ProxyPort"),testFields.get("DC_Is_WCF_Operator"),testFields.get("DC_BillCancelURL") ,testFields.get("DC_BillResendURL"),testFields.get("DC_Connection_URL"),
							testFields.get("DC_OprCancelURL"),testFields.get("DC_OprResendURL"),testFields.get("DR_Bill_Fetch_URL"),testFields.get("DR_Bill_Payment_URL"),testFields.get("DR_Bill_Status_Check_URL"),
							testFields.get("DR_BillValidation_URL"),testFields.get("DR_InActive"),testFields.get("DR_Operator_Balance_URL"),testFields.get("DR_Operator_Password"),testFields.get("DR_Operator_Service_URL"),
							testFields.get("DR_Operator_Status_URL"),testFields.get("DR_Operator_Token_Session"), testFields.get("DR_Operator_Token_URL"),testFields.get("DR_Operator_Username"),
							testFields.get("DR_Operator_Validation_URL"),testFields.get("DR_ProxyIp"),testFields.get("DR_ProxyPort"),testFields.get("DR_Is_WCF_Operator"),testFields.get("DR_BillCancelURL"),testFields.get("DR_BillResendURL"),
							testFields.get("DR_Connection_URL"),testFields.get("DR_OprCancelURL"),testFields.get("DR_OprResendURL"),testFields.get("FetchRequirment"),testFields.get("isMappedResponseCode"),
							testFields.get("selectQuickPayFlag"),testFields.get("Remarks"),testFields.get("Spfield1"),testFields.get("Spfield10"),testFields.get("Spfield2"),testFields.get("Spfield3"),testFields.get("Spfield4"),
							testFields.get("Spfield5"),testFields.get("Spfield6"),testFields.get("Spfield7"),testFields.get("Spfield8"),testFields.get("Spfield9"),testFields.get("selectValidationFlag"));
					executionStatusFlag=true;
					// Pass the structured array to executeTest()
				   // TestReader_ExcelData.executeTest(testData, executionStatusFlag);
				    
				    // Store execution status for output file
				   // TestReader_ExcelData.generateOutputFile(new String[][]{testData}, new boolean[]{executionStatusFlag}, "TestData");
				}				
			}	
		}  
	}	
	public static Map<String, String> mapTestData(String[] testData) {
        // Mapping column values dynamically for easier access
        Map<String, String> testMap = new HashMap<>();
        String[] columnNames = {"Environment",  "ParentMenu", "ChildMenu", "BillerId", "ServiceCode", "ServiceProviderName",
    			 "ServiceProviderCode","ValidateAmountFlag", "FetchRequirment", "SubServiceProviderName", "SubServiceProviderCode",
    			 "Spfield1", "Spfield2", "Spfield3", "Spfield4", "Spfield5", "Spfield6", "Spfield7",
    			 "Spfield8", "Spfield9", "Spfield10", "selectQuickPayFlag", "selectValidationFlag",
    			 "SelectAmountFlag", "isMappedResponseCode", "DC_BillValidation_URL", "DR_BillValidation_URL", "DC_Bill_Fetch_URL",
    			 "DR_Bill_Fetch_URL", "DC_Bill_Payment_URL", "DR_Bill_Payment_URL", "DC_Operator_Validation_URL", "DR_Operator_Validation_URL",
    			 "DC_Operator_Service_URL", "DR_Operator_Service_URL", "DC_Operator_Status_URL", "DR_Operator_Status_URL", "DC_Bill_Status_Check_URL",
    			 "DR_Bill_Status_Check_URL", "DC_Operator_Token_URL", "DR_Operator_Token_URL", "DC_Operator_Balance_URL", "DR_Operator_Balance_URL",
    			 "DC_Operator_Username","DR_Operator_Username", "DC_Operator_Password","DR_Operator_Password","DC_Operator_Token_Session",
    			 "DR_Operator_Token_Session", "DC_Connection_URL", "DR_Connection_URL", "DC_ProxyIp", "DR_ProxyIp", "DC_ProxyPort", "DR_ProxyPort",
    			 "DC_BillCancelURL", "DR_BillCancelURL", "DC_BillResendURL", "DR_BillResendURL", "DC_OprCancelURL", "DR_OprCancelURL", "DC_OprResendURL",
    			 "DR_OprResendURL", "DC_Status", "DR_Status","DC_InActive", "DR_InActive", "DC_Is_WCF_Operator",
    			 "DR_Is_WCF_Operator", "Remarks", "Action", "CheckerRemarks","ExpectedExecutionStatus"};
        for (int i = 0; i < columnNames.length && i < testData.length; i++) {
            testMap.put(columnNames[i], testData[i]);
        }
        return testMap;
    }	
	
	}

