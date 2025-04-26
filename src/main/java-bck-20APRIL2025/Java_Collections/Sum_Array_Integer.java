package Java_Collections;

import java.util.ArrayList;

public class Sum_Array_Integer {

	
	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		arr.add(10);
		arr.add(20);
		arr.add(40);
		arr.add(30);
		arr.add(50);
		
		int sum=0;
		for(int i=0;i<arr.size();i++)
		{
			sum=sum+arr.get(i);
		}
		System.out.println(sum);
	}
	
}
