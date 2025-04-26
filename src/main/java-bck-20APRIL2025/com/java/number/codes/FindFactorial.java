package com.java.number.codes;

public class FindFactorial {

	public static void main(String[] args) {
		
		
		int n=6;
		System.out.println("\n Factorial of "+n+" : "+findFactorialNum(n));
	}
	
	public static int findFactorialNum(int n)
	{
		int fact=1;
		for(int i=n;i>0;i--)
		{
			fact=fact*i;  //5*4=20//
		}
		return fact;
		
	}
}
