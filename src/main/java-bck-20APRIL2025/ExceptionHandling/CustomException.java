package ExceptionHandling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomException {

	@Test(dataProvider="getData")
	public void Case(int id,String name)
	{
		System.out.println(id +" = "+name);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][]
				{{1,"Sonya"},
				{2,"Ashish"}};
	}
		

}
