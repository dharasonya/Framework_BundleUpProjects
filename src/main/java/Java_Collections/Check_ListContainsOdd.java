package Java_Collections;

import java.util.ArrayList;
import java.util.List;

public class Check_ListContainsOdd {

	public static void main(String[] args) {
		
		List<Integer> num=new ArrayList<Integer>();
		num.add(10);
		num.add(17);
		num.add(23);
		num.add(30);
		num.add(12);
		num.add(19);
		
		System.out.println(checkOddList(num));
		
		
	}

	private static boolean checkOddList(List<Integer> num) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
	
		
		for(Integer value:num)
		{
			if(value%2!=0)
			{
				flag=true;
			}
		}
		
		return flag;
	}
}
