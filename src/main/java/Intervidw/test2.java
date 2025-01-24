package Intervidw;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n Prime Number : "+callPrimeCheck(17));
	}

	private static boolean callPrimeCheck(int n) {
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
