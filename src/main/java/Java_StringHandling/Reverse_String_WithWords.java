package Java_StringHandling;

public class Reverse_String_WithWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="My name is Sonyarani Dhara";
		
		//OP : arahD inaraynoS si eman yM
		String nameArr[]=name.split(" ");
		String rev="";
		for(int i=nameArr.length-1;i>=0;i--)
		{
			String nameValue=nameArr[i];
			for(int j=nameValue.length()-1;j>=0;j--)
			{
				rev=rev+nameValue.charAt(j);
			}
			
			rev=rev+ " ";
		}
		
		System.out.println(rev);
	}

}
