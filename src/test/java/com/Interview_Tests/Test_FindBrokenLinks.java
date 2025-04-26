package com.Interview_Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_FindBrokenLinks {

	WebDriver driver;
	ArrayList<String> linkArray=new ArrayList<String>();
	
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		//Assert.assertTrue(driver.getTitle().equals("Practice Page"));
		
	}
	
	@Test
	public void FindBrokenLinksTest() throws Exception
	{
		List<WebElement> linkList=driver.findElements(By.tagName("a"));
		
		for(WebElement linkValues:linkList)
		{
			String urlLink=linkValues.getAttribute("href");
			
			try
			{
				URL url=new URL(urlLink);
				
				HttpURLConnection con=(HttpURLConnection) url.openConnection();
				
				con.setConnectTimeout(5000);
				
				con.connect();
				
				if(con.getResponseCode()==200)
				{
					System.out.println(urlLink+" - Working Link");
				}	
				else
				{
					System.out.println(urlLink+" - Not a Working Link");
				}
			}
			
			catch(Exception e)
			{
				System.out.println("\n Not a Valid URL :"+urlLink);
			}
			
		}
		
		System.out.println("--------LIST OF BROKEN LINKS-------"+linkArray);
	
	}

	//@AfterTest
	public void tearDownBrowser()
	{
		driver.quit();
	}
}
