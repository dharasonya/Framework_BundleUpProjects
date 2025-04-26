package Java_StringHandling;

import java.util.ArrayList;
import java.util.List;

public class BreakStepString {

	public static void main(String[] args) {

		List<String> stepList=new ArrayList<String>();
		stepList.add("STEP 1 - Service Details");
		stepList.add("STEP 2 - Service Provider Services Details");
		stepList.add("STEP 3 - Operator URL Configuration");

		for(String stepValues:stepList)
		{
			String stepValueBreak[]=stepValues.split(" - ");

			for (int i = 0; i < stepValueBreak.length; i++) {
				if(i==0)
				{
					System.out.println(stepValueBreak[i]);
					
					
				}
				 // Change `get(i)` to `stepValueBreak[i]`
			}
			
			System.out.println("---------------------");
		}

	}
}
