package ePay_CRM.LandingPage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePay_CRM.LoginProcess.Method_LoginWithCredentials;
import ePay_CRM.Reusable_Utils.CallListeners;
import ePay_CRM.Test_ActionMethods.Method_AirtelConfiguration;
import ePay_CRM.Test_ActionMethods.Method_BillerConfigOnus;
import ePay_CRM.Test_ActionMethods.Method_EpayPropertyConfig;
import ePay_CRM.Test_ActionMethods.Method_SpRspCodeMapping;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePageSetup {


	WebDriver driver;
	private int count=0;
	protected Properties prop=new Properties();
	protected CallListeners event;

	public CallListeners getEvent() {
		return event;
	}

	public void setEvent(CallListeners event) {
		this.event = event;
	}

	private final Logger log = Logger.getLogger(BasePageSetup.class.getName());
	InputStream input;


	public Logger getLog() {
		return log;
	}

	public WebDriver LoadConfigFile(String BrowserValue) throws Exception
	{
		setCount(count++);
		input=new FileInputStream("./src/main/resources/EnviornmentSetup.properties");
		prop.load(input);  

		switch(BrowserValue.toLowerCase())
		{
		case "chrome" :
		{	
			ChromeOptions options=new ChromeOptions();

			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			setDriver(new ChromeDriver());		
			break;
		}

		case "firefox" :
		{	
			FirefoxOptions options=new FirefoxOptions();
			//WebDriverManager.firefoxdriver().clearDriverCache().setup();
			//WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			//WebDriverManager.firefoxdriver().setup();
			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//addArguments("incognito");
			//options.setAcceptInsecureCerts(true);
			setDriver(new FirefoxDriver());
			//event.setBrowservalue(BrowserValue);
			break;
		}
		case "edge" :
		{	  
			EdgeOptions options=new EdgeOptions();
			//options.addArguments("--headless");
			//options.addArguments("--disable-gpu"); // Optional: Use to disable GPU rendering in headless mode
			//options.addArguments("--window-size=1920,1080"); // Optional: Set window size

			//WebDriverManager.edgedriver().setup();
			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//driver=new EdgeDriver();
			//setDriver(new EdgeDriver(options));
			setDriver(new EdgeDriver());
			break;
		}
		default:
			throw new IllegalArgumentException("Unsupported Browser :- " + BrowserValue);
		}
		getLog().info("Browser Launched :- "+BrowserValue);

		//System.out.println("\n Base browser : "+);

		return getDriver();


	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public WebDriver getDriver() {

		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		event=new CallListeners();
		event.setDriver(getDriver());  


		// Initialize Listeners with driver   
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}




	/*public void getUrl()
	{
		getDriver().manage().window().maximize();
		getDriver().get(getProp().getProperty("URL"));
	}*/

	@Parameters("BrowserValue")
	@BeforeMethod(alwaysRun=true)
	public void BrowserIntilization(String LaunchBrowserValue) throws Exception
	{
		getLog().info("Browser Initilzation Started");
		driver=LoadConfigFile(LaunchBrowserValue);
		event.setBrowservalue(LaunchBrowserValue);

		if (driver == null) {
			throw new IllegalStateException("Driver is not initialized.");
		}

	}

	public Method_LoginWithCredentials GetLoginCredentials() throws Exception
	{
		Method_LoginWithCredentials login=new Method_LoginWithCredentials(driver);
		return login;

	}
	public Method_CRMBaseSteps CRMBaseStep() throws Exception
	{
		Method_CRMBaseSteps step=new Method_CRMBaseSteps(driver); 
		return step;
	}

	public Method_EpayPropertyConfig CRMCoreStep() throws Exception
	{
		Method_EpayPropertyConfig corestep=new Method_EpayPropertyConfig(driver);
		return corestep;
	}  
	public Method_SpRspCodeMapping CRM_SpRspCodeMapping_CoreStep() throws Exception
	{
		Method_SpRspCodeMapping corestep=new Method_SpRspCodeMapping(driver);
		return corestep;  
	}
	public Method_BillerConfigOnus CRM_BillerConfigOnus_CoreStep() throws Exception
	{
		Method_BillerConfigOnus corestep=new Method_BillerConfigOnus(driver);
		return corestep;  
	}
	public Method_AirtelConfiguration CRM_AirtelConfiguration_CoreStep() throws Exception
	{
		Method_AirtelConfiguration corestep=new Method_AirtelConfiguration(driver);
		return corestep;  
	}

	//@Parameters("BrowserValue")
	//@AfterMethod(alwaysRun=true)
	public void TearDown(String BrowserValue)
	{
		if (driver != null) {
			getLog().info("Closing Browser: " + BrowserValue);
			driver.quit();
			driver = null; // Clear driver reference
		}
	}

}


/*
 * FirefoxOptions options=new FirefoxOptions();
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			WebDriverManager.firefoxdriver().setup();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver=new FirefoxDriver();*/
