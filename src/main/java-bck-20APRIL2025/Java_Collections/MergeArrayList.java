package Java_Collections;

import java.util.ArrayList;
import java.util.List;

public class MergeArrayList {

	public static void main(String[] args) {
		
		
		List<String> l1=new ArrayList<>();
		l1.add("10");
		l1.add("40");
		
		List<String> l2=new ArrayList<>();
		l2.add("30");
		l2.add("20");
		System.out.println(l2);
		
		
		l1.addAll(l2);
		System.out.println(l1);
		
		
		List<String> mergeList=new ArrayList<>(l1);
		mergeList.addAll(l2);
		System.out.println("MergeList : "+mergeList);
	
		
	}
}
