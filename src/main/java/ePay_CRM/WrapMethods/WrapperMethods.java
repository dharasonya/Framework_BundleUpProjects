package ePay_CRM.WrapMethods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ePay_CRM.LandingPage.BasePageSetup;
import ePay_CRM.Reusable_Utils.CommonLogger;
import ePay_CRM.Reusable_Utils.WaitUtils;

public class WrapperMethods extends BasePageSetup {

	WebDriver driver;
	WaitUtils wait;
	public WrapperMethods(WebDriver driver)
	{
		this.driver=driver;
		wait=new WaitUtils(driver);	
	}

	public void enterAndVerify(WebElement element, String value, String fieldName) {

		try
		{
			wait.waitForElementToBeVisible(element, 30);
			element.sendKeys(value);
			Assert.assertEquals(element.getAttribute("value"), value, "Verify " + fieldName);	
			CommonLogger.log("Field :"+fieldName+" is Entered & Verified.");
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
		}
	}

	public void enterAndSelectServiceCode(WebElement element,List<WebElement> listElement, String value, String fieldName) throws Exception {
		try
		{
			wait.waitForElementToBeVisible(element, 30);
			element.sendKeys(value);
			wait.waitForListOfAllElementsToBeVisible(listElement, 10);	
			for (WebElement serviceCodeValue : listElement) {
				String tempServiceCode = serviceCodeValue.getText().split("-")[1].replace("(", "").replace(")", "");
				if (tempServiceCode.equalsIgnoreCase(value)) {
					serviceCodeValue.click();
					
					CommonLogger.log("Field :"+fieldName+" is Selected & Verified.");
					break;
				}
			}
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
		}
	}

	public void clickOnCheckboxAndVerify(WebElement element, String value, String fieldName) {
		try
		{
			wait.waitforelementToBeClickable(element, 30);
			if(value.equalsIgnoreCase("1") && !element.isSelected())
			{
				element.click();
				Assert.assertTrue(element.isSelected(), "Verify : "+fieldName);
				CommonLogger.log("Field :"+fieldName+" is Selected & Verified.");
			}
			else
			{
				Assert.assertFalse(element.isSelected(), "Verify : "+fieldName);
				CommonLogger.log("Field :"+fieldName+" is Not Selected & Verified.");
			}
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
		}
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), value, "Verify " + fieldName);
	}

	public void selectActiveFlagAndVerify(WebElement element, String value, String FieldName) {
		try {
			Select select = new Select(element);
			if (value.equals("1")) {
				select.selectByValue("true");
				Assert.assertTrue(element.getAttribute("value").equals("true"), "Verify " + FieldName + " is selected");
				CommonLogger.log("Field :"+FieldName+" is Selected & Verified.");
			} else {
				select.selectByValue("false");
				Assert.assertFalse(element.getAttribute("value").equals("false"), "Verify " + FieldName + " is selected");
				CommonLogger.log("Field :"+FieldName+" is not Selected & Verified.");
			}
		} catch (Exception e) {
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
		}
	}

	public void selectValueAndVerify(WebElement element, String value,String FieldName) {

		try
		{
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Assert.assertEquals(select.getFirstSelectedOption().getText(),value.toUpperCase(), "Verify "+FieldName+" is selected");
			CommonLogger.log("Field :"+FieldName+" is Selected & Verified.");
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
		}
	}
	
	/*public String getTextAndVerify(WebElement element,String FieldName) {

		String value="";
		try
		{
			value=wait.waitForElementToBeVisible(element, 3).getText();
			Assert.assertNotNull(value, "Verify "+FieldName+" is retrieved");
			CommonLogger.log("For Field :"+FieldName+" Text Value :"+value+" is Retrieved & Verified.");
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);	
			//CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.errorLog(e);
		}
		return value;
	}*/
	public String getTextAndVerify(WebElement element, String FieldName) throws Exception {
	    String value = "";

	    try {
	        value = wait.waitForElementToBeVisible(element, 3).getText();
	        Assert.assertNotNull(value, "Verify " + FieldName + " is retrieved");
	        CommonLogger.log("For Field :" + FieldName + " Text Value :" + value + " is Retrieved & Verified.");
	    } catch (Exception e) {
	        //CommonLogger.errorLog(e);
	    	//CommonLogger.log("Runtime Exception occured !!!..");
	        throw new Exception("Error retrieving text for field: " + FieldName, e);
	    }
	    
	    return value;
	}

	public void clickOnButtonAndVerify(WebElement element, String fieldName)
	{
		try
		{
			wait.waitforelementToBeClickable(element, 15);
			element.click();
			CommonLogger.log("Field :"+fieldName+" is Clicked & Verified.");
		}
		catch(Exception e)
		{
			//getLog().info("RunTime Exception Occurred: " + element+" - "+e);	
			//CommonLogger.log("RunTime Exception Occurred: " + element+" - "+e);
			CommonLogger.errorLog(e);
		}
		
	}

	public String getAttributeValue(WebElement element, String attribute) {
        
		String value="";
		
		try{
			wait.waitForElementToBeVisible(element, 5);
			value=element.getAttribute(attribute);
			CommonLogger.log("For Attribute :"+attribute+"attribute Value :"+value+" is Retrieved & Verified.");
		}
		catch(Exception e)
		{
			getLog().info("RunTime Exception Occurred: " + element+" - "+e);	
		}
		return value;
    }


}



