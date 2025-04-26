package ePay_CRM.Reusable_Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	 WebDriver driver;

	    // Constructor
	    public WaitUtils(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	 // Explicit Wait for an element to be clickable
	    public WebElement waitForElementToBeClickable(By by, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.elementToBeClickable(by));
	    }
	    
	    public WebElement waitForElementToBeClickableByWebElement(WebElement element, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public List<WebElement> waitForListOfElementToBeVisible(WebElement webElement, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	    }
	    

	    public List<WebElement> waitForListOfAllElementsToBeVisible(List<WebElement> selectServiceCode, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.visibilityOfAllElements(selectServiceCode));
	    }
	    
	    public WebElement waitForElementToBeVisible(WebElement webElement, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.visibilityOf(webElement));
	    }
	   
	    //elementToBeClickable
	    
	    public WebElement waitforelementToBeClickable(WebElement webElement, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
	    }
	   
	    // Fluent Wait for an element with polling
	    public WebElement fluentWaitForElement(WebElement webElement, int timeout, int polling) {
	        Wait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(timeout))
	                .pollingEvery(Duration.ofSeconds(polling))
	                .ignoring(NoSuchElementException.class);
	        return wait.until(ExpectedConditions.visibilityOf(webElement));
	    }
	    
	    public Alert waitForAlertIsPresent(int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.alertIsPresent());
	    }

	    
	    public boolean waitForInvisibility(WebElement webElement, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.invisibilityOf(webElement));
	    }
	    
	    // ADDED NEWLY WAITs
	    
	    public WebElement waitForvisibilityOfElementLocatedBy(By value, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(value));
	    }
	    
	   
}

