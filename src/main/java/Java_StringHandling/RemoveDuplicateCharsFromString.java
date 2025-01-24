package Java_StringHandling;

import java.util.ArrayList;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class RemoveDuplicateCharsFromString {

	public static void main(String[] args) {

		String name="Automattion Tesatintieg";
		removeDuplicate(name);	
	}

	private static void removeDuplicate(String name) {
		// TODO Auto-generated method stub
		int counter=1;
		String newName="";
		String tempName=name.toLowerCase();

		List<String> dupList=new ArrayList<String>();


		for(int i=0;i<name.length();i++)
		{
			for(int j=i+1;j<name.length();j++)
			{
				if(String.valueOf(tempName.charAt(i)).equals(String.valueOf(tempName.charAt(j)))  && !dupList.contains(String.valueOf(tempName.charAt(i))))
				{
					counter++;
				}

			}

			if(counter>1)
			{
				System.out.println("\n Occurence of Word :"+name.charAt(i)+" : "+counter);
				dupList.add(String.valueOf(tempName.charAt(i)));

			}
			if(!dupList.contains(String.valueOf(tempName.charAt(i))))
			{
				newName=newName+tempName.charAt(i);
			}
			counter=1;

		}

		System.out.println("\n List of Duplicate words :"+dupList);
		System.out.println("\n Total Duplicate words :"+dupList.size());
		System.out.println("\n String after Duplicate characters removal : "+newName);

	}
}
