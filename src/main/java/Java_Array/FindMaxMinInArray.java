package Java_Array;

import edu.emory.mathcs.backport.java.util.Arrays;

public class FindMaxMinInArray {

	static int temp;

	static int min;

	static int max;

	static int secondHighest;

	static int secondLowest;
	public static void main(String[] args) {
		int arr[]= {-1,10,30,2,12,120,456,234,675};
		
		System.out.println(Arrays.toString(arr));
		
		getMin(arr);
		getMax(arr);
		getSecondHighest(arr);
		getSecondLowest(arr);
		
		
	}

	private static void getSecondLowest(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			min=arr[arr.length-arr.length];
		}
		System.out.println("\n Loweset Number in array :"+min);
	}

	private static void getSecondHighest(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
			secondHighest=arr[arr.length-2];
		}
		System.out.println("\n Second Largest Number in array :"+secondHighest);
	}

	private static void getMax(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
			max=arr[arr.length-1];
		}
		System.out.println("\n Largest Number in array :"+max);
	}

	private static void getMin(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			secondLowest=arr[arr.length-arr.length+1];
			
		}
		System.out.println("\n Second Minimum Number in array :"+secondLowest);
	}
	
	
}
