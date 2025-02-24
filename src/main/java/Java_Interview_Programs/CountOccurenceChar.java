package Java_Interview_Programs;

import java.util.ArrayList;
import java.util.List;

public class CountOccurenceChar {

	public static void main(String[] args) {
		
		String name="My name is Sonya";
		int counter=0;
		List<String> dupList=new ArrayList<String>();
		for(int i=0;i<name.length();i++)
		{
			for(int j=i+1;j<name.length();j++)
			{
				if(String.valueOf(name.charAt(j)).equalsIgnoreCase("A") && !dupList.contains(String.valueOf(name.charAt(j))))
				{
					System.out.println("\n enter");
					counter++;
				}
			}
			
			if(counter>0)
			{
				System.out.println("\n ---added----"+name.charAt(i));
				dupList.add(String.valueOf(name.charAt(i)));
			}
			counter=0;
		}
		System.out.println("\n Occurence of char-A : "+counter);
	}
}
