package Java_StringHandling;

public class Reverse_EvenPositionWords {

	public static void main(String[] args) {
		
		String name="My name is Sonyarani Dhara";
		String nameArr[]=name.split(" ");
		int temp=0;
		String rev="";
		
		for(int i=0;i<nameArr.length;i++)
		{
			String tempName=nameArr[i];
			temp++;
			if(temp%2==0)
			{
				for(int j=tempName.length()-1;j>=0;j--)
				{
					rev=rev+tempName.charAt(j);
				}
			}
			else
			{
				rev=rev+" "+nameArr[i]+" ";
			}
		}
		
		System.out.println(rev.trim());
	}
}
