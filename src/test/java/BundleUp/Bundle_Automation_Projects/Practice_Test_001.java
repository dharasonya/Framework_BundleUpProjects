package BundleUp.Bundle_Automation_Projects;

import org.testng.annotations.Test;

public class Practice_Test_001 {

	@Test
	public void Value()
	{
		String temp="Mobile Recharge-(MR)";
		String tempName[]=temp.split("-");
		
		for(String values:tempName)
		{
			System.out.println(values.replace("(", "").replace(")", ""));
		}
		
	}
	
}
