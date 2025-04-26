package ePay_CRM.Test_PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repo_ServiceProviderRespCodeMapping {
  
	
	public Repo_ServiceProviderRespCodeMapping(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="btnAdd")
	public WebElement btnAdd;
	
	@FindBy(id="btnEdit")
	public WebElement btnEdit;
	
	@FindBy(id="btnView")
	public WebElement btnView;
	
	@FindBy(id="lstNetworkMode")
	public WebElement selectNetworkMode;
	
	@FindBy(id="ServiceProviderName")
	public WebElement EnterServiceproviderName;
	
	@FindBy(xpath="//ul[@id='ui-id-3']/li/div")
	public List<WebElement> SelectServiceProvider;
	
	@FindBy(id="ServiceProviderResponseCode")
	public WebElement EnterServiceProviderResponseCode;
	
	@FindBy(id="EuronetResponseCodeValue")
	public WebElement EnterEuronetResponseCode;
	
	@FindBy(xpath="//ul[@id='ui-id-2']/li/div")
	public List<WebElement> SelectEuronetResponseCode;
	
	@FindBy(id="ResponseAction")
	public WebElement selectResponseAction;
	
	@FindBy(id="ServiceProviderResponseMessage")
	public WebElement EnterServiceProviderResponseMessage;
	
	@FindBy(id="lstActiveStatus")
	public WebElement selectStatus;
	
	@FindBy(name="MakerRemark")
	public WebElement EnterRemark;
	
	@FindBy(id="btnSubmit")
	public WebElement clickOnSaveBtn;
	
	@FindBy(linkText="Back")
	public WebElement clickOnBackBtn;
	
	@FindBy(linkText="Reset")
	public WebElement clickOnReset;
	
	@FindBy(id="ResponseMsg")
	public WebElement ResponseMsg;
	
	@FindBy(xpath="//span[@class='field-validation-error']")
	public List<WebElement> GetFieldOnSaveError;
	
	@FindBy(xpath="//*[@src='/FEESCRM/Content/images/LogoutIcon.png']")
	public WebElement ClickLogout;
	
	
	
	
	///--------------------CHECKER CRITIERIA------------------------------------
	
	@FindBy(id="btnVerify")
	public WebElement ClickOnVerifyBtn;
	
	
	@FindBy(xpath="//*[text()='Service Provider Response Code Configuration Checker']")
	public WebElement OnClickVerifyMode;
	
	@FindBy(xpath="//*[text()='Service Provider Response Code View']")
	public WebElement OnClickViewMode;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']/div[2]/table/tbody/tr/td[4]")
	public List<WebElement> OperatorList;
	
	@FindBy(xpath="//div[@class='dataTables_scroll']/div[2]/table/tbody/tr/td[5]")
	public List<WebElement> OperatorResponseCodeList;

	@FindBy(xpath="//div[@class='dataTables_scroll']/div[2]/table/tbody/tr/td[6]")
	public List<WebElement> EnrspCodeList;
	
	
	@FindBy(xpath="//textarea[@id='txtChecker']")
	public WebElement CheckerRemarks;

	@FindBy(xpath="//input[@id='btnApprove']")
	public WebElement ClickOnApprove;

	@FindBy(xpath="//input[@id='btnReject']")
	public WebElement ClickOnReject;
	
	@FindBy(xpath="//span[@id='ResponseMsg']")
	public WebElement CheckerAlertMsg;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement EnterSearchValue;
	
	@FindBy(id="tblReport_info")
	public WebElement CountOfRecords;
	
	@FindBy(id="btnView")
	public WebElement ClickOnView;
	
	@FindBy(xpath="//a[contains(text(),'Back')]")
	public WebElement ClickOnBack;
	
	@FindBy(xpath="//*[contains(text(),'Service Provider Response Code Mapping')]")
	public WebElement MenuHeaderName;
	

    // Web element for the pagination link
  
}
