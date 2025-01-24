package Java_StringHandling;

public class Reverse_String_SamePostition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="My name is Sonyarani Dhara";
		String nameArr[]=name.split(" ");
		String rev="";
		
		for(int i=0;i<nameArr.length;i++)
		{
			String tempValue=nameArr[i];
			for(int j=tempValue.length()-1;j>=0;j--)
			{
				rev=rev+tempValue.charAt(j);
			}
			rev=rev+ " ";
		}
		
		System.out.println(rev);
	}

}
