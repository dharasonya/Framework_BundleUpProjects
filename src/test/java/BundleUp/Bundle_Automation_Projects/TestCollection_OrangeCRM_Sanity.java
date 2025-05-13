package BundleUp.Bundle_Automation_Projects;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LoginProcess.Method_OrangeHRM_LoginWithCredentials;
import ePay_CRM.Reusable_Utils.TestReader_ExcelData;
import ePay_CRM.Test_ActionMethods.Method_PIM_AddEmployee;

public class TestCollection_OrangeCRM_Sanity extends BasePageSetup {
	
	@Test(priority=1,dataProvider="ExcelDataProvider",dataProviderClass=TestReader_ExcelData.class,enabled=true)///Working
	public void Sanity(String ... testData) throws Exception
	{
		Method_OrangeHRM_LoginWithCredentials login=GetOrangeHRMLoginCredentials();
		ePay_CRM.LandingPage.Method_OrangeHRM_BaseSteps step=Method_OrangeHRM_BaseSteps();
		Method_PIM_AddEmployee corestep=OrangeHRM_PIM_Admin();
		Map<String, String> testFields = mapTestData(testData);
		
		login.getUrl();
		login.EnterAdminUserName();
		login.EnterAdminUserPassword();
		login.clickOnLoginButton();
		step.SelectMainMenu("PIM");
		corestep.UploadProfilePic();
		
		corestep.AddEmployee(testFields.get("FirstName"),testFields.get("MiddleName"),testFields.get("LastName"),
				testFields.get("CreateLoginDetailsFlag"),testFields.get("UserName"),testFields.get("StatusFlag"),testFields.get("Password"),
				testFields.get("ConfirmPassword"));
	
		
		
		boolean flag=corestep.clickOnSaveButton();
		int errorFlag = corestep.FieldError(testFields.get("Password"),testFields.get("ConfirmPassword"));
		System.out.println("--- RETURN FLAG---:"+flag);
		System.out.println("--- int FLAG---:"+errorFlag);

		if(flag==true && errorFlag==0)
		{
			corestep.EmployeeDetails(testFields.get("FirstName"), testFields.get("MiddleName"),testFields.get("LastName"),
					testFields.get("OtherId"), testFields.get("DriverLicenseNumber"), testFields.get("LicenseExpiryDate"), 
					testFields.get("Nationality"), testFields.get("MaritalStatus"), testFields.get("DateOfBirth"), 
					testFields.get("Gender"), testFields.get("BloodType"), testFields.get("TestField"));
		}
		
		
	
	}
	public static Map<String, String> mapTestData(String[] testData) {
        // Mapping column values dynamically for easier access
        Map<String, String> testMap = new HashMap<>();
        String[] columnNames = {"FirstName",  "MiddleName", "LastName", "CreateLoginDetailsFlag", "UserName",
    			 "StatusFlag","Password", "ConfirmPassword","NickName","OtherId","DriverLicenseNumber",	"LicenseExpiryDate","Nationality",
    			 "MaritalStatus","DateOfBirth",	"Gender","BloodType","Test_Field"
};
        for (int i = 0; i < columnNames.length && i < testData.length; i++) {
            testMap.put(columnNames[i], testData[i]);
        }
        return testMap;
    }	

	
}
