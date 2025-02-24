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
	
	@FindBy(id="ValidateAmountFlag")
	public WebElement SelectValidateAmountFlag; 
	
	@FindBy(id="FetchRequirement")
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
	
	@FindBy(xpath="//div[@id='GenericPopUp']/div/div[2][@class='modal-body']")
	//(xpath="//div[@class='modal-body'][contains(text(),'Record Successfully Added for STEP - 1')]")
	public WebElement verifyOnSaveSuccessMsg1;

	// WEBELEMENTS FOR STEP -2
	
	@FindBy(id="SPField1")
	public WebElement EnterSPField1; 
	
	@FindBy(id="SPField2")
	public WebElement EnterSPField2; 
	
	@FindBy(id="SPField3")
	public WebElement EnterSPField3; 
	
	@FindBy(id="SPField4")
	public WebElement EnterSPField4; 
	
	@FindBy(id="SPField5")
	public WebElement EnterSPField5; 

	@FindBy(id="SPField6")
	public WebElement EnterSPField6; 
	
	@FindBy(id="SPField7")
	public WebElement EnterSPField7; 

	@FindBy(id="SPField8")
	public WebElement EnterSPField8; 
	
	@FindBy(id="SPField9")
	public WebElement EnterSPField9; 
	
	@FindBy(id="SPField10")
	public WebElement EnterSPField10; 
	
	@FindBy(id="IsQuickPay")
	public WebElement ChooseQuickPay; 

	@FindBy(id="ValidateAmountFlag")
	public WebElement ChooseValidationFlag; 
	
	@FindBy(id="AmountFlag")
	public WebElement ChooseAmountFlag; 
	
	@FindBy(id="IsMappedResCode")
	public WebElement ChooseIsMappedResCode; 
	
	@FindBy(id="btnSaveStep2")
	public WebElement ClickOnSave2; 
	
	@FindBy(id="btnClearStep2")
	public WebElement ClickOnClear2; 
	
	@FindBy(xpath="//div[@id='dvInfo']/button[@onclick='InfoClose();']")
	public WebElement clickOnClose;
	
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
	
	@FindBy(xpath="//div[@class='modal-body'][contains(text(),'Record Successfully Added for STEP - 3 and sent for Checker Approval')]")
	public WebElement verifyOnSaveSuccessMsg3;
	
}
