package Java_StringHandling;

import java.util.ArrayList;

public class PrintUniqueString {

	public static void main(String[] args) {
		
		String name="Hi Automation Testing";
		System.out.println(printUnique(name));
		
	}

	private static String printUnique(String name) {
		// TODO Auto-generated method stub
		String unqName="";
		String tempName=name.toLowerCase();
		ArrayList<String> arrList=new ArrayList<String>();
		
		int counter=1;
		for(int i=0;i<tempName.length();i++)
		{
			for(int j=i+1;j<tempName.length();j++)
			{
				if(String.valueOf(tempName.charAt(i)).equals(String.valueOf(tempName.charAt(j))) && !arrList.contains(String.valueOf(name.charAt(i))))
				{
					counter++;
				}
			}
			if(counter>1 && !arrList.contains(String.valueOf(tempName.charAt(i))))
			{
				//System.out.println("\n------counter ----:"+tempName.charAt(i));
				arrList.add(String.valueOf(tempName.charAt(i)));
			}
			
			if(!arrList.contains(String.valueOf(tempName.charAt(i))))
			{
				unqName=unqName+tempName.charAt(i);
			}
			
			counter=1;
		}
		System.out.println("arrList : "+arrList);
		
		return unqName;
	}
}
