package Java_NumberHandling;

public class ReverseNumber {

	public static void main(String[] args) {
		
		int n=123456789;
		
		int rev=0;
		System.out.println("\n Before Reverse : "+n);
		
		while(n>0)
		{
			rev=rev*10+n%10;
			n=n/10;
		}
			
		System.out.println("\n After Reverse : "+rev);
	}
}
