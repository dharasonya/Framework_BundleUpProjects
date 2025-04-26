package Java_NumberHandling;

public class Print_FibonacciNums {

	public static void main(String[] args) {
		
		int n=10;
		
		int a=0,b=1,c;
		
		System.out.print("\t"+a);
		System.out.print("\t"+b);
		
		for(int i=0;i<=n;i++)
		{
			c=a+b;
			System.err.print("\t"+c);
			a=b;
			b=c;
			
		}
	}
	
}
