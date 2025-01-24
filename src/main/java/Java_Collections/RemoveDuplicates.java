package Java_Collections;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		int n[]= {1,2,3,4,5,5,6,7,8,9,2};
		System.out.println(RemoveDuplicates.removeDuplicates(n));
		
		
	}
	private static List<Integer> removeDuplicates(int arr[])
	{
		ArrayList<Integer> uniqueList=new ArrayList<Integer>();
		ArrayList<Integer> dupList=new ArrayList<Integer>();
		
		int counter=1;
		
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=i+1;j<arr.length;j++)
			{
			
				if(arr[i]==arr[j] && !dupList.contains(arr[i]))
				{
					counter++;
				}
				
			}
			
			if(counter==1 && !dupList.contains(arr[i]))
			{
				//System.out.println("----unique coutner----:"+counter+" : "+arr[i]);
				uniqueList.add(arr[i]);
			//	System.out.println("\n Unique list : "+uniqueList);
			}
			else
			{
				dupList.add(arr[i]);
				//System.out.println("\n dup list : "+dupList);
			}
			counter=1;
		}
	
		return uniqueList;
	}
}
