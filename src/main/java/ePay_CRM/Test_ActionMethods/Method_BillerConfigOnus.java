package ePay_CRM.Test_ActionMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.ScrollHandler;
import ePay_CRM.Reusable_Utils.WaitUtils;
import ePay_CRM.Test_PageObjects.Repo_BillerConfig_Onus;
import ePay_CRM.WrapMethods.WrapperMethods;
import javafx.util.Pair;
import ePay_CRM.Reusable_Utils.CommonLogger;

public class Method_BillerConfigOnus extends BasePageSetup{

	Repo_BillerConfig_Onus obj;
	WebDriver driver;
	int count=0;
	int errCount=0;
	Method_CRMBaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();
	WaitUtils wait;
	int counter=0;
	ScrollHandler scroll;
	WrapperMethods action;
	//CommonLogger commonLogger=new CommonLogger();
	static Logger logger = Logger.getLogger("Method_BillerConfigOnus");

	public Method_BillerConfigOnus(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_BillerConfig_Onus(driver);	
		baseStep=new Method_CRMBaseSteps(driver);
		wait=new WaitUtils(driver);
		scroll=new ScrollHandler(driver);
		action=new WrapperMethods(driver);

	}

	public void FillInAddDetails(String BillerId, String ServiceCode, String ServiceProviderName, String ServiceProviderCode, String ValidateAmountFlag,
			String FetchRequirement, String SubServiceProviderName, String SubServiceProviderCode) throws Exception {

		CommonLogger.log("Initiated the process of filling in details on Page 1.");
		action.enterAndVerify(obj.EnterBillerId, BillerId, "Biller-ID");
		action.enterAndSelectServiceCode(obj.EnterServiceCode,obj.SelectServiceCode,ServiceCode,"Service Code");
		action.enterAndVerify(obj.EnterServiceProviderName, ServiceProviderName, "Service Provider Name");
		action.enterAndVerify(obj.EnterServiceProviderCode, ServiceProviderCode, "Service Provider Code");
		action.selectValueAndVerify(obj.SelectValidateAmountFlag, ValidateAmountFlag, "Validation Amount Flag");
		action.selectValueAndVerify(obj.SelectFetchRequirement, FetchRequirement.toUpperCase(), "Fetch Requirement Flag");
		action.enterAndVerify(obj.EnterSubServiceProviderName, SubServiceProviderName, "Sub Service Provider Name");
		action.enterAndVerify(obj.EnterSubServiceProviderCode, SubServiceProviderCode, "Sub Service Provider Code");
		event.printSnap("CRM STEP 1 Details Added");
		CommonLogger.log("Completed the process of filling in details on Page 1.");
	}

	public void FillInAddStep2(String Spfield1,String Spfield2,String Spfield3,String Spfield4,String Spfield5,String Spfield6,String Spfield7,
			String Spfield8,String Spfield9,String Spfield10,String selectQuickPayFlag,String selectValidationFlag,
			String SelectAmountFlag,String isMappedResponseCode)
	{  
		Assert.assertEquals(wait.waitForElementToBeVisible(obj.StepPage2, 10).getText(),"STEP 2 - Service Provider Services Details");
		CommonLogger.log("Initiated the process of filling in details on Page 2.");
		action.enterAndVerify(obj.EnterSPField1, Spfield1, "Spfield1");
		action.enterAndVerify(obj.EnterSPField2, Spfield2, "Spfield2");
		action.enterAndVerify(obj.EnterSPField3, Spfield3, "Spfield3");
		action.enterAndVerify(obj.EnterSPField4, Spfield4, "Spfield4");
		action.enterAndVerify(obj.EnterSPField5, Spfield5, "Spfield5");
		action.enterAndVerify(obj.EnterSPField6, Spfield6, "Spfield6");
		action.enterAndVerify(obj.EnterSPField7, Spfield7, "Spfield7");
		action.enterAndVerify(obj.EnterSPField8, Spfield8, "Spfield8");
		action.enterAndVerify(obj.EnterSPField9, Spfield9, "Spfield9");
		action.enterAndVerify(obj.EnterSPField10, Spfield10, "Spfield10");
		action.clickOnCheckboxAndVerify(obj.ChooseQuickPay, selectQuickPayFlag,"ChooseQuickPay");
		action.clickOnCheckboxAndVerify(obj.ChooseStep2ValidationFlag, selectValidationFlag,"ValidationFlag");
		action.selectActiveFlagAndVerify(obj.ChooseAmountFlag,SelectAmountFlag,"AmountFlag");
		action.selectActiveFlagAndVerify(obj.ChooseIsMappedResCode,isMappedResponseCode,"isMappedResponseCode");
		event.printSnap("CRM STEP 2 Details Added");
		CommonLogger.log("Completed the process of filling in details on Page 2.");
	}

	public boolean clickOnSaveButton() throws Exception {
		// TODO Auto-generated method stub

		String onSaveNewExpMsg1="Record Successfully Added for STEP - 1";
		String onSaveNewExpMsg2="Record Successfully Added for STEP - 2";
		String onSaveNewExpMsg3="Record Successfully Added for STEP - 3 and sent for Checker Approval";
		String onSaveDupExpMsg="Service Provider Response Code already exists.";
		String onSuccessMsg = null;
		boolean flag=false;
		boolean saveFlag=false;


		List<String> stepList=new ArrayList<String>();
		stepList.add("STEP 1 - Service Details");
		stepList.add("STEP 2 - Service Provider Services Details");
		stepList.add("STEP 3 - Operator URL Configuration");

		for (String stepValues : stepList) {
			String stepValueBreak[] = stepValues.split(" - ");

			for (int i = 0; i < stepValueBreak.length; i++) {
				if (i == 0) {

					if(obj.StepPage1.getText().contains(stepValueBreak[i]))
					{
						if(obj.StepPage1.getText().equals("STEP 1 - Service Details"))
						{
							action.clickOnButtonAndVerify(obj.ClickOnSave1, "ClickOnSave1");
							try
							{
								onSuccessMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg1, "verifyOnSaveSuccessMsg1");
							}
							catch(Exception e)
							{
								CommonLogger.log("Runtime exception occurred while locating Step 1 - Success Message.");
							}
						}
					}
					else  if(obj.StepPage2.getText().contains(stepValueBreak[i]))
					{
						if(obj.StepPage2.getText().equals("STEP 2 - Service Provider Services Details"))	
						{
							action.clickOnButtonAndVerify(obj.ClickOnSave2, "ClickOnSave2");
							onSuccessMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg2, "verifyOnSaveSuccessMsg2");
						}
					}
					else if(obj.StepPage3.getText().contains(stepValueBreak[i]))
					{
						/*if(obj.StepPage3.getText().equals("STEP 3 - Operator URL Configuration"))
						{
							action.clickOnButtonAndVerify(obj.ClickOnSave3, "ClickOnSave3");
							onSuccessMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg3, "verifyOnSaveSuccessMsg3");
						}*/ // ----Under constrution.

						
							action.clickOnButtonAndVerify(obj.ClickOnSave3, "ClickOnSave3");
							try
							{
								onSuccessMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg3, "verifyOnSaveSuccessMsg3");
							}
							catch(Exception e)
							{
								CommonLogger.log("Runtime exception occurred while locating Step 3 - Success Message.");
							}
						
					}

				}
			}
		}
		try
		{
			if(onSaveNewExpMsg1.equals(onSuccessMsg))
			{
				Assert.assertTrue(onSaveNewExpMsg1.equals(onSuccessMsg),"On Save Sucess Msg Verifcation");
				flag=true;
				event.printSnap("CRM STEP 1 Record Successfully Added for STEP");

			}
			else if(onSaveNewExpMsg2.equals(onSuccessMsg))
			{
				Assert.assertTrue(onSaveNewExpMsg2.equals(onSuccessMsg),"On Save Sucess Msg Verifcation");
				flag=true;
				event.printSnap("CRM STEP 2 Record Successfully Added for STEP");
			}
			else if(onSaveNewExpMsg3.equals(onSuccessMsg))
			{
				Assert.assertTrue(onSaveNewExpMsg3.equals(onSuccessMsg),"On Save Sucess Msg Verifcation");
				flag=true;
			}
			else if(onSaveDupExpMsg.equals(onSuccessMsg))
			{
				Assert.assertTrue(onSaveDupExpMsg.equals(onSuccessMsg),"On Duplicate Save Sucess Msg Verifcation");
				event.printSnap("CRM Save Duplicate Msg");
			}
		}
		catch(Exception e)
		{
			CommonLogger.log("Unable to Save Records due to error occured"+e.getMessage());
		}
		return flag;
	}

	public int FieldError() throws Exception
	{
		SoftAssert softAssert=new SoftAssert();
		String onSaveMsg = null;
		boolean errorLogged = false; // Track if error logging has happened
		boolean errorFlag=false;

		errCount=0;	
		List<String> stepList=new ArrayList<String>();
		stepList.add("STEP 1 - Service Details");
		stepList.add("STEP 2 - Service Provider Services Details");
		stepList.add("STEP 3 - Operator URL Configuration");

		try {
			for (String stepValues : stepList) {
				String stepValueBreak[] = stepValues.split(" - ");

				for (int i = 0; i < stepValueBreak.length; i++) {
					if (i == 0) {
						if (obj.StepPage1.getText().contains(stepValueBreak[i])) {
							if (obj.StepPage1.getText().equals("STEP 1 - Service Details")) {

								/// working -in progress- to handle failure cases.
								try {
									onSaveMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg1, "StepPage1");
								} catch (Exception e) {
									CommonLogger.log("Runtime Exception occurred while retrieving StepPage1 success message: " + e.getMessage());
									onSaveMsg = action.getTextAndVerify(obj.getOnSaveErrorMsg, "StepPage1");
								}
								if (!onSaveMsg.equals("Record Successfully Added for STEP - 1") &&
										action.getTextAndVerify(obj.StepPage1, "StepPage1").contains("STEP 1")) {
									errCount++;
									validatePageFieldError_OnStep1(onSaveMsg);
									CommonLogger.log("Error Messages: " + errCount + " - " + onSaveMsg);
									event.printSnap("On Step Maker Screen ErrorMsg " + errCount);
									errorLogged = true;
								}
							}
						} else if (obj.StepPage2.getText().contains(stepValueBreak[i])) {
							if (obj.StepPage2.getText().equals("STEP 2 - Service Provider Services Details")) {
								onSaveMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg2, "StepPage2");

								if (!onSaveMsg.equals("Record Successfully Added for STEP - 2") &&
										action.getTextAndVerify(obj.StepPage2, "StepPage2").contains("STEP 2")) {
									errCount++;
									CommonLogger.log("Error Messages: " + errCount + " - " + onSaveMsg);
									event.printSnap("On Step Maker Screen ErrorMsg " + errCount);
									errorLogged = true;
								}
							}
						} else if (obj.StepPage3.getText().contains(stepValueBreak[i])) {
							try {
								onSaveMsg = action.getTextAndVerify(obj.verifyOnSaveSuccessMsg3, "StepPage3");
							} catch (Exception e) {
								CommonLogger.log("Runtime Exception occurred while retrieving StepPage3 success message: " + e.getMessage());
								onSaveMsg = action.getTextAndVerify(obj.getOnSaveErrorMsg, "StepPage3");
							}
							if (!onSaveMsg.equals("Record Successfully Added for STEP - 3 and sent for Checker Approval") &&
									action.getTextAndVerify(obj.StepPage3, "StepPage3").contains("STEP 3")) {
								errCount++;
								validatePageFieldError_OnStep3(onSaveMsg);
								CommonLogger.log("Error Messages: " + errCount + " - " + onSaveMsg);
								event.printSnap("On Step Maker Screen ErrorMsg " + errCount);
								errorLogged = true;
							}
						}
					}
				}
			}
			if (!errorLogged) {
				CommonLogger.log("Any Error Messages on Save/Update : " + errCount);
			}
		} catch (Exception e) {
			CommonLogger.errorLog(e);
		}
		softAssert.assertAll();
		if(errCount==0)
		{
			counter++;
			action.clickOnButtonAndVerify(obj.clickOnClose_SuccessModal, "clickOnClose_SuccessModal");
			//Thread.sleep(3000);
			wait.waitForInvisibility(obj.clickOnClose_SuccessModal,5);
			event.printSnap("On Success Modal Dialog Closed on Step "+counter);
		}
		else
		{
			counter++;
			try
			{
				action.clickOnButtonAndVerify(obj.clickOnClose_ErrorModal, "clickOnClose_ErrorModal");
				//Thread.sleep(3000);
				wait.waitForInvisibility(obj.clickOnClose_ErrorModal,5);
				event.printSnap("On Error Modal Dialog Closed on Step "+counter);
			}
			catch(Exception e)
			{
				action.clickOnButtonAndVerify(obj.clickonCheckerErrorModal, "clickonCheckerErrorModal");
				//Thread.sleep(3000);
				wait.waitForInvisibility(obj.clickonCheckerErrorModal,5);
				event.printSnap("On Checker Error Modal Dialog Closed on Step "+counter);
			}
		}
		CommonLogger.log("Step, Modal Dialog got Closed");

		return errCount;
	}
	
	private void validatePageFieldError_OnStep1(String onSaveMsg)
	{
		// Define a map for field elements and their corresponding validation messages
		
		 Map<WebElement, Pair<String, List<String>>> fieldValidationMap = new LinkedHashMap<>();
		 fieldValidationMap.put(obj.EnterBillerId, new Pair<>("Biller_Id",Arrays.asList("Please enter Biller Id")));
		 fieldValidationMap.put(obj.EnterServiceCode, new Pair<>("ServiceCode",Arrays.asList("Please enter Service Code")));
		 fieldValidationMap.put(obj.EnterServiceProviderName, new Pair<>("ServiceProviderName",Arrays.asList("Please enter Service Provider Name")));
		 fieldValidationMap.put(obj.EnterSubServiceProviderName, new Pair<>("SubServiceProviderName",Arrays.asList("Please enter SubService Provider Name")));
		 fieldValidationMap.put(obj.EnterSubServiceProviderCode, new Pair<>("SubServiceCode",Arrays.asList("Please enter SubService Provider Code")));
		 
		    for (Map.Entry<WebElement, Pair<String, List<String>>> entry : fieldValidationMap.entrySet())        
		    {
		    	 	WebElement field = entry.getKey();
			        String fieldName = entry.getValue().getKey();
			        List<String> validationMessages = entry.getValue().getValue();
			       
		        if (action.getAttributeValue(field, "value",fieldName).equals("")) {
		            boolean matchFound = validationMessages.contains(onSaveMsg);
		            Assert.assertTrue(matchFound, "Verification failed for " + onSaveMsg);
		            break;
		        }
		    }
		
		
	}
	/*private void validatePageFieldError_OnStep3(String onSaveMsg)
	{
		// Define a map for field elements and their corresponding validation messages
		Map<WebElement, String> fieldValidationMap = new LinkedHashMap<>();
		fieldValidationMap.put(obj.EnterDCBilPaymentUrl, "Please enter DC BilPayment Url");
		fieldValidationMap.put(obj.EnterDRBilPaymentUrl, "Please enter DR BilPayment Url");
		fieldValidationMap.put(obj.EnterDROprServiceUrl, "Please enter DR OprService Url");
		fieldValidationMap.put(obj.EnterDCOprServiceUrl, "Please enter DC OprService Url");
		fieldValidationMap.put(obj.EnterRemark, "Please enter Maker Remark");
		fieldValidationMap.put(obj.EnterRemark, "Remarks should be greater then 5");
		fieldValidationMap.put(obj.EnterRemark, "Please enter valid Maker Remark");

		// Iterate through the map and validate each field
		for (Map.Entry<WebElement, String> entry : fieldValidationMap.entrySet()) {
		    WebElement field = entry.getKey();
		    String validationMessage = entry.getValue();
		   
		    if (action.getAttributeValue(field, "value").equals("")) {
		    	
		        Assert.assertEquals(onSaveMsg, validationMessage, "Verification of " + validationMessage);
		        break;
		    }
		}
	}*/
	@SuppressWarnings("restriction")
	private void validatePageFieldError_OnStep3(String onSaveMsg) {
	    // Define a map for field elements and their corresponding validation messages
	    Map<WebElement, Pair<String, List<String>>> fieldValidationMap = new LinkedHashMap<>();
	    fieldValidationMap.put(obj.EnterDCBilPaymentUrl, new Pair<>("DC_BillPaymentUrl",Arrays.asList("Please enter DC BilPayment Url")));
	    fieldValidationMap.put(obj.EnterDRBilPaymentUrl, new Pair<>("DR_BillPaymentUrl",Arrays.asList("Please enter DR BilPayment Url")));
	    fieldValidationMap.put(obj.EnterDROprServiceUrl, new Pair<>("DR_OprServiceUrl",Arrays.asList("Please enter DR OprService Url")));
	    fieldValidationMap.put(obj.EnterDCOprServiceUrl, new Pair<>("DC_OprServiceUrl",Arrays.asList("Please enter DC OprService Url")));
	    fieldValidationMap.put(obj.EnterRemark, new Pair<>("Please enter Maker Remark",Arrays.asList("Remarks should be greater than 5", "Please enter valid Maker Remark")));
	  	
	    
	    
	    // Iterate through the map and validate each field

	    for (Map.Entry<WebElement, Pair<String, List<String>>> entry : fieldValidationMap.entrySet())        
	    {
	    	 	WebElement field = entry.getKey();
		        String fieldName = entry.getValue().getKey();
		        List<String> validationMessages = entry.getValue().getValue();
		       
	        if (action.getAttributeValue(field, "value",fieldName).equals("")) {
	            boolean matchFound = validationMessages.contains(onSaveMsg);
	            Assert.assertTrue(matchFound, "Verification failed for " + onSaveMsg);
	            break;
	        }
	    }
	}

	/*private void validatePageFieldError_OnStep1(String onSaveMsg) {
		//System.out.println("-----validatePageFieldError_OnStep1-onSaveMsg-----:"+onSaveMsg);
		if(action.getAttributeValue(obj.EnterBillerId, "value").equals("") && !action.getAttributeValue(obj.EnterServiceCode, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter Biller Id","Verification of Biller id");
		}

		if(action.getAttributeValue(obj.EnterServiceCode, "value").equals("") && !action.getAttributeValue(obj.EnterBillerId, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter Service Code","Verification of Service Code");
		}
		if(action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("") && !action.getAttributeValue(obj.EnterBillerId, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceCode, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter Service Provider Name","Verification of Service Provider Name");
		}
		if(action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals("") && !action.getAttributeValue(obj.EnterBillerId, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceCode, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter SubService Provider Name","Verification of SubServiceProvider Name");
		}

		if(action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals("") && !action.getAttributeValue(obj.EnterBillerId, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceCode, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter SubService Provider Code","Verification of SubServiceProvider Code");
		}

		if(action.getAttributeValue(obj.EnterBillerId, "value").equals("") && !action.getAttributeValue(obj.EnterServiceCode, "value").equals("")
				&& !action.getAttributeValue(obj.EnterServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderName, "value").equals("")
				&& !action.getAttributeValue(obj.EnterSubServiceProviderCode, "value").equals(""))
		{
			Assert.assertEquals(onSaveMsg, "Please enter Biller Id","Verification of All Blank Fields");
		}
	}
*/
	public void FillInAddStep3(String dC_BillValidation_URL, String dR_BillValidation_URL, String dC_Bill_Fetch_URL,
			String dR_Bill_Fetch_URL, String dC_Bill_Payment_URL, String dR_Bill_Payment_URL,
			String dC_Operator_Validation_URL, String dR_Operator_Validation_URL, String dC_Operator_Service_URL,
			String dR_Operator_Service_URL, String dC_Operator_Status_URL, String dR_Operator_Status_URL,
			String dC_Bill_Status_Check_URL, String dR_Bill_Status_Check_URL, String dC_Operator_Token_URL,
			String dR_Operator_Token_URL, String dC_Operator_Balance_URL, String dR_Operator_Balance_URL,
			String dC_Operator_Username, String dR_Operator_Username, String dC_Operator_Password, String dR_Operator_Password,
			String dC_Operator_Token_Session, String dR_Operator_Token_Session, String dC_Connection_URL,
			String dR_Connection_URL, String dC_ProxyIp, String dR_ProxyIp, String dC_ProxyPort, String dR_ProxyPort,
			String dC_BillCancelURL, String dR_BillCancelURL, String dC_BillResendURL, String dR_BillResendURL,
			String dC_OprCancelURL, String dR_OprCancelURL, String dC_OprResendURL, String dR_OprResendURL,
			String dC_Status, String dR_Status, String dC_InActive, String dR_InActive, String dC_Is_WCF_Operator,
			String dR_Is_WCF_Operator, String remarks) {

		Assert.assertTrue(wait.waitForElementToBeVisible(obj.StepPage3, 10).getText().contains("STEP 3"));
		CommonLogger.log("Initiated the process of filling in details on Page 3.");
		action.enterAndVerify(obj.EnterDCBilValidationUrl, dC_BillValidation_URL, "dC_BillValidation_URL");
		action.enterAndVerify(obj.EnterDRBilValidationUrl, dR_BillValidation_URL, "dR_BillValidation_URL");
		action.enterAndVerify(obj.EnterDCBilFetchUrl, dC_Bill_Fetch_URL, "dC_Bill_Fetch_URL");
		action.enterAndVerify(obj.EnterDRBilFetchUrl, dR_Bill_Fetch_URL, "dR_Bill_Fetch_URL");
		action.enterAndVerify(obj.EnterDCBilPaymentUrl, dC_Bill_Payment_URL, "dC_Bill_Payment_URL");
		action.enterAndVerify(obj.EnterDRBilPaymentUrl, dR_Bill_Payment_URL, "dR_Bill_Payment_URL");
		action.enterAndVerify(obj.EnterDCOprValidationUrl, dC_Operator_Validation_URL, "dC_Operator_Validation_URL");
		action.enterAndVerify(obj.EnterDROprValidationUrl, dR_Operator_Validation_URL, "dR_Operator_Validation_URL");
		action.enterAndVerify(obj.EnterDCOprServiceUrl, dC_Operator_Service_URL, "dC_Operator_Service_URL");
		action.enterAndVerify(obj.EnterDROprServiceUrl, dR_Operator_Service_URL, "dR_Operator_Service_URL");
		action.enterAndVerify(obj.EnterDCOprStatusUrl, dC_Operator_Status_URL, "dC_Operator_Status_URL");
		action.enterAndVerify(obj.EnterDROprStatusUrl, dR_Operator_Status_URL, "dR_Operator_Status_URL");
		action.enterAndVerify(obj.EnterDCBillStatusCheckURL, dC_Bill_Status_Check_URL, "dC_Bill_Status_Check_URL");
		action.enterAndVerify(obj.EnterDRBillStatusCheckURL, dR_Bill_Status_Check_URL, "dR_Bill_Status_Check_URL");
		action.enterAndVerify(obj.EnterDCOprTokenUrl, dC_Operator_Token_URL, "dC_Operator_Token_URL");
		action.enterAndVerify(obj.EnterDROprTokenUrl, dR_Operator_Token_URL, "dC_Operator_Token_URL");
		action.enterAndVerify(obj.EnterDCOprBalanceUrl, dC_Operator_Balance_URL, "dC_Operator_Balance_URL");
		action.enterAndVerify(obj.EnterDROprBalanceUrl, dR_Operator_Balance_URL, "dR_Operator_Balance_URL");
		action.enterAndVerify(obj.EnterDCOprUserName, dC_Operator_Username, "dC_Operator_Username");
		action.enterAndVerify(obj.EnterDROprUserName, dR_Operator_Username, "dR_Operator_Username");
		action.enterAndVerify(obj.EnterDCOprPassword, dC_Operator_Password, "dC_Operator_Password");
		action.enterAndVerify(obj.EnterDROprPassword, dR_Operator_Password, "dR_Operator_Password");
		action.enterAndVerify(obj.EnterDCOprToken_Session, dC_Operator_Token_Session, "dC_Operator_Token_Session");
		action.enterAndVerify(obj.EnterDROprToken_Session, dR_Operator_Token_Session, "dR_Operator_Token_Session");
		action.enterAndVerify(obj.EnterDCconnectionurl, dC_Connection_URL, "dC_Connection_URL");
		action.enterAndVerify(obj.EnterDRconnectionurl, dR_Connection_URL, "dR_Connection_URL");
		action.enterAndVerify(obj.EnterDCProxyIp, dC_ProxyIp, "dC_ProxyIp");
		action.enterAndVerify(obj.EnterDRProxyIp, dR_ProxyIp, "dR_ProxyIp");
		action.enterAndVerify(obj.EnterDCProxyPort, dC_ProxyPort, "dC_ProxyPort");
		action.enterAndVerify(obj.EnterDRProxyPort, dR_ProxyPort, "dR_ProxyPort");
		action.enterAndVerify(obj.EnterDcBilCancelURL, dC_BillCancelURL, "dC_BillCancelURL");
		action.enterAndVerify(obj.EnterDRBilCancelURL, dR_BillCancelURL, "dR_BillCancelURL");
		action.enterAndVerify(obj.EnterDcBilResendURL, dC_BillResendURL, "dC_BillResendURL");
		action.enterAndVerify(obj.EnterDRBilResendURL, dR_BillResendURL, "dR_BillResendURL");
		action.enterAndVerify(obj.EnterDcOprCancelURL, dC_OprCancelURL, "dC_OprCancelURL");
		action.enterAndVerify(obj.EnterDROprCancelURL, dR_OprCancelURL, "dR_OprCancelURL");
		action.enterAndVerify(obj.EnterDcOprResendURL, dC_OprResendURL, "dC_OprResendURL");
		action.enterAndVerify(obj.EnterDROprResendURL, dR_OprResendURL, "dR_OprResendURL");	
		action.selectActiveFlagAndVerify(obj.SelectDCIsActive, dC_Status, "DC Status");
		action.selectActiveFlagAndVerify(obj.SelectDRIsActive, dR_Status, "DR Status");
		action.clickOnCheckboxAndVerify(obj.ChooseDCWCFOperator,dC_Is_WCF_Operator,"Choose dC_Is_WCF_Operator");
		action.clickOnCheckboxAndVerify(obj.ChooseDRWCFOperator,dR_Is_WCF_Operator,"Choose dR_Is_WCF_Operator");
		action.enterAndVerify(obj.EnterRemark, remarks, "remarks");	
		driver.manage().window().maximize();
		//event.printSnap("CRM STEP 3 Details Added");	
		event.fullprintSnap("CRM STEP 3 FILL DETAILS ADDED new");
		CommonLogger.log("Completed the process of filling in details on Page 3.");
	}

	public void Logout() throws Exception {
		// TODO Auto-generated method stub
		while (retryCount < 5) {
			try {
				wait.waitForElementToBeVisible(obj.ClickLogout, 10).click();
				//getLog().info("CRM Logout Successfully");
				CommonLogger.log("CRM Logout Successfully");
				event.printSnap("CRM Successful LogOut");
				break; // Exit loop after successful logout
			} catch (Exception e) {
				retryCount++;
				if (retryCount >= 5) {
					throw e; // After 3 retries, rethrow the exception
				}
			}
		}
	}

	public void GoForCheckerProcess(String BillerId, String ServiceCode, String ServiceProviderName,
			String ServiceProviderCode, String SubServiceProviderCode,
			String SubServiceProviderName, String Action, String CheckerRemarks,
			String AmountFlag, String BillValidationFlag,
			String DC_BilFetchUrl,String DC_BilPaymentUrl, String DC_BilStatusCheckUrl, String DC_BilValidationUrl, String DC_IsActive,
			String DC_OprBalanceUrl,String DC_OprPassword,String DC_OprServiceUrl,String DC_OprStatusUrl,
			String DC_OprToken_Session,String DC_OprTokenUrl,String DC_OprUserName,String DC_OprValidationUrl,String DC_ProxyIp,
			String DC_ProxyPort,String DC_WcfOperator,String DCBilCancelUrl,String DCBilResendUrl,String DCconnectionurl,
			String DCOprCancelUrl,String DCOprResendUrl,String DR_BilFetchUrl,String DR_BilPaymentUrl,String DR_BilStatusCheckUrl,
			String DR_BilValidationUrl,String DR_IsActive,String DR_OprBalanceUrl,String DR_OprPassword,String DR_OprServiceUrl,
			String DR_OprStatusUrl,String DR_OprToken_Session,String DR_OprTokenUrl,String DR_OprUserName,String DR_OprValidationUrl,
			String DR_ProxyIp,String DR_ProxyPort,String DR_WcfOperator,String DRBilCancelUrl,String DRBilResendUrl,
			String DRconnectionurl,String DROprCancelUrl,String DrOprResendUrl,String FetchRequirement,String IsMappedResCode,
			String IsQuickPay,String MakerRemark,String SPField1,String SPField10,
			String SPField2,String SPField3,String SPField4,
			String SPField5,String SPField6,String SPField7,String SPField8,String SPField9,String ValidateAmountFlag)
					throws Exception 
	{
		CommonLogger.log("Initiated the Checker Process");
		Assert.assertEquals(wait.waitForElementToBeVisible(obj.OnClickVerifyMode, 10).getText(), "Biller Configuration ONUS Checker", "Checker Label Verification");
		obj.EnterSearchText.sendKeys(ServiceProviderCode);
		event.printSnap("Search Record Found");

		List<WebElement> ListBillerId = wait.waitForListOfElementToBeVisible(obj.ListOfBillerId, 10);
		List<WebElement> ListServiceCode = wait.waitForListOfElementToBeVisible(obj.ListOfServiceCode, 10);
		List<WebElement> ListServiceProviderName = wait.waitForListOfElementToBeVisible(obj.ListOfServiceProviderName, 10);
		List<WebElement> ListServiceProviderCode = wait.waitForListOfElementToBeVisible(obj.ListOfServiceProviderCode, 10);
		List<WebElement> ListSubServiceProviderCode = wait.waitForListOfElementToBeVisible(obj.ListOfSubServiceProviderCode, 10);
		List<WebElement> ListSubServiceProviderName = wait.waitForListOfElementToBeVisible(obj.ListOfSubServiceProviderName, 10);
		outerLoop:
			for (int i = 0; i < ListBillerId.size(); i++) {
				if (ListBillerId.get(i).getText().equalsIgnoreCase(BillerId)) {
					//	System.out.println("BillerId: " + ListBillerId.get(i).getText());
					for (int j = 0; j < ListServiceCode.size(); j++) {
						if (ListServiceCode.get(j).getText().equals(ServiceCode)) {
							//	System.out.println("ServiceCode: " + ListServiceCode.get(j).getText());
							for (int k = 0; k < ListServiceProviderName.size(); k++) {
								if (ListServiceProviderName.get(k).getText().equals(ServiceProviderName)) {
									//	System.out.println("ServiceProviderName: " + ListServiceProviderName.get(k).getText());
									for (int n = 0; n < ListServiceProviderCode.size(); n++) {
										if (ListServiceProviderCode.get(n).getText().equals(ServiceProviderCode)) {
											//System.out.println("ServiceProviderCode: " + ListServiceProviderCode.get(n).getText());
											for (int r = 0; r < ListSubServiceProviderCode.size(); r++) {
												if (ListSubServiceProviderCode.get(r).getText().equals(SubServiceProviderCode)) {
													//	System.out.println("SubServiceProviderCode: " + ListSubServiceProviderCode.get(r).getText());
													for (int g = 0; g < ListSubServiceProviderName.size(); g++) {
														if (ListSubServiceProviderName.get(g).getText().equals(SubServiceProviderName)) {
															//System.out.println("SubServiceProviderName: " + ListSubServiceProviderName.get(g).getText());
															//System.out.println("--- REACHED FINAL DESTINATION ---****");
															obj.ListOfViewButton.click();
															event.printSnap("View Mode Opened");
															boolean flag1=VerifyCheckerGrid(BillerId, ServiceCode,ServiceProviderName,
																	ServiceProviderCode,SubServiceProviderCode,
																	SubServiceProviderName);
															boolean flag2=VerifyCheckerTable(AmountFlag,BillerId,BillValidationFlag,
																	DC_BilFetchUrl,DC_BilPaymentUrl,DC_BilStatusCheckUrl,DC_BilValidationUrl, 
																	DC_IsActive,
																	DC_OprBalanceUrl,DC_OprPassword,DC_OprServiceUrl,DC_OprStatusUrl,DC_OprToken_Session,
																	DC_OprTokenUrl,DC_OprUserName,DC_OprValidationUrl,DC_ProxyIp,DC_ProxyPort,
																	DC_WcfOperator,DCBilCancelUrl,DCBilResendUrl,DCconnectionurl,
																	DCOprCancelUrl,DCOprResendUrl,DR_BilFetchUrl,DR_BilPaymentUrl,DR_BilStatusCheckUrl,
																	DR_BilValidationUrl,DR_IsActive,
																	DR_OprBalanceUrl,DR_OprPassword,DR_OprServiceUrl,
																	DR_OprStatusUrl,DR_OprToken_Session,DR_OprTokenUrl,
																	DR_OprUserName,DR_OprValidationUrl,
																	DR_ProxyIp,DR_ProxyPort,DR_WcfOperator,DRBilCancelUrl,DRBilResendUrl,
																	DRconnectionurl,DROprCancelUrl,DrOprResendUrl,FetchRequirement,IsMappedResCode,
																	IsQuickPay,MakerRemark,ServiceCode,ServiceProviderCode,ServiceProviderName,SPField1,SPField10,
																	SPField2,SPField3,SPField4,
																	SPField5,SPField6,SPField7,SPField8,SPField9,
																	SubServiceProviderCode,SubServiceProviderName,ValidateAmountFlag);

															if(flag1==true && flag2==true)
															{
																scroll.scrollToBottom();
																try
																{
																	obj.CheckerRemarks.sendKeys(CheckerRemarks);
																	//getLog().info("Checker Remarks Entered, Proeeding for Taking action");
																	CommonLogger.log("Checker Remarks Entered, Proceeding for Taking action");
																	event.printSnap("Checker Remarks Entered");

																	if(Action.equalsIgnoreCase("Reject"))
																	{
																		//getLog().info("Action Taken : "+Action);
																		CommonLogger.log("Action Taken by Checker: "+Action);
																		event.printSnap("CRM Action Taken "+Action);
																		obj.ClickOnReject.click();
																		String checkerAlert=wait.waitForElementToBeVisible(obj.CheckerAlertMsg, 20).getText();
																		event.printSnap("On Checker Reject Message");
																		Assert.assertEquals(checkerAlert,"Cofiguration Started- Biller Record Deleted from Staging Tables- Configuration Completed", "Verification of Reject-Taken Message");
																		Thread.sleep(5000);
																		//getLog().info(checkerAlert);
																		CommonLogger.log(checkerAlert);

																		wait.waitforelementToBeClickable(obj.CheckerModalInfoClosed, 10).click();
																		//getLog().info("Checker Alert Modal Info Closed");
																		CommonLogger.log("Checker Alert Modal Info Closed");
																		event.printSnap("Checker Alert Modal Info Closed");
																		Assert.assertEquals(obj.OnClickVerifyMode.getText(), "Biller Configuration ONUS Checker","Verification of CHecker View");
																	}
																	else if(Action.equalsIgnoreCase("Approve"))
																	{
																		//getLog().info("Action Taken : "+Action);
																		CommonLogger.log("Action Taken by Checker: "+Action);
																		event.printSnap("CRM Action Taken "+Action);
																		obj.ClickOnApprove.click();
																		String checkerAlert=wait.waitForElementToBeVisible(obj.CheckerAlertMsg, 20).getText();
																		//getLog().info(checkerAlert);
																		CommonLogger.log(checkerAlert);
																		event.printSnap("On Checker Approve Message");
																		Assert.assertEquals(checkerAlert,"Cofiguration Started- Service Provider Code Created- Sub Service Provider Code Created- ServiceProviderService Inserted- OperatorURLConfiguration Inserted for DC and DR- Biller Configuration Inserted- Configuration Completed | EBO Configuration Started - Sub Service Provider Created in EBO- Biller Configuration Inserted in EBO", "Verification of Approve-Taken Message");
																		Thread.sleep(3000);
																		wait.waitforelementToBeClickable(obj.CheckerModalInfoClosed, 10).click();
																		//getLog().info("Checker Alert Modal Info Closed");
																		CommonLogger.log("Checker Alert Modal Info Closed");
																		event.printSnap("Checker Alert Modal Info Closed");
																		Assert.assertEquals(obj.OnClickVerifyMode.getText(), "Biller Configuration ONUS Checker","Verification of CHecker View");

																	}
																}
																catch(Exception e)
																{
																	//	getLog().info("During Checker Approval process,Runtime Exception occured");
																	CommonLogger.log("During Checker Approval process,Runtime Exception occured");
																	//event.printSnap("RunTime Exception occured");
																}

															}
															break outerLoop;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
	}

	private boolean VerifyCheckerTable(String AmountFlag,String BillerId, String BillValidationFlag,
			String DC_BilFetchUrl,String DC_BilPaymentUrl, String DC_BilStatusCheckUrl, String DC_BilValidationUrl, String DC_IsActive,
			String DC_OprBalanceUrl,String DC_OprPassword,String DC_OprServiceUrl,String DC_OprStatusUrl,
			String DC_OprToken_Session,String DC_OprTokenUrl,String DC_OprUserName,String DC_OprValidationUrl,String DC_ProxyIp,
			String DC_ProxyPort,String DC_WcfOperator,
			String DCBilCancelUrl,String DCBilResendUrl,String DCconnectionurl,
			String DCOprCancelUrl,String DCOprResendUrl,String DR_BilFetchUrl,String DR_BilPaymentUrl,String DR_BilStatusCheckUrl,
			String DR_BilValidationUrl,String DR_IsActive,String DR_OprBalanceUrl,String DR_OprPassword,String DR_OprServiceUrl,
			String DR_OprStatusUrl,String DR_OprToken_Session,String DR_OprTokenUrl,String DR_OprUserName,String DR_OprValidationUrl,
			String DR_ProxyIp,String DR_ProxyPort,String DR_WcfOperator,String DRBilCancelUrl,String DRBilResendUrl,
			String DRconnectionurl,String DROprCancelUrl,String DrOprResendUrl,String FetchRequirement,String IsMappedResCode,
			String IsQuickPay,String MakerRemark,
			String ServiceCode,String ServiceProviderCode,String ServiceProviderName,String SPField1,String SPField10,
			String SPField2,String SPField3,String SPField4,String SPField5,String SPField6,String SPField7,String SPField8,String SPField9,
			String SubServiceProviderCode,String SubServiceProviderName,String ValidateAmountFlag) {
		// TODO Auto-generated method stub
		boolean flag=false;

		for(int j=0;j<obj.TotalPageCountCheckerTbl.size();j++)
		{
			int counter=0;
			String PageNumber = obj.TotalPageCountCheckerTbl.get(j).getText();
			switch (obj.TotalPageCountCheckerTbl.get(j).getText())
			{
			case "1":
			{

				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_1(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),AmountFlag,BillerId,
							BillValidationFlag,DC_BilFetchUrl,DC_BilPaymentUrl,DC_BilStatusCheckUrl,DC_BilValidationUrl, DC_IsActive,
							DC_OprBalanceUrl);
					counter++;
					flag=true;
				}
				break;
			}
			case "2":
			{

				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_2(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),DC_OprPassword,DC_OprServiceUrl,
							DC_OprStatusUrl,DC_OprToken_Session,DC_OprTokenUrl,DC_OprUserName,DC_OprValidationUrl,DC_ProxyIp,
							DC_ProxyPort,DC_WcfOperator);
					counter++;
					flag=true;
				}
				break;
			}
			case "3":
			{
				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_3(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),DCBilCancelUrl,DCBilResendUrl,DCconnectionurl,
							DCOprCancelUrl,DCOprResendUrl,DR_BilFetchUrl,DR_BilPaymentUrl,DR_BilStatusCheckUrl,
							DR_BilValidationUrl,DR_IsActive);
					counter++;
					flag=true;
				}
				break;
			}
			case "4":
			{
				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_4(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),DR_OprBalanceUrl,DR_OprPassword,
							DR_OprServiceUrl,DR_OprStatusUrl,DR_OprToken_Session,DR_OprTokenUrl,DR_OprUserName,DR_OprValidationUrl,
							DR_ProxyIp,DR_ProxyPort);
					counter++;
					flag=true;
				}
				break;
			}
			case "5":
			{
				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_5(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),DR_WcfOperator,DRBilCancelUrl,DRBilResendUrl,
							DRconnectionurl,DROprCancelUrl,DrOprResendUrl,FetchRequirement,IsMappedResCode,
							IsQuickPay);
					counter++;
					flag=true;
				}

				break;
			}
			case "6":
			{
				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_6(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),MakerRemark,
							ServiceCode,ServiceProviderCode,ServiceProviderName,SPField1,SPField10,
							SPField2,SPField3);
					counter++;
					flag=true;
				}
				break;
			}
			case "7":
			{
				obj.TotalPageCountCheckerTbl.get(j).click();
				for(int i=1;i<=obj.checkerTableColumn2FieldValues.size();i++)
				{
					scroll.scrollToElement(obj.CheckerTableView_2);
					if(i==1)
					{
						event.printSnap("Checker View Page "+PageNumber);
					}
					verifyFieldValues_OnPage_7(i,obj.checkerTableColumn2FieldValues.get(counter).getText(),SPField4,
							SPField5,SPField6,SPField7,SPField8,SPField9,
							SubServiceProviderCode,SubServiceProviderName,ValidateAmountFlag);
					counter++;
					flag=true;
				}
				break;
			}	
			}

		}
		return flag;
	}

	public void verifyFieldValues_OnPage_1(int i,String Value,String AmountFlag,String BillerId,String BillValidationFlag,
			String DC_BilFetchUrl,String DC_BilPaymentUrl,String DC_BilStatusCheckUrl,String DC_BilValidationUrl,String DC_IsActive,
			String DC_OprBalanceUrl)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,AmountFlag, "CheckerTable-Verify Amount Flag");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,BillerId, "CheckerTable-Verify BillerId");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,BillValidationFlag, "CheckerTable-Verify BillValidationFlag");
			break;
		}

		case "4":
		{
			Assert.assertTrue(Value!=null, "CheckerTable-Verify CreatedDateTime");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,DC_BilFetchUrl, "CheckerTable-Verify DC_BilFetchUrl");
			break;
		}

		case "6":
		{
			Assert.assertEquals(Value,DC_BilPaymentUrl, "CheckerTable-Verify DC_BilPaymentUrl");
			break;
		}

		case "7":
		{
			Assert.assertEquals(Value,DC_BilStatusCheckUrl, "CheckerTable-Verify DC_BilStatusCheckUrl");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,DC_BilValidationUrl, "CheckerTable-Verify DC_BilValidationUrl");
			break;
		}
		case "90":
		{
			Assert.assertEquals(Value,DC_IsActive, "CheckerTable-Verify DC_IsActive");
			break;
		}
		case "10":
		{
			Assert.assertEquals(Value,DC_OprBalanceUrl, "CheckerTable-Verify DC_OprBalanceUrl");
			break;
		}
		}


	}

	public void verifyFieldValues_OnPage_2(int i,String Value,String DC_OprPassword,String DC_OprServiceUrl,String DC_OprStatusUrl,
			String DC_OprToken_Session,String DC_OprTokenUrl,String DC_OprUserName,String DC_OprValidationUrl,String DC_ProxyIp,
			String DC_ProxyPort,String DC_WcfOperator)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,DC_OprPassword, "CheckerTable-Verify DC_OprPassword");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,DC_OprServiceUrl, "CheckerTable-Verify DC_OprServiceUrl");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,DC_OprStatusUrl, "CheckerTable-Verify DC_OprStatusUrl");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,DC_OprToken_Session, "CheckerTable-Verify DC_OprToken/Session");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,DC_OprTokenUrl, "CheckerTable-Verify DC_OprTokenUrl");
			break;
		}

		case "6":
		{
			Assert.assertEquals(Value,DC_OprUserName, "CheckerTable-Verify DC_OprUserName");
			break;
		}

		case "7":
		{
			Assert.assertEquals(Value,DC_OprValidationUrl, "CheckerTable-Verify DC_OprValidationUrl");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,DC_ProxyIp, "CheckerTable-Verify DC_ProxyIp");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,DC_ProxyPort, "CheckerTable-Verify DC_ProxyPort");
			break;
		}
		case "10":
		{
			Assert.assertEquals(Value,DC_WcfOperator, "CheckerTable-Verify DC_WcfOperator");
			break;
		}
		}


	}

	public void verifyFieldValues_OnPage_3(int i,String Value,String DCBilCancelUrl,String DCBilResendUrl,String DCconnectionurl,
			String DCOprCancelUrl,String DCOprResendUrl,String DR_BilFetchUrl,String DR_BilPaymentUrl,String DR_BilStatusCheckUrl,
			String DR_BilValidationUrl,String DR_IsActive)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,DCBilCancelUrl, "CheckerTable-Verify DCBilCancelUrl");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,DCBilResendUrl, "CheckerTable-Verify DCBilResendUrl");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,DCconnectionurl, "CheckerTable-Verify DCconnectionurl");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,DCOprCancelUrl, "CheckerTable-Verify DCOprCancelUrl");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,DCOprResendUrl, "CheckerTable-Verify DCOprResendUrl");
			break;
		}

		case "6":
		{
			Assert.assertEquals(Value,DR_BilFetchUrl, "CheckerTable-Verify DR_BilFetchUrl");
			break;
		}

		case "7":
		{
			Assert.assertEquals(Value,DR_BilPaymentUrl, "CheckerTable-Verify DR_BilPaymentUrl");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,DR_BilStatusCheckUrl, "CheckerTable-Verify DR_BilStatusCheckUrl");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,DR_BilValidationUrl, "CheckerTable-Verify DR_BilValidationUrl");
			break;
		}
		case "10":
		{
			Assert.assertEquals(Value,DR_IsActive, "CheckerTable-Verify DR_IsActive");
			break;
		}
		}

	}

	public void verifyFieldValues_OnPage_4(int i,String Value,String DR_OprBalanceUrl,String DR_OprPassword,String DR_OprServiceUrl,
			String DR_OprStatusUrl,String DR_OprToken_Session,String DR_OprTokenUrl,String DR_OprUserName,String DR_OprValidationUrl,
			String DR_ProxyIp,String DR_ProxyPort)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,DR_OprBalanceUrl, "CheckerTable-Verify DR_OprBalanceUrl");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,DR_OprPassword, "CheckerTable-Verify DR_OprPassword");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,DR_OprServiceUrl, "CheckerTable-Verify DR_OprServiceUrl");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,DR_OprStatusUrl, "CheckerTable-Verify DR_OprStatusUrl");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,DR_OprToken_Session, "CheckerTable-Verify DR_OprToken_Session");
			break;
		}

		case "6":
		{

			Assert.assertEquals(Value,DR_OprTokenUrl, "CheckerTable-Verify DR_OprTokenUrl");
			break;
		}

		case "7":
		{

			Assert.assertEquals(Value,DR_OprUserName, "CheckerTable-Verify DR_OprUserName");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,DR_OprValidationUrl, "CheckerTable-Verify DR_OprValidationUrl");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,DR_ProxyIp, "CheckerTable-Verify DR_ProxyIp");
			break;
		}
		case "10":
		{
			Assert.assertEquals(Value,DR_ProxyPort, "CheckerTable-Verify DR_ProxyPort");
			break;
		}
		}

	}

	public boolean VerifyCheckerGrid(String BillerId, String ServiceCode,String ServiceProviderName,String ServiceProviderCode,String SubServiceProviderCode,
			String SubServiceProviderName) throws Exception
	{
		int counter=0;
		List<WebElement> ListBillerId = wait.waitForListOfElementToBeVisible(obj.ListOfBillerId, 10);
		List<WebElement> ListServiceCode = wait.waitForListOfElementToBeVisible(obj.ListOfServiceCode, 10);
		List<WebElement> ListServiceProviderName = wait.waitForListOfElementToBeVisible(obj.ListOfServiceProviderName, 10);
		List<WebElement> ListServiceProviderCode = wait.waitForListOfElementToBeVisible(obj.ListOfServiceProviderCode, 10);
		List<WebElement> ListSubServiceProviderCode = wait.waitForListOfElementToBeVisible(obj.ListOfSubServiceProviderCode, 10);
		List<WebElement> ListSubServiceProviderName = wait.waitForListOfElementToBeVisible(obj.ListOfSubServiceProviderName, 10);

		for(WebElement BillerIdValue:ListBillerId)
		{
			Assert.assertEquals(BillerIdValue.getText(),BillerId, "Verification Of BillerId-CheckerGrid");
			counter++;
		}
		for(WebElement ServiceCodeValue:ListServiceCode)
		{
			Assert.assertEquals(ServiceCodeValue.getText(),ServiceCode, "Verification Of ServiceCode-CheckerGrid");
			counter++;
		}
		for(WebElement ServiceProviderNameValue:ListServiceProviderName)
		{
			Assert.assertEquals(ServiceProviderNameValue.getText(),ServiceProviderName, "Verification Of ServiceProviderName-CheckerGrid");
			counter++;
		}  
		for(WebElement ServiceProviderCodeValue:ListServiceProviderCode)
		{
			Assert.assertEquals(ServiceProviderCodeValue.getText(),ServiceProviderCode, "Verification Of ServiceProviderCode-CheckerGrid");
			counter++;
		}
		for(WebElement SubServiceProviderCodeValue:ListSubServiceProviderCode)
		{
			Assert.assertEquals(SubServiceProviderCodeValue.getText(),SubServiceProviderCode, "Verification Of SubServiceProviderCode-CheckerGrid");
			counter++;
		}
		for(WebElement SubServiceProviderNameValue:ListSubServiceProviderName)
		{
			Assert.assertEquals(SubServiceProviderNameValue.getText(),SubServiceProviderName, "Verification Of SubServiceProviderName-CheckerGrid");
			counter++;
		}

		if(counter==6)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public void verifyFieldValues_OnPage_5(int i,String Value,String DR_WcfOperator,String DRBilCancelUrl,String DRBilResendUrl,
			String DRconnectionurl,String DROprCancelUrl,String DrOprResendUrl,String FetchRequirement,String IsMappedResCode,
			String IsQuickPay)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,DR_WcfOperator, "CheckerTable-Verify DR_WcfOperator");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,DRBilCancelUrl, "CheckerTable-Verify DRBilCancelUrl");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,DRBilResendUrl, "CheckerTable-Verify DRBilResendUrl");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,DRconnectionurl, "CheckerTable-Verify DRconnectionurl");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,DROprCancelUrl, "CheckerTable-Verify DROprCancelUrl");
			break;
		}

		case "6":
		{
			Assert.assertTrue(Value.equals(DrOprResendUrl), "CheckerTable-Verify DrOprResendUrl");
			break;
		}

		case "7":
		{
			if(FetchRequirement.trim().equals("Mandatory"))
			{
				FetchRequirement="M";
			}
			Assert.assertEquals(Value,FetchRequirement, "CheckerTable-Verify FetchRequirement");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,IsMappedResCode, "CheckerTable-Verify IsMappedResCode");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,IsQuickPay, "CheckerTable-Verify IsQuickPay");
			break;
		}
		case "10":
		{
			Assert.assertTrue(!Value.equals(""), "CheckerTable-Verify LastModifiedDateTime");
			break;
		}
		}

	}

	public void verifyFieldValues_OnPage_6(int i,String Value,String MakerRemark,
			String ServiceCode,String ServiceProviderCode,String ServiceProviderName,String SPField1,String SPField10,
			String SPField2,String SPField3)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,MakerRemark, "CheckerTable-Verify MakerRemark");
			break;
		}

		case "2":
		{
			Assert.assertTrue(!Value.equals(""), "CheckerTable-Verify MakerUid");
			break;
		}

		case "3":
		{
			Assert.assertTrue(!Value.equals(""), "CheckerTable-Verify MakerUserid");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,ServiceCode, "CheckerTable-Verify ServiceCode");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,ServiceProviderCode, "CheckerTable-Verify ServiceProviderCode");
			break;
		}

		case "6":
		{
			Assert.assertEquals(Value,ServiceProviderName, "CheckerTable-Verify ServiceProviderName");
			break;
		}

		case "7":
		{
			Assert.assertEquals(Value,SPField1, "CheckerTable-Verify SPField1");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,SPField10, "CheckerTable-Verify SPField10");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,SPField2, "CheckerTable-Verify SPField2");
			break;
		}
		case "10":
		{
			Assert.assertEquals(Value,SPField3, "CheckerTable-Verify SPField3");
			break;
		}
		}

	}

	public void verifyFieldValues_OnPage_7(int i,String Value,String SPField4,
			String SPField5,String SPField6,String SPField7,String SPField8,String SPField9,
			String SubServiceProviderCode,String SubServiceProviderName,String ValidateAmountFlag)
	{
		switch (String.valueOf(i))
		{
		case "1":
		{
			Assert.assertEquals(Value,SPField4, "CheckerTable-Verify SPField4");
			break;
		}

		case "2":
		{
			Assert.assertEquals(Value,SPField5, "CheckerTable-Verify SPField5");
			break;
		}

		case "3":
		{
			Assert.assertEquals(Value,SPField6, "CheckerTable-Verify SPField6");
			break;
		}

		case "4":
		{
			Assert.assertEquals(Value,SPField7, "CheckerTable-Verify SPField7");
			break;
		}

		case "5":
		{
			Assert.assertEquals(Value,SPField8, "CheckerTable-Verify SPField8");
			break;
		}

		case "6":
		{

			Assert.assertEquals(Value,SPField9, "CheckerTable-Verify SPField9");
			break;
		}

		case "7":
		{
			Assert.assertEquals(Value,SubServiceProviderCode, "CheckerTable-Verify SubServiceProviderCode");
			break;
		}

		case "8":
		{
			Assert.assertEquals(Value,SubServiceProviderName, "CheckerTable-Verify SubServiceProviderName");
			break;
		}

		case "9":
		{
			Assert.assertEquals(Value,ValidateAmountFlag, "CheckerTable-Verify ValidateAmountFlag");
			break;
		}

		}

	}

}