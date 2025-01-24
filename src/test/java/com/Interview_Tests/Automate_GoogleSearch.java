package com.Interview_Tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_GoogleSearch {

	WebDriver driver;


	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}

	@Test
	public void Automate_Google_Search() throws InterruptedException
	{
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("selenium tutorial");

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 List<WebElement> listSearch = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//ul[@class='G43f7e' and @role='listbox']/li")));
		//
		
		System.out.println("\n Size : "+listSearch.size());

		for(WebElement listSearchValues:listSearch)
		{
			if(listSearchValues.getText().equals("selenium tutorial w3schools"))
			{
				listSearchValues.click();
				Assert.assertEquals(driver.getTitle(), "selenium tutorial w3schools - Google Search","Verification of Title");
				break;
			}
			
			//System.out.println("\n list--"+listSearchValues.getText());
		}


	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}


//