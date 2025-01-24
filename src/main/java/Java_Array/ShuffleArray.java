package Java_Array;

import java.util.Random;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ShuffleArray {

	public static void main(String[] args) {
		
		
		int arr[]= { 1, 2, 3, 4, 5, 6, 7 };
		
		Random rand=new Random();
		
		for(int i=0;i<arr.length;i++)
		{
			int randomIndexSwap=rand.nextInt(arr.length);
			int temp=arr[randomIndexSwap];
			arr[randomIndexSwap]=arr[i];
			arr[i]=temp;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
