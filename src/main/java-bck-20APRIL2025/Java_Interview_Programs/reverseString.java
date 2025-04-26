package Java_Interview_Programs;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="Welcome to Automation Testing World";

		System.out.println("\n Oringal String : "+name);
		// World Testing Automation to Welcome

		String tempName[]=name.split(" ");
		String revWord="";
		String revString="";

		String tempValue;
		for(int j=tempName.length-1;j>=0;j--)
		{
			revWord = revWord+tempName[j]+ " ";
		}

		System.out.println("\n Reverse String (only words) : "+revWord.trim());
		for(int i=0;i<tempName.length;i++)
		{
			tempValue=tempName[i];
			for(int j=tempName[i].length()-1;j>=0;j--)
			{
				
				revString=revString+String.valueOf(tempValue.charAt(j));
			}
			revString=revString+" ";
		}

		System.out.println("\n Reverse String (with reverse Words : "+revString.trim());


	}
	}
