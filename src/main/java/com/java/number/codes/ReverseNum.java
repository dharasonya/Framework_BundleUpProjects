package com.java.number.codes;

public class ReverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=123456890;
		
		System.out.println("\n Before Reverse : "+n);
		getReverse(n);
		//System.out.println("\n After Reverse : "+);

	}

	public static void getReverse(int n)
	{	
		String num=String.valueOf(n);
		String rev="";
		
		//System.out.println(num.length());
		for(int i=num.length()-1;i>=0;i--)
		{
			rev=rev+num.charAt(i);
		}
		System.out.println(rev);
		
	}
}
