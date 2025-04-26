package ePay_CRM.Test_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repo_AirtelDataCenterMigration {

	WebDriver driver;
	public Repo_AirtelDataCenterMigration(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
		  this.driver=driver;
	}
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[1]")
	public List<WebElement> Maker_Grid_DataCenter;
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[2]")
	public List<WebElement> Maker_Grid_DebitAccount;
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[3]")
	public List<WebElement> Maker_Grid_SourceOrigin;
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[4]")
	public List<WebElement> Maker_Grid_UserName;
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[5]")
	public List<WebElement> Maker_Grid_ServiceUrl;
	
	@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[6]")
	public List<WebElement> Maker_Grid_StatusUrl;
	
	
	@FindBy(xpath="//*[@id='btnUpdate']")
	//@FindBy(xpath="//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr/td[7]/button")
	public WebElement clickOnEditButton;
	//public List<WebElement> Maker_Grid_EditButton;
	
	@FindBy(id="//*[text()='Airtel DataCentre Migration']")
	public WebElement MakerScreenLabel;
	
	@FindBy(xpath="//*[@id='DataCentre']")
	public WebElement PreDefinedDataCenter;
	
	@FindBy(id="DebitAccount")
	public WebElement EnterDebitAccount;
	
	@FindBy(id="SourceOrigin")
	public WebElement EnterSourceOrigin;
	
	@FindBy(id="OprUserName")
	public WebElement EnterOprUserName;
	
	@FindBy(id="OprServiceUrl")
	public WebElement EnterOprServiceUrl;
	
	@FindBy(xpath="//textarea[@name='MakerRemark']")
	public WebElement EnterMakerRemark;
	
	@FindBy(id="OprStatusUrl")
	public WebElement EnterOprStatusUrl;
	
	@FindBy(xpath="//*[text()='Airtel DataCentre Migration Edit']")
	public WebElement MakerEditMenuName;
	
	@FindBy(xpath="//*[@class='field-validation-error']")
	public List<WebElement> ListOfValidationError;
	
	@FindBy(id="btnSubmit")
	public WebElement clickOnSaveButton;
	
	@FindBy(xpath="//*[text()='Reset']")
	public WebElement Reset;
	
	@FindBy(xpath="//*[text()='Back']")
	public WebElement BackButton;
	
	@FindBy(xpath="//*[@id='AlertMessageOPUrl']")
	public WebElement OnSaveMessage;
	
	@FindBy(xpath="//*[@src='/FEESCRM/Content/images/LogoutIcon.png']")
	public WebElement ClickLogout;
	
	@FindBy(xpath="//button[@id='btnVerify']")
	public WebElement ClickOnVerifyButton;
	
	@FindBy(xpath="//*[text()='Airtel Datacenter Migration Checker']")
	public WebElement OnClickVerifyMode;
	
	
	//-----------------OBJECT REPOSITIORY FOR CHECKER GRID-----------------
	
	@FindBy(xpath="//tbody/tr/td[3]")
	public WebElement Col_DataCenter;
	
	@FindBy(xpath="//tbody/tr/td[4]")
	public WebElement Col_DebitAccount;
	
	@FindBy(xpath="//tbody/tr/td[5]")
	public WebElement Col_SourceOrigin;
	
	@FindBy(xpath="//tbody/tr/td[6]")
	public WebElement Col_UserName;
	
	@FindBy(xpath="//tbody/tr/td[7]")
	public WebElement Col_ServiceUrl;
	
	@FindBy(xpath="//tbody/tr/td[8]")
	public WebElement Col_StatusUrl;
	
	@FindBy(xpath="//*[@id='btnApprove']")
	public WebElement ClickOnApprove;
	
	@FindBy(xpath="//*[@id='btnReject']")
	public WebElement ClickOnReject;
	
	@FindBy(id="txtChecker")
	public WebElement CheckerRemarks;
	
	@FindBy(id="ResponseMsg")
	public WebElement CheckerAlertMsg;
	
	// BAL WALLETS - SWITCH GRID
	
	@FindBy(id="EnvUpdate")
	public WebElement btn_BALWallet_Update;
	
	@FindBy(id="EnvUpdateNew")
	public WebElement btn_BHLWallet_Update;

	@FindBy(xpath="//table[@id='AirtelDetails']/tbody/tr/td[1]")
	public List<WebElement> Get_BAL_ListOfEnviornments;
	
	@FindBy(xpath="//table[@id='AirtelDetailsNew']/tbody/tr/td[1]")
	public WebElement Get_BHL_ListOfEnviornments;
	
	@FindBy(xpath="//table[@id='AirtelDetails']/tbody/tr/td[2]")
	public WebElement current_BAL_Wallets;
	
	@FindBy(xpath="//table[@id='AirtelDetails']/tbody/tr/td[3]")
	public WebElement switch_To_BAL_Wallets;
	
	@FindBy(xpath="//table[@id='AirtelDetailsNew']/tbody/tr/td[2]")
	public WebElement current_BHL_Wallets;
	
	@FindBy(xpath="//table[@id='AirtelDetailsNew']/tbody/tr/td[3]")
	public WebElement switch_To_BHL_Wallets;
	
	
	// BHL WALLETS - SWITCH GRID
	
	 // Locator for the button
    public By getButtonLocator(int counter) {
        return By.xpath("//table[@id='AirtelDataCetreMigrationData']/tbody[1]/tr[" + counter + "]/td[7]/button");
    }
    
   // Locator for the button
    public By getCheckboxValue(int counter) {
        return By.xpath("//tbody/tr["+counter+"]/td[1]/input");
    }
    
    public WebElement getBal_CurrentEnviornment(int counter)
    {
    	return  driver.findElement(By.xpath("//table[@id='AirtelDetails']/tbody/tr["+counter+"]/td[1]"));
    }
    
    public WebElement getBal_Current_DataCentre(int counter) {
        return driver.findElement(By.xpath("//table[@id='AirtelDetails']/tbody/tr[" + counter + "]/td[2]"));
    }
    
    public WebElement getBal_Switch_DataCentre(int counter) {
        return driver.findElement(By.xpath("//table[@id='AirtelDetails']/tbody/tr[" + counter + "]/td[3]"));
    }

    
  
	
	
	

}
