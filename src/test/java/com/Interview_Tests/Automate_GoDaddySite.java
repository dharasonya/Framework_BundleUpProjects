package com.Interview_Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Automate_GoDaddySite {

	
	WebDriver driver;
	
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void printPageTitle()
	{
		System.out.println("\n Get the Title of the page and print it. :"+driver.getTitle());
		System.out.println("\n Get the URL of the page and print it. :"+driver.getCurrentUrl());
	//	System.out.println("\n Get the PageSource of the page and print it. :"+driver.getPageSource());
	}
	
	@Test(priority=2)
	public void Validate_PageTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
	}
	
	@Test(priority=3)
	public void Validate_Automate_the_first_menulink()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> listOfMenuLink=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@data-cy='primary-nav-tray-menu-item']")));
		
		System.out.println(listOfMenuLink.size());
		
		for(WebElement listOfMenus:listOfMenuLink)
		{
			if(listOfMenus.getText().equals("Domains"))
			{
				listOfMenus.click();
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				WebElement subLink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Search for Domain Names']")));
				subLink.click();
				
			
				WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-cy='domain-search']")));
				System.out.println("\n Get attribute : "+searchBox.getAttribute("data-cy"));
				Assert.assertEquals(searchBox.getAttribute("data-cy"), "domain-search");
				break;
				
			
				
			}
		}
		
		
		@Test(priority=4)
		public void Validate_Automate_all_menulink()
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			List<WebElement> listOfMenuLink=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@data-cy='primary-nav-tray-menu-item']")));
			
			System.out.println(listOfMenuLink.size());
			
			for(WebElement listOfMenus:listOfMenuLink)
			{
				if(listOfMenus.getText().equals("Domains"))
				{
					listOfMenus.click();
					wait=new WebDriverWait(driver,Duration.ofSeconds(10));
					WebElement subLink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Search for Domain Names']")));
					subLink.click();
				
					Assert.assertEquals(driver.getTitle(), "Search & Buy Available Domains - Register a Domain with GoDaddy");
					driver.navigate().back();
					
				
					
				}
			}
		//	driver.findElements(By.xpath("//li[@data-cy='primary-nav-tray-menu-item']"));
		
		
			
	}
		
	
	
	
	
	@AfterTest
	public void browserTearDown()
	{
		driver.quit();
	}
}
