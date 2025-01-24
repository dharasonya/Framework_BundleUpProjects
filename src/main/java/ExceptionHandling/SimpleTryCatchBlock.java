package ExceptionHandling;

public class SimpleTryCatchBlock {

	public static void main(String[] args) {
		
		int a=20;
		int b=0;
	
			try
			{
				int c=a/b;
			}
			catch(Exception e)
			{
				System.out.println("Excpetion occured");
			}
	}
}
