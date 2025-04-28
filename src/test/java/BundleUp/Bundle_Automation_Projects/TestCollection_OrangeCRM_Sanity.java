package BundleUp.Bundle_Automation_Projects;

import org.testng.annotations.Test;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.LandingPage.Method_CRMBaseSteps;
import ePay_CRM.LoginProcess.Method_LoginWithCredentials;
import ePay_CRM.Test_ActionMethods.Method_SpRspCodeMapping;

public class TestCollection_OrangeCRM_Sanity extends BasePageSetup {

	@Test
	public void Sanity() throws Exception
	{
		Method_LoginWithCredentials login=GetLoginCredentials();
		login.getUrl();

		System.out.println("--- Browser Launched----");
	}
}
