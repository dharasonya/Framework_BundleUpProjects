package Java_Interview_Programs;

import java.util.ArrayList;
import java.util.List;

public class AnyProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int arr[]= {1,2,3,4,5,6,7,8,9};
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%2==0)
			{
				System.out.println("\n Even Number : "+arr[i]);
			}
			else
			{
				System.out.println("\n Odd Number : "+arr[i]);
			}
		}*/
		
		
		/*List<Integer> num=new ArrayList<Integer>();
		
		num.add(2);
		num.add(4);
		num.add(13);
		num.add(0);
		num.add(9);
		for(int i=0;i<num.size();i++)
		{
			if(num.get(i)%2==0)
			{
				System.out.println("\n list : "+num.get(i));
			}
		}*/
		
		
		// Check number is prime or not
		/*int num=17;
		int counter=0;
		for(int i=1;i<=num;i++)
		{
			if(num%i==0)
			{
				counter++;
			}
			else
			{
				counter=0;
			}
		}
		
		if(counter==2)
		{
			System.out.println("\n Prime Number : "+num);
		}
		else
		{
			System.out.println("\n Not a prime number :"+ num);
		}
	}*/
	//Print Fibonacci series
	
	int a=0,b=1,c=0;
	
	System.out.print(a+"\t");
	System.out.print(b+"\t");
	
	for(int i=1;i<=10;i++)
	{
		c=a+b;
		System.out.print(c+"\t");
		a=b;
		b=c;
		
		
		
	}
	}
}
