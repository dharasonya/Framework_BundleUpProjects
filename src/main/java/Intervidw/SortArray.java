package Intervidw;

import edu.emory.mathcs.backport.java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {

		String name="My name is Sonyarani Dhara";
		String output="Ym name si Sonyarani arahD";
		
		String finalName="";
		int temp=0;
		String tempName="";

		String nameArr[]=name.split(" ");

		for(int i=0;i<nameArr.length;i++)
		{
		//	System.out.println("\n Outer Word : "+nameArr[i]);
			temp++;
			tempName=nameArr[i];
			if(temp%2!=0)
			{

				for(int j=tempName.length()-1;j>=0;j--)
				{
					finalName=finalName+tempName.charAt(j);
				}
			}	
			else
			{
				for(int k=0;k<tempName.length();k++)
				{
					finalName=finalName+tempName.charAt(k);
				}

			}

			finalName=finalName+" ";

		}

		System.out.println("\n final name : "+finalName.trim());	
	}
}





/*int temp;
int arr[]={90,89,1,10,70,60,5};

for(int i=0;i<arr.length;i++)
{
	for(int j=i+1;j<arr.length;j++)
	{
		if(arr[i]<arr[j]) // 90 >89
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
}
System.out.println(Arrays.toString(arr));*/
