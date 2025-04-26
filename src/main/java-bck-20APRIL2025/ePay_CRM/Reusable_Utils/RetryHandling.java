package ePay_CRM.Reusable_Utils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryHandling implements IRetryAnalyzer {
	int count=0;
	int maxRetry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxRetry)
		{
			System.out.println("Retry Attempt made");
			count++;
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
