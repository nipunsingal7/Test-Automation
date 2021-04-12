package Project;

import org.testng.annotations.DataProvider;

public class Dataclass {

	
@DataProvider(name="forgotpasswd")	
public static Object[][] Data()
{
	Object[][] obj= new Object[2][1];
	
	obj[0][0]="hello@gmail.com";
	obj[1][0]="rajatkp11@gmail.com";
	
	return obj;
}

	
	
	
}
