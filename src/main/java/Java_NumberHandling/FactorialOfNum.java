package Java_NumberHandling;

public class FactorialOfNum {

	public static void main(String[] args) {
		
		System.out.println(findFact(5));
	}

	private static int findFact(int num) {
		// TODO Auto-generated method stub
		
		int fact=1;
		
		for(int i=1;i<=num;i++)
		{
			fact=fact*i;//1//1*2=2//2*3=6//6*4=20//2*5=120
		}
		return fact;
	}
	
}
