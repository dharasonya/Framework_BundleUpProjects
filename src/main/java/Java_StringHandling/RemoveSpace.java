package Java_StringHandling;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class RemoveSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="My name is Sonyarani Dhara";
		
		System.out.println("\n Before Removing Space : "+name);

		System.out.println("\n After Removing Space : "+afterRemoveSpace(name));
	}

	private static String afterRemoveSpace(String name) {
		// TODO Auto-generated method stub
		String newName="";
		for(int i=0;i<name.length();i++)
		{
			
			if(String.valueOf(name.charAt(i)).equals(" "))
			{
				newName=newName+String.valueOf(name.charAt(i)).replace(" ", "");
			}
			else
			{
				
				newName=newName+name.charAt(i);
			}
				
			
		}
		
		
		return newName;
	}

}
