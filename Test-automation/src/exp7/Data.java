package exp7;

import org.testng.annotations.DataProvider;

public class Data {
	
    @DataProvider(name="loginsuccess")
	public static Object[][] login()
	{
		Object[][] a=new Object[2][2];
		
		a[0][0]="hello@gmail.com";
		a[0][1]="hellohello";
		
		a[1][0]="hello1@gmail.com";
		a[1][1]="hellohello";
				
		
		return a;
	}
    
    
	

}
