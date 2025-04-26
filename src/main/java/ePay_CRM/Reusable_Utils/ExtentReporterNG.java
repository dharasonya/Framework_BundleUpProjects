package ePay_CRM.Reusable_Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	private static ExtentReports extent;

	public ExtentReports getExtent() {
		return extent;
	}

	public void setExtent(ExtentReports extent) {
		ExtentReporterNG.extent = extent;
	}
	public static ExtentReports getReportObject()

	{
		System.out.println("Extent Report called");

		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy HH-mm-ss");

		Date date=new Date();

		String actualDate=format.format(date);

		//String path=System.getProperty("user.dir")+"/ExtentReports/TestReport_"+CallListeners.getCaseName()+"_"+actualDate+".html";

		String path=System.getProperty("user.dir")+"/ExtentReports/TestReport_"+actualDate+".html";

		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);

		reporter.config().setReportName("Euronet Project Report");

		reporter.config().setDocumentTitle("Automated Test Results");

		reporter.config().setTheme(Theme.STANDARD);

		extent=new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Automation Testing Done By", "Sonyarani Dhara-Sr.Test Engineer");      

		extent.setSystemInfo("Environment", "SIT");          



		return extent;

	}

}
