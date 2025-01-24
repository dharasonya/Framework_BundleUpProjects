package Java_StringHandling;

import org.checkerframework.common.value.qual.MatchesRegex;

public class CheckVowelInString {

	public static void main(String[] args) {

		System.out.println("\n Hello :"+checkVowel("Hello"));
		System.out.println("\n Automation :"+checkVowel("Automation"));
		System.out.println("\n TV :"+checkVowel("TV"));



	}

	private static boolean checkVowel(String str) {
		// TODO Auto-generated method stub

		boolean flag=false;

		if(str.toLowerCase().matches(".*[aeiou].*"))
		{
			flag=true;
		}
		

		return flag;
	}
}
