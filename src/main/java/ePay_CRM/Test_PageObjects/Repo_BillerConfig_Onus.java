package ePay_CRM.Test_PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repo_BillerConfig_Onus {


	public Repo_BillerConfig_Onus(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@ID='lblFormHeaderLabelST1']")
	public WebElement VerifyHeaderStep1;

	@FindBy(xpath="//*[@ID='lblFormHeaderLabelST2']")
	public WebElement VerifyHeaderStep2;
	
	@FindBy(xpath="//*[@ID='lblFormHeaderLabelST3']")
	public WebElement VerifyHeaderStep3;
	
	@FindBy(xpath="//*[@ID='lblFormHeaderLabelST4']")
	public WebElement VerifyHeaderStep4;
	
	@FindBy(id="BillerID")
	public WebElement EnterBillerId; 
	
	@FindBy(id="ServiceCodeName")
	public WebElement EnterServiceCode; 
	
	@FindBy(xpath="//ul[@id='ui-id-1']/li/div")
	public List<WebElement> SelectServiceCode;

	@FindBy(id="ServiceProviderName")
	public WebElement EnterServiceProviderName; 

	@FindBy(id="ServiceProviderCode")
	public WebElement EnterServiceProviderCode; 
	
	@FindBy(xpath="//select[@id='ValidateAmountFlag']")
	public WebElement SelectValidateAmountFlag; 
	
	@FindBy(xpath="//select[@id='FetchRequirement']")
	//id="FetchRequirement"
	public WebElement SelectFetchRequirement; 
	
	@FindBy(id="SubServiceProviderName")
	public WebElement EnterSubServiceProviderName; 
	
	@FindBy(id="SubServiceProviderCode")
	public WebElement EnterSubServiceProviderCode; 
	
	@FindBy(id="btnNext")
	public WebElement ClickOnSave1; 
	
	@FindBy(id="btnClearStep1")
	public WebElement ClickOnClear1; 
	
	@FindBy(id="btnNext2")
	public WebElement ClickOnUploadButton1; 
	
	@FindBy(xpath="//*[text()='Record Successfully Added for STEP - 1']")
	//(xpath="//div[@class='modal-body'][contains(text(),'Record Successfully Added for STEP - 1')]")
	public WebElement verifyOnSaveSuccessMsg1;

	// WEBELEMENTS FOR STEP -2
	
	@FindBy(xpath="//input[@id='SPField1']")
	public WebElement EnterSPField1; 
	
	@FindBy(xpath="//input[@id='SPField2']")
	public WebElement EnterSPField2; 
	
	@FindBy(xpath="//input[@id='SPField3']")
	public WebElement EnterSPField3; 
	
	@FindBy(xpath="//input[@id='SPField4']")
	public WebElement EnterSPField4; 
	
	@FindBy(xpath="//input[@id='SPField5']")
	public WebElement EnterSPField5; 

	@FindBy(xpath="//input[@id='SPField6']")
	public WebElement EnterSPField6; 
	
	@FindBy(xpath="//input[@id='SPField7']")
	public WebElement EnterSPField7; 

	@FindBy(xpath="//input[@id='SPField8']")
	public WebElement EnterSPField8; 
	
	@FindBy(xpath="//input[@id='SPField9']")
	public WebElement EnterSPField9; 
	
	@FindBy(xpath="//input[@id='SPField10']")
	public WebElement EnterSPField10; 
	
	@FindBy(id="IsQuickPay")
	public WebElement ChooseQuickPay; 

	@FindBy(xpath="//input[@id='ValidationFlag']")
	public WebElement ChooseValidationFlag; 
	
	@FindBy(id="ValidationFlag")
	public WebElement ChooseStep2ValidationFlag; 
	
	@FindBy(id="AmountFlag")
	public WebElement ChooseAmountFlag; 
	
	@FindBy(id="IsMappedResCode")
	public WebElement ChooseIsMappedResCode; 
	
	@FindBy(id="btnSaveStep2")
	public WebElement ClickOnSave2; 
	
	@FindBy(id="btnClearStep2")
	public WebElement ClickOnClear2; 
	
	@FindBy(xpath="/html/body/div[1]/div/div[7]/div/div[3]/div[2]/button")
	public WebElement clickOnClose_ErrorModal;
	
	@FindBy(xpath="//button[@class='btn btn-info' and @onclick='InfoClose();']")
	public WebElement clickonCheckerErrorModal;
	
	@FindBy(xpath="//div[@id='dvInfo']/button[@onclick='InfoClose();']")
	public WebElement clickOnClose_SuccessModal;
	////div[@id='dvInfo']/button[@onclick='InfoClose();']
	
	@FindBy(xpath="//div[@class='modal-body'][contains(text(),'Record Successfully Added for STEP - 2')]")
	public WebElement verifyOnSaveSuccessMsg2;
	
	
	/// WebElements for OperatorUrlConfiguration-DC
	
	@FindBy(id="DCBilValidationUrl")
	public WebElement EnterDCBilValidationUrl;
	
	@FindBy(id="DCBilFetchUrl")
	public WebElement EnterDCBilFetchUrl;
	
	@FindBy(id="DCBilPaymentUrl")
	public WebElement EnterDCBilPaymentUrl;
	
	@FindBy(id="DCOprValidationUrl")
	public WebElement EnterDCOprValidationUrl;
	
	@FindBy(id="DCOprServiceUrl")
	public WebElement EnterDCOprServiceUrl;
	
	@FindBy(id="DCOprStatusUrl")
	public WebElement EnterDCOprStatusUrl;
	
	@FindBy(id="DCBilStatusCheckUrl")
	public WebElement EnterDCBillStatusCheckURL;
	
	@FindBy(id="DCOprTokenUrl")
	public WebElement EnterDCOprTokenUrl;
	
	@FindBy(id="DCOprBalanceUrl")
	public WebElement EnterDCOprBalanceUrl;
	
	@FindBy(id="DCOprUserName")
	public WebElement EnterDCOprUserName;
	
	@FindBy(id="DCOprPassword")
	public WebElement EnterDCOprPassword;
	
	@FindBy(id="DCOprToken_Session")
	public WebElement EnterDCOprToken_Session;
	
	@FindBy(id="DCconnectionurl")
	public WebElement EnterDCconnectionurl;
	
	@FindBy(id="DCProxyIp")
	public WebElement EnterDCProxyIp;
	
	@FindBy(id="DCProxyPort")
	public WebElement EnterDCProxyPort;
	
	@FindBy(id="DcBilCancelURL")
	public WebElement EnterDcBilCancelURL;
	
	@FindBy(id="DcBilResendURL")
	public WebElement EnterDcBilResendURL;
	
	@FindBy(id="DcOprCancelURL")
	public WebElement EnterDcOprCancelURL;

	@FindBy(id="DcOprResendURL")
	public WebElement EnterDcOprResendURL;
	
	@FindBy(id="DCIsActive")
	public WebElement SelectDCIsActive;
	
	@FindBy(id="DCWCFOperator")
	public WebElement ChooseDCWCFOperator;


	/// WebElements for OperatorUrlConfiguration-DR
	
	@FindBy(id="DRBilValidationUrl")
	public WebElement EnterDRBilValidationUrl;
	
	@FindBy(id="DRBilFetchUrl")
	public WebElement EnterDRBilFetchUrl;
	
	@FindBy(id="DRBilPaymentUrl")
	public WebElement EnterDRBilPaymentUrl;
	
	@FindBy(id="DROprValidationUrl")
	public WebElement EnterDROprValidationUrl;
	
	@FindBy(id="DROprServiceUrl")
	public WebElement EnterDROprServiceUrl;
	
	@FindBy(id="DROprStatusUrl")
	public WebElement EnterDROprStatusUrl;
	
	@FindBy(id="DRBilStatusCheckUrl")
	public WebElement EnterDRBillStatusCheckURL;
	
	@FindBy(id="DROprTokenUrl")
	public WebElement EnterDROprTokenUrl;
	
	@FindBy(id="DROprBalanceUrl")
	public WebElement EnterDROprBalanceUrl;
	
	@FindBy(id="DROprUserName")
	public WebElement EnterDROprUserName;
	
	@FindBy(id="DROprPassword")
	public WebElement EnterDROprPassword;
	
	@FindBy(id="DROprToken_Session")
	public WebElement EnterDROprToken_Session;
	
	@FindBy(id="DRconnectionurl")
	public WebElement EnterDRconnectionurl;
	
	@FindBy(id="DRProxyIp")
	public WebElement EnterDRProxyIp;
	
	@FindBy(id="DRProxyPort")
	public WebElement EnterDRProxyPort;
	
	@FindBy(id="DrBilCancelURL")
	public WebElement EnterDRBilCancelURL;
	
	@FindBy(id="DrBilResendURL")
	public WebElement EnterDRBilResendURL;
	
	@FindBy(id="DrOprCancelURL")
	public WebElement EnterDROprCancelURL;

	@FindBy(id="DrOprResendURL")
	public WebElement EnterDROprResendURL;
	
	@FindBy(id="DRIsActive")
	public WebElement SelectDRIsActive;
	
	@FindBy(id="DRWCFOperator")
	public WebElement ChooseDRWCFOperator;
	
	@FindBy(id="MakerRemark")
	public WebElement EnterRemark;
	
	@FindBy(id="btnSaveStep3")
	public WebElement ClickOnSave3;
	
	@FindBy(id="btnClearStep3")
	public WebElement ClickOnClear3; 
	
	@FindBy(xpath="//div[@id='GenericPopUp']/div/div[2]")
	public WebElement getOnSaveErrorMsg;
	
	@FindBy(xpath="//div[@class='modal-body'][contains(text(),'Error ! Privious request pending for Checker Approval')]")
	public WebElement getOnSaveCheckerErrorMsg;
	
	@FindBy(xpath="//div[@class='modal-body'][contains(text(),'Record Successfully Added for STEP - 3 and sent for Checker Approval')]")
	public WebElement verifyOnSaveSuccessMsg3;
	
	@FindBy(xpath="//div[@class='modal-body']")
	public WebElement onSaveMakerGenericMsg;
	
	
	///-- STEP PAGE REPOSITORY
	
	@FindBy(xpath="//span[contains(text(),'STEP 1 - Service Details')]")
	public WebElement StepPage1;

	@FindBy(xpath="//span[contains(text(),'STEP 2 - Service Provider Services Details')]")
	public WebElement StepPage2;
	
	@FindBy(xpath="//span[contains(text(),'STEP 3 - Operator URL Configuration')]")
	public WebElement StepPage3;
	
	@FindBy(xpath="//span[contains(text(),'STEP 4 - Service Provider Response Code Upload')]")
	public WebElement StepPage4;
	
	@FindBy(xpath="//*[@src='/FEESCRM/Content/images/LogoutIcon.png']")
	public WebElement ClickLogout;
	
	
	////-----CHECKER VIEW
	
	@FindBy(xpath="//*[text()='Biller Configuration ONUS Checker']")
	public WebElement OnClickVerifyMode;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement EnterSearchText;
	
	@FindBy(xpath="//*[text()='View']")
	public List<WebElement> clickOnView;
	
	@FindBy(xpath="//tbody/tr/td[3]")
	public WebElement ListOfBillerId;
	  
	@FindBy(xpath="//tbody/tr/td[4]")
	public WebElement ListOfServiceCode;

	@FindBy(xpath="//tbody/tr/td[5]")
	public WebElement ListOfServiceProviderName;

	@FindBy(xpath="//tbody/tr/td[6]")
	public WebElement ListOfServiceProviderCode;

	@FindBy(xpath="//tbody/tr/td[7]")
	public WebElement ListOfSubServiceProviderCode;

	@FindBy(xpath="//tbody/tr/td[8]")
	public WebElement ListOfSubServiceProviderName;
	
	@FindBy(xpath="//tbody/tr/td[1]")
	public WebElement ListOfViewButton;
	
	
	// CHECKER TABLE- FIELD ALL DATA
	
	@FindBy(xpath="//div[@id='CheckerTable2']/div/div/div/div[3]/div[2]/table[@id='CheckerReportData2']/tbody/tr/td[2]")
	public List<WebElement> checkerTableColumn2FieldValues;
	

	@FindBy(xpath="//div[@id='CheckerReportData2_paginate']/span/a")
	public List<WebElement> TotalPageCountCheckerTbl;

	@FindBy(xpath="//div[@id='CheckerReportData2_wrapper']")
	public WebElement CheckerTableView_2;
	
	
	// Checker action
	
	@FindBy(id="btnApprove")
	public WebElement ClickOnApprove;
	
	@FindBy(id="btnReject")
	public WebElement ClickOnReject;
		
	@FindBy(id="txtChecker")
	public WebElement CheckerRemarks;
	
	@FindBy(xpath="//div[@id='CheckerPopUp']/div/div[2]")
	public WebElement CheckerAlertMsg;
	
	@FindBy(xpath="//button[@onclick='ApproveRejectInfoClose();']")
	public WebElement CheckerModalInfoClosed;
	
}




