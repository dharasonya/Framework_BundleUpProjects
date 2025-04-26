package com.java.number.codes;

public class FindPrimeNumber {

	public static void main(String[] args) {
		
		int n=9;
		System.out.println("\n Check if its a prime Number :"+findPrime(n));
	}

	private static boolean findPrime(int n) {
		// TODO Auto-generated method stub
		
		int counter=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				
				counter++;
			}
			
		}
		if(counter==2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
