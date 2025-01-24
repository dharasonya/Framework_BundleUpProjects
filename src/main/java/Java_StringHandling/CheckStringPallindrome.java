package Java_StringHandling;

public class CheckStringPallindrome {

	public static void main(String[] args) {
		
		System.out.println("\n Madam :"+checkPallindrome("madam"));
		System.out.println("\n apple :"+checkPallindrome("apple"));
		System.out.println("\n mom :"+checkPallindrome("Moms"));
	}

	private static boolean checkPallindrome(String str) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		String rev="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		
		if(str.equalsIgnoreCase(rev))
		{
			flag=true;
		}
		
		else
		{
			flag=false;
		}
		return flag;
	}
	
}
