package Java_Collections;

import edu.emory.mathcs.backport.java.util.Arrays;

public class Sort_Array_InAscDesc {

	public static void main(String[] args) {
		
		int arr[]= {10,20,30,3,2,1,-1,-45,-2,201,203};
		
		sortAscendingOrder(arr);
		sortDescendingOrder(arr);
		
		
	
	}

	private static void sortDescendingOrder(int[] arr) {
		// TODO Auto-generated method stub

		int temp;
		
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
		}
		System.out.println("\n Sorted in Ascending order : "+Arrays.toString(arr));
		
	}

	private static void sortAscendingOrder(int[] arr) {
		// TODO Auto-generated method stub

		int temp;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\n Sorted in Descending order : "+Arrays.toString(arr));
		
	}
}
