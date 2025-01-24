package Java_StringHandling;

public class Reverse_String_NotWords {

	public static void main(String[] args) {
		
		String name="My name is Sonyarani Dhara";
		String nameArr[]=name.split(" ");
		
		//OP : Dhara Sonyarani is name My
		
		for(int i=nameArr.length-1;i>=0;i--)
		{
			System.out.print(nameArr[i]);
			System.out.print(" ");
		}
		
	}
}
