package ePay_CRM.Reusable_Utils;

import java.io.File;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ePay_CRM.LandingPage.BasePageSetup;


///-- ful page screenshot

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

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
	public String takeFullPageScreenshot(String fileName) throws IOException {
        driver.manage().window().maximize();
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(2000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);

        String screenshotPath = System.getProperty("user.dir") + "/CRM_Screenshots/" + fileName + ".jpeg";
        File destinationFile = new File(screenshotPath);
        ImageIO.write(screenshot.getImage(), "JPEG", destinationFile);
        return screenshotPath;
    }
}

       
	


