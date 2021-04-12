package example;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;


public class Testing {
	
	
@Test(successPercentage= 0)
public void test()
{  char a='d';
	int[] b=new int[2];
	//b[2]=5;
	assertNull(null);
 System.out.println("test1 passes");
 assertFalse(true);
 System.out.println("test2 passes");
 

}

@Test(invocationCount= 2000 , invocationTimeOut=1)
public void tests()
{  
	

 System.out.println("testing 1 passes");
 assertFalse(true);
 System.out.println("testing 2 passes");
 

}

@Test()
public void testss()
{ System.out.println("this is normal test" );}

@Test(dependsOnMethods= {"test","tests"})
public void test5()
{ System.out.println("this is depends on method test");}

@Test(alwaysRun=true)
public void test6()
{ System.out.println("this is always run test");}

@Test(enabled =true)
public void test7()
{ System.out.println("this is enabled=true test");}

@Test(enabled =false)
public void test8()
{ System.out.println("this is enable=false test");}


}
