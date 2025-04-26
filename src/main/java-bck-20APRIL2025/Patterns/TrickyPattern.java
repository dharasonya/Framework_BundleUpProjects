package Patterns;

public class TrickyPattern {

	public static void main(String[] args) {
		
		int temp=1;
		int maxRows=5;
		
		for(int i=1;i<=5;i++)
		{
		
			for(int j=1;j<=i;j++)
			{
				//System.out.print(j+" ");
				
				if(i==1 & j==1)
				{
					//System.out.println("temp");
					System.out.print(i+" ");
				}
				if(j>1 && j<i)
				{
					//System.out.println("temp2");
					temp=maxRows+temp;
					System.out.print(temp+" ");
					maxRows--;
				}
				else if(j>1)
				{
					System.out.print(j+ " ");
				}
					
				
				
			}
			System.out.println();
		}
	}
}
