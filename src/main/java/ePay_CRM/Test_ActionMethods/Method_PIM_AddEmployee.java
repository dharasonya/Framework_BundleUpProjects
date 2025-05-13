package ePay_CRM.Test_ActionMethods;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair; 
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_OrangeHRM_BaseSteps;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Reusable_Utils.ScrollHandler;
import ePay_CRM.Reusable_Utils.WaitUtils;
import ePay_CRM.Test_PageObjects.Repo_PIM;
import ePay_CRM.WrapMethods.WrapperMethods;
import ePay_CRM.Reusable_Utils.CommonLogger;

public class Method_PIM_AddEmployee extends BasePageSetup{

	Repo_PIM obj;
	WebDriver driver;
	int count=0;
	int errCount=0;
	Method_OrangeHRM_BaseSteps baseStep=null;
	int retryCount=0;
	int addRetryCheck=0;
	CallListeners event=new CallListeners();
	WaitUtils wait;
	int counter=0;
	ScrollHandler scroll;
	WrapperMethods action;
	//CommonLogger commonLogger=new CommonLogger();
	static Logger logger = Logger.getLogger("Method_PIM_AddEmployee");
	 //Set<String> fieldValues;

	 Set<String> fieldValuesCopy;
	 
	public Method_PIM_AddEmployee(WebDriver driver) throws Exception {
		//	super(driver);
		this.driver=driver;
		obj =new Repo_PIM(driver);	
		baseStep=new Method_OrangeHRM_BaseSteps(driver);
		wait=new WaitUtils(driver);
		scroll=new ScrollHandler(driver);
		action=new WrapperMethods(driver);
	}  
	
	public void UploadProfilePic() throws AWTException, InterruptedException, UnsupportedFlavorException, IOException
	{
		CommonLogger.log("Initiated the process of filling in details on Page 1.");
		action.clickOnButtonAndVerify(obj.clickOnAddButton, "Add Button");

		System.out.println("--profile pic---");
		action.clickOnButtonAndVerify(obj.clickOnUploadButton, "Upload Profile Image");
		
		/*Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", obj.clickOnUploadButton);
		*/
		CommonLogger.log("Upload File Selection Dialog Opened");
		
		// Copy file path to clipboard
	    StringSelection filePathSelection = new StringSelection("C:\\Users\\sonya\\OneDrive\\Pictures\\profiledummy.jpg");
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(filePathSelection, null);

	    // Explicit Wait to ensure clipboard is set
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7));
	    wait.until(driver -> clipboard.getContents(null) != null);

	    // Verify clipboard content
	    Transferable contents = clipboard.getContents(null);
	    if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	        String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);
	        System.out.println("Clipboard contains: " + clipboardText);
	    } else {
	        System.out.println("Clipboard update failed or unsupported format.");
	    }

	   action.uploadFileUsingRobot("C:\\Users\\sonya\\OneDrive\\Pictures\\profiledummy.jpg");

	   // Assert that the image is displayed
	   
	   action.VerifyElement_EnabledDisable(obj.UploadImageFlag, "Uploaded Image Flag Status");
	   
		
	   CommonLogger.log("File Selection Completed");
		
		Thread.sleep(3000);
		

	}
	
	public void AddEmployee(String EmployeeFullName,String MiddleName,String LastName, String LoginDetailsFlag,String Username,
			String Status,String Password, String ConfirmPassword) throws Exception {
		
		//CommonLogger.log("Initiated the process of filling in details on Page 1.");
		//action.clickOnButtonAndVerify(obj.clickOnAddButton, "Add Button");
		action.enterAndVerify(obj.FirstName, EmployeeFullName, "FirstName");
		action.enterAndVerify(obj.MiddleName, MiddleName, "MiddleName");
		action.enterAndVerify(obj.LastName, LastName, "LastName");
		//action.enterAndVerify(obj.EmployeeId, EmployeeId, "EmployeeId");
		action.enableToggleSwitchAndVerify(obj.enableDisableCreateLoginDetails, LoginDetailsFlag, "LoginDetailsFlag");
		action.enterAndVerify(obj.enterUserName, Username, "Username");
		if(Status.equalsIgnoreCase("Disabled"))
		{
			action.selectEnableDisabledFlagAndVerify(obj.SelectDisabledFlag, Status, "Status",obj.getDisabledAttribute.getText());	
		}
		else if(Status.equalsIgnoreCase("Enabled"))
		{
			action.selectEnableDisabledFlagAndVerify(obj.SelectEnabledFlag, Status, "Status",obj.getEnabledAttribute.getText());	
		}
		action.enterAndVerify(obj.enterPassword, Password, "Password");
		action.enterAndVerify(obj.enterConfirmPassword, ConfirmPassword, "ConfirmPassword");
		event.printSnap("Employee Details Added");
		CommonLogger.log("The process of adding employee details has been completed.");
	}
	
	public void EmployeeDetails(String EmployeeName,String MiddleName,String LastName,String OtherId,String DriverLicenseNumber,
			String LicenseExpiryDate, String Nationality, String MaritalStatus, String DateOfBirth, String Gender, String BloodType,String TestField)
	{
		System.out.println("----- EMPLOYEEE DETAILS-----Otherid : "+OtherId);
	
		

		
		action.getAttributeValue(obj.FirstName, EmployeeName, "FirstName");
		action.getAttributeValue(obj.MiddleName, EmployeeName, "MiddleName");
		action.getAttributeValue(obj.LastName, EmployeeName, "LastName");
		action.enterAndVerify(obj.EnterOtherId, OtherId, "OtherId");
		//action.enterAndVerify(obj.EnterDriverLicenseNumber, DriverLicenseNumber, "DriverLicenseNumber");
	//	action.enterAndVerify(obj.SpecifyLicenseExpiryDate, LicenseExpiryDate, "LicenseExpiryDate");
	//	action.enterAndVerify(obj.SpecifyLicenseExpiryDate, LicenseExpiryDate, "LicenseExpiryDate");

		
		
		
	}
	
	
	public void VerifyMenuName(String MenuName)
	{
			}
	
	public boolean clickOnSaveButton() throws Exception {
		
		
		action.clickOnButtonAndVerify(obj.clickOnSave, "On Save");
		boolean flag=false;
		
		String onSaveNewExpMsg="Success";	
		try
		{
			String ExpectedMsg=action.getTextAndVerify(obj.OnSaveSuccessMessage_1, "On Save Success");
			if(onSaveNewExpMsg.contains(ExpectedMsg))
			{
				Assert.assertTrue(onSaveNewExpMsg.contains(ExpectedMsg));
				flag=true;
				//getLog().info((obj.OnSaveSuccessMessage_1).getText());
				event.printSnap("CRM Save Success Msg");
			}
			/*else if(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()))
			{
				Assert.assertTrue(onSaveDupExpMsg.equals(obj.ResponseMsg.getText()),"On Duplicate Save Sucess Msg Verifcation");
				getLog().info(obj.ResponseMsg.getText());
				event.printSnap("CRM Save Duplicate Msg");
			}*/
		}
		catch(Exception e)
		{
			CommonLogger.log("Unable to Save Records due to error occured");
		}
		return flag;
	}
	
	public int FieldError(String Password, String ConfirmPassword) throws Exception
	{
		List<String> errList=new ArrayList<String>();
		SoftAssert softAssert=new SoftAssert();
		errCount=0;	
		List<WebElement> errorMsg=obj.OnSaveValidationErrors;
		String errorMsgText = null;
		if(errorMsg.size()!=0)
		{	
			for(WebElement ErrList:errorMsg)
			{
				errCount++;
				errorMsgText=ErrList.getText();
				errList.add(errorMsgText);				
				//event.fullprintSnap("Maker Screen ErrorMsg "+errCount);
				CommonLogger.log("Error Count :"+errCount+" / Error Message : "+ErrList.getText());
				
				//this.validatePageFieldError(errorMsgText);	
			}
		}
		else{
			CommonLogger.log("Any Error Messages on Save/Update : "+errCount);
			errCount=0;
		}
		CommonLogger.log("Total Count : Error Messages: "+errCount);
		this.validatePageFieldError(Password,ConfirmPassword);	
		return errCount;
	}

	@SuppressWarnings("restriction")
	private void validatePageFieldError(String Password, String ConfirmPassword) {
	   
	    Map<String, List<String>> ValidFieldValuePair = new HashMap<>();
	    Set<String> fieldCopy=new HashSet<>();
	    String expectedErrorMsg ;
	    boolean validatedFlag=false;
	    
	    @SuppressWarnings("restriction")
		Map<WebElement, Pair<String, List<String>>> fieldValidationMap = new LinkedHashMap<>();
	    fieldValidationMap.put(obj.FirstName, new Pair<>("First Name", Arrays.asList("Required")));
	    fieldValidationMap.put(obj.LastName, new Pair<>("Last Name", Arrays.asList("Required")));
	 // fieldValidationMap.put(obj.EmployeeIdError, new Pair<>("Employee_Id", Arrays.asList("Required","Should be at least 5 characters")));
	    
	    try
	    {
	    	 fieldValidationMap.put(obj.enterUserName, new Pair<>("Username", Arrays.asList("Username already exists","Required","Should be at least 5 characters")));
	    }
	    catch(Exception e)
	    {
	    	 fieldValidationMap.put(obj.enterUserNameError, new Pair<>("Username", Arrays.asList("Username already exists","Required","Should be at least 5 characters")));

	    }
	   	fieldValidationMap.put(obj.enterPassword, new Pair<>("Password", Arrays.asList("Required","Should have at least 7 characters")));
	    fieldValidationMap.put(obj.enterConfirmPassword, new Pair<>("Confirm Password", Arrays.asList("Passwords do not match")));

	    for (Map.Entry<WebElement, Pair<String, List<String>>> entry : fieldValidationMap.entrySet()) {
	        WebElement field = entry.getKey();
	        String fieldName = entry.getValue().getKey();
	        List<String> validationMessages = entry.getValue().getValue();
	        String attributeValue = action.getAttributeValue(field, "value", fieldName);
	        
	        // Skip already validated fields
	        if (fieldCopy.contains(fieldName)) {
	            continue;
	        }
	        // Define expected error messages based on conditions
	        if(!fieldName.equals("Confirm Password"))
	        {
	        	expectedErrorMsg = getExpectedErrorMessage(fieldName, attributeValue);
	        }
	        else
	        {
	        	expectedErrorMsg = getExpectedPasswordErrorMessage(Password, ConfirmPassword);
	        }
	         // If validation triggers, store and log it
	        if (expectedErrorMsg != null && validationMessages.contains(expectedErrorMsg)) {
	            ValidFieldValuePair.put(fieldName, validationMessages);
	            fieldCopy.add(fieldName);
	            CommonLogger.log("*** Validation Occurred for Field **: " + fieldName + " / ErrorMessage: " + expectedErrorMsg);
	            validatedFlag=true;
	            Assert.assertTrue(true,"Validation Error Message Verification");   
	        } 
	    }

	}
	// Method to determine the expected error message dynamically
	private String getExpectedErrorMessage(String fieldName, String attributeValue) {
	    if (attributeValue.isEmpty()) { 
	        return "Required"; // Simplified
	    } else if (fieldName.equals("Username") && attributeValue.length() < 5) {
	        return "Should be at least 5 characters";
	    } else if (fieldName.equals("Password") && attributeValue.length() < 7) {
	        return "Should have at least 7 characters";
	    }
	    return null;
	}
	
	private String getExpectedPasswordErrorMessage(String password, String confirmPassword) {
	 
		if (!password.equals(confirmPassword)) { 
	        return "Passwords do not match"; // Returns error message if passwords don't match
	    }
	    return null; // Returns null if passwords match (no error)
	}
			
	public void PersonalDetails(String EmployeeFullName,String MiddleName, String LastName,String OtherId
		,String DrivingLicenseNumber,String LicenseExpiryDate,String Nationality,String MaritalStatus,
		String DateOfBirth,String Gender, String BloodType, String TestField)
	{
		CommonLogger.log("Initiated the process of filling in details on Page 2-PersonalDetails");
		
		action.getAttributeValue(obj.FirstName, "value","FirstName");
		action.getAttributeValue(obj.MiddleName, "value","MiddleName");
		action.getAttributeValue(obj.LastName, "value","LastName");
		action.enterAndVerify(obj.EnterOtherId, "1223", "OtherId");
		action.enterAndVerify(obj.EnterDriverLicenseNumber, "290190021", "Driver License Number");
		action.enterAndVerify(obj.SpecifyLicenseExpiryDate, "2020-01-12", "License Expiry Date");
		action.selectValueAndVerify(obj.SelectNationality, Nationality, "Nationality");
		action.selectValueAndVerify(obj.SelectMaritalStatus, MaritalStatus, "MaritalStatus");
		action.selectValueAndVerify(obj.DateOfBirth, DateOfBirth, "DateOfBirth");
		action.selectValueAndVerify(obj.SelectGender, "Male", "Gender");
		action.clickOnButtonAndVerify(obj.clickOnSavePersonalDetails, "On-SavePersonalDetails");
		
		event.printSnap("Employee Details Added");
		CommonLogger.log("The process of adding Personal details has been completed.");
	}
	
	public void SaveData()
	{
		action.clickOnButtonAndVerify(obj.clickOnSave, "On Save");
		//return false;
	}
	
	
}