package ePay_CRM.Test_PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repo_EpayPropertyConfig {
  
	
	public Repo_EpayPropertyConfig(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='btnAdd']")
	public WebElement AddButton; 
	
	@FindBy(xpath="//button[@id='btnEdit']")
	public WebElement EditButton; 
	
	@FindBy(xpath="//button[@id='btnView']")
	public WebElement ViewButton; 
	
	@FindBy(xpath="//input[@id='PropertyName']")
	public WebElement EnterApplicationName; 
	
	@FindBy(xpath="//input[@id='Key']")
	public WebElement EnterKey; 
	
	@FindBy(xpath="//textarea[@id='Value']")
	public WebElement EnterValue; 
	
	@FindBy(id="lstActiveStatus")
	public WebElement SelectStatus;
	
	@FindBy(xpath="//textarea[@id='Description']")
	public WebElement EnterDescription; 
	
	@FindBy(xpath="//textarea[@id='MakerRemark']")
	public WebElement EnterRemark; 
	
	@FindBy(id="btnSubmit")
	public WebElement ClickOnSave; 
	
	@FindBy(id="btnSubmit")
	public WebElement ClickOnUpdate; 
	
	@FindBy(id="ResponseMsg")
	public WebElement ResponseMessage; 
	
	@FindBy(linkText="Reset")
	public WebElement ClickOnReset;
	
	@FindBy(linkText="Back")
	public WebElement ClickOnBack;
	
	@FindBy(xpath="//label[contains(text(),'ePay Property File Configuration')]")
	public WebElement MenuHeaderName;

	@FindBy(id="btnView")
	public WebElement ClickOnView;
	
	@FindBy(xpath="//input[@type='search']")
	public WebElement EnterSearchValue;
	
	@FindBy(xpath="//table[@id='BBPSConfigData']/tbody/tr")
	public List<WebElement> TableRowData;
	
	@FindBy(xpath="//table[@id='BBPSConfigData']/tbody/tr/td[3]")
	public List<WebElement> getApplicationNameList;
	
	@FindBy(xpath="//table[@id='BBPSConfigData']/tbody/tr/td[4]")
	public List<WebElement> getKeyList;
	
	@FindBy(xpath="//table[@id='BBPSConfigData']/tbody/tr/td[5]")
	public List<WebElement> getValue;

	@FindBy(xpath="//tr/td[@class='dataTables_empty']")
	public WebElement NoRecordFoundMsg;
	
	@FindBy(xpath="//label[@class='mu-page-header-title']")
	public WebElement OnClickViewLabel;
	
	@FindBy(xpath="//label[@class='mu-page-header-title']/span")
	public WebElement OnClickAddLabel;
	
	@FindBy(id="IsActive")
	public WebElement ActiveFlag;
	
	@FindBy(id="btnSubmit")
	public WebElement ClickOnSubmit;
	
	@FindBy(id="BBPSConfigData_info")
	public WebElement CountOfRecords;
	
	@FindBy(id="btnVerify")
	public WebElement ClickOnVerifyButton;
	
	//"//*[@id='mu-hero']/div/nav/i/img"
	
	
	@FindBy(xpath="//*[@src='/FEESCRM/Content/images/LogoutIcon.png']")
	public WebElement ClickLogout;
	////header/div[1]/nav[1]/i[1]/img[1]
	

	@FindBy(xpath="//span[@class='field-validation-error']")
	public List<WebElement> GetFieldOnSaveError;
	

	@FindBy(xpath="//div[@class='form-horizontal']/div/label")
	public WebElement ViewMenuName;
	
	
	
	
	///--------------------CHECKER CRITIERIA------------------------------------
	
	@FindBy(xpath="//tbody/tr/td[4]")
	public List<WebElement> GetApplicationNameList;
	
	@FindBy(xpath="//tbody/tr/td[5]")
	public List<WebElement> GetDescriptionList;
	
	@FindBy(xpath="//tbody/tr/td[6]")
	public List<WebElement> GetCheckerKeyList;
	
	@FindBy(xpath="//tbody/tr/td[7]")
	public List<WebElement> GetValueList;
	
	@FindBy(id="btnApprove")
	public WebElement ApproveBtn;
	
	@FindBy(id="btnReject")
	public WebElement RejectBtn;
		
	@FindBy(id="txtChecker")
	public WebElement CheckerRemarks;
}
