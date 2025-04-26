package Java_StringHandling;

public class Reverse_OddPostionWords {

	public static void main(String[] args) {
		
		String name="My name is Sonyarani Dhara";
		
		int temp=0;
		String rev="";
		String nameArr[]=name.split(" ");
		
		for(int i=0;i<nameArr.length;i++)
		{
			String tempValue=nameArr[i];
			temp++;
			if(temp%2!=0)
			{
				for(int j=tempValue.length()-1;j>=0;j--)
				{
					rev=rev+tempValue.charAt(j);
				}
			}
			else
			{
				rev=rev+" "+nameArr[i]+" ";	
			}
		}
		
		System.out.println("\n Reverse at Odd Postiton :"+rev.trim());
	}
}
