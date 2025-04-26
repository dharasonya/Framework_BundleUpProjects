package BundleUp.Bundle_Automation_Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.awt.Window;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestTask {

	WebDriver driver;
	
	@Test
	public void LaunchBrowser()
	{
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		
		driver=new FirefoxDriver();
		
		driver.get("https://epaysit.eftapme.com/FEESCRM/");
		System.out.println("hi0-1");
		
		

		
		/*WebElement username=driver.findElement(By.id("strUserId"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='sdhara'",username);
		
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		
		js.executeScript("arguments[0].click()", loginBtn);
		
		
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");*/
		
		
	}
	
	
	
}
