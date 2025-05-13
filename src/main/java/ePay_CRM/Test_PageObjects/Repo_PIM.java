package ePay_CRM.Test_PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Repo_PIM {
	
	public Repo_PIM(WebDriver driver)
	{
		  PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[text()=' Add ']")
	public WebElement clickOnAddButton;
	
	// Add Employee
	@FindBy(name="firstName")
	public WebElement FirstName;
	
	@FindBy(name="middleName")
	public WebElement MiddleName;
	
	@FindBy(name="lastName")
	public WebElement LastName;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	public WebElement EmployeeId;
	
	@FindBy(xpath="//label[@class='oxd-label oxd-input-field-required']")
	public WebElement getLabelName;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active oxd-input--error'])[1]")
	public WebElement EmployeeIdError;
	
	//@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
	@FindBy(xpath="//*[@id='app']//form//label/span")
	public WebElement enableDisableCreateLoginDetails;
	
	@FindBy(xpath="(//*[@class='oxd-input oxd-input--active'])[3]")
	public WebElement enterUserName;
	
	@FindBy(xpath="(//*[@class='oxd-input oxd-input--active oxd-input--error'])[1]")
	public WebElement enterUserNameError;
	
	@FindBy(xpath="//input[@type='radio']")
	public WebElement SelectStatus;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	public WebElement enterPassword;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	public WebElement enterConfirmPassword;
	
	@FindBy(xpath="//button[text()=' Save ']")
	public WebElement clickOnSave;
	
	@FindBy(xpath="//button[text()=' Cancel ']")
	public WebElement clickOnCancel;
	
	@FindBy(xpath="//*[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	public List<WebElement> OnSaveValidationErrors;
	
	@FindBy(xpath="//*[@class='oxd-toast-start']/div[2]/p")
	public WebElement OnSaveSuccessMessage_1;
	
	@FindBy(xpath="(//div[@class='oxd-radio-wrapper']/label/span)[1]")
	public WebElement SelectEnabledFlag;
	
	@FindBy(xpath="(//div[@class='oxd-radio-wrapper']/label/span)[2]")
	public WebElement SelectDisabledFlag;
	
	@FindBy(xpath="(//div[@class='oxd-radio-wrapper']/label)[2]")
	public WebElement getDisabledAttribute;
	
	@FindBy(xpath="(//div[@class='oxd-radio-wrapper']/label)[1]")
	public WebElement getEnabledAttribute;
	
	@FindBy(xpath="//input[contains(@class, 'error')]")
	public List<WebElement> errorFields;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-plus']")
	public WebElement clickOnUploadButton;
	
	@FindBy(xpath="//div[@class='employee-image-wrapper']/img[contains(@src,'data')]")
	public WebElement UploadImageFlag;
	
	// -----PERSONAL DETAILS------
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	public WebElement EnterOtherId;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	public WebElement EnterDriverLicenseNumber;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	public WebElement SpecifyLicenseExpiryDate;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	public WebElement SelectNationality;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	public WebElement SelectMaritalStatus;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	public WebElement DateOfBirth;
	
	@FindBy(xpath="//div[@class='oxd-radio-wrapper']/label/input")
	public WebElement SelectGender;
	
	@FindBy(xpath="(//button[text()=' Save '])[1]")
	public WebElement clickOnSavePersonalDetails;
	
	
	///--------SELECT CUSTOM FIELDS-------
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	public WebElement BloodType;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[7]")
	public WebElement TestField;
	
	@FindBy(xpath="(//button[text()=' Save '])[2]")
	public WebElement clickOnCustomDetails;
	
	
	//--Menu Name
	
	@FindBy(xpath="//h6[text()='Add Employee']")
	public WebElement Menu_AddEmployee;
	
	@FindBy(xpath="//h6[text()='Personal Details']")
	public WebElement Menu_PersonalDetails;
	
	@FindBy(xpath="//h6[text()='Contact Details']")
	public WebElement Menu_ContactDetails;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
