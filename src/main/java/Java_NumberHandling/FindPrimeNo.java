package Java_NumberHandling;

public class FindPrimeNo {

	public static void main(String[] args) {
		
		int n=22;
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
			System.out.println(n +" : Prime Number");
		}
		
		else 		{
			System.out.println(n +" : Not a Prime Number");
		}
	}
}
