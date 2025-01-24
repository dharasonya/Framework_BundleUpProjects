package Java_Array;

import java.util.ArrayList;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CompareArrays {

	public static void main(String[] args) {
		
		Integer[] a1 = {11,2,3,5,2,1};
		Integer[] a2 = {1,22,4,25};
		Integer[] a3 = {1,22,3,5,4};
		int counter=0;
		boolean flag=false;
		
		List<Integer> dupArrayList=new ArrayList<Integer>();
		
		for(int i=0;i<a1.length;i++)
		{
			//System.out.println("\n------A1 LOOP-----"+a1[i]);
			for(int j=0;j<a2.length;j++)
			{
				if(a1[i]==a2[j])
				{
					for(int k=0;k<a3.length;k++)
					{
						if(a3[k]==a2[j] && a3[k]==a1[i] && !dupArrayList.contains(a3[k]))
						{
							//System.out.println(a3[k]);
							dupArrayList.add(a3[k]);
							counter++;
						}
					}	
				}
			
			}
		}
		
		if(counter>1)
		{
			flag=true;
			System.out.println("\n List of Dupicate List : "+dupArrayList);
			System.out.println("\n Arrays contains duplicate No. :"+flag);
			
		}
		else
		{
			System.out.println("\n Arrays contains duplicate No. :"+flag);
		}
		
		
		
	}
}
