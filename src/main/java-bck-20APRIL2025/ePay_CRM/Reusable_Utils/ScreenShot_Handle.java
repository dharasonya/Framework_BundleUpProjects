package ePay_CRM.Reusable_Utils;

import java.io.File;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ePay_CRM.LandingPage.BasePageSetup;

public class ScreenShot_Handle extends BasePageSetup{

	public String ScreenshotPath;
	Date date;
	String dateSplit[]=null;
	Random rnd = new Random();
	int RefID = 100000 + rnd.nextInt(900000);   
	WebDriver driver;
	
	public ScreenShot_Handle(WebDriver driver)
	{
		this.driver=driver;
	}

	String newDateFormat;
	public String TakeScreen(String fileName) throws Exception
	{ 
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String DestinationScreenshotPath="C:/Users/sonya/eclipse-workspace/Bundle_Automation_Projects/CRM_Screenshots";
		ScreenshotPath=System.getProperty("user.dir")+"/CRM_Screenshots/"+RefID+"_"+fileName+".jpeg";
		File destinationFile=new File(ScreenshotPath);
		FileUtils.copyFile(src,destinationFile);
		//System.out.println("\n Screenshot taken on Path :"+ScreenshotPath);
		
		return ScreenshotPath;
		
	}
}
