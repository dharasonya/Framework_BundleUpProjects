package Java_NumberHandling;

public class Swap_WOusing3rdVariable {

	public static void main(String[] args) {
		
		int a=10,b=20;
		
		System.out.println("\n ---------Before Swap -------------");
		System.out.println("a :"+a);
		System.out.println("b :"+b);
		
		a=a+b;// 30
		b=a-b;//30-20=10
		a=a-b;//30-10=20;
		
		System.out.println("\n ---------After Swap -------------");
		System.out.println("a :"+a);
		System.out.println("b :"+b);
		
	}
}
