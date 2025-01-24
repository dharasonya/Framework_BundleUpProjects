package Java_StringHandling;

public class ReverseNum_GivenString {

	public static void main(String[] args) {
		
		String str="123456";
		String rev="";
		
		System.out.println("\n Before reverse : "+str);
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		
		System.out.println("\n After reverse : "+rev);
	
	}
}
