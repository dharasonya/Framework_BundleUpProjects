package Intervidw;

import org.testng.annotations.Test;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TestClass_ExceptionHandling {

	@Test(priority=1,enabled=false)
	public void ExceptionHandledinCatchBlock()
	{
		int a=10;
		int b=0;
		try
		{
			int c=a/b;
			
		}
		catch(Exception e)
		{
			System.out.println("Airthmetic Exception occured");
		}
		
		
	}
	@Test(priority=2,enabled=false)
	public void ManuallyThrowException()
	{
		int a=10;
		int b=20;
		int c;
		
		if(a<b)
		{
			//throw (new ArithmeticException());
			System.out.println("Correct");
		}
			
			
		
		
	}
	
	@Test(priority=3,enabled=true)
	public void CustomizedException() throws Exception
	{
		int i;
		
		
		System.out.println(i);
		
		
		/*if(a<b)
		{
			Exception ex=new Exception("Incorrect input");
			throw ex;
		}
			*/
		int Integer=10;
		char String='I';
		System.out.println(Integer + " : "+String);
				
				
		
		
	}
}
