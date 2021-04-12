package example;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider(name="nipun")
	
	public static Object[][] login()
	{
		Object[][] a=new Object[2][2];
		
		a[0][0]="mrhello@gmail.com";
		a[0][1]="hellohello";
		
		a[1][0]="mrhello2@gmail.com";
		a[1][1]="hellohello";
	
		
		return a;
	}
	

}
