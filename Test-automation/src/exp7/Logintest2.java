package exp7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Logintest2 {
	
	
	WebDriver driver;	
	
	@BeforeTest
	public void setup()
	{  System.setProperty("webdriver.gecko.driver", "/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");

	}
		

	 @DataProvider(name="logindata")
		public static Object[][] login()
		{
			Object[][] a=new Object[2][2];
			
			a[0][0]="hello@gmail.com";
			a[0][1]="hellohello";
			
			a[1][0]="hello1@gmail.com";
			a[1][1]="hellohello";
					
			
			return a;
		}

	@Test(dataProviderClass=exp7.Logintest2.class, dataProvider="logindata")
	public void test2(String id,String pass)
	{   
		SoftAssert assert1=new SoftAssert();
	    driver=new FirefoxDriver();
		driver.navigate().to("https://www.amazon.in/");
	    driver.manage().window().maximize();
		
	    WebElement signin=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    assert1.assertEquals(signin.getText(),"Hello, Sign in");
	    assert1.assertTrue(signin.isDisplayed());
	    assert1.assertTrue(signin.isEnabled());
	    signin.click();
	  
	    
		WebElement email=driver.findElement(By.id("ap_email"));
		assert1.assertTrue(email.isDisplayed());
		assert1.assertTrue(email.isEnabled());
	    email.sendKeys(id);
	    
	    WebElement button=driver.findElement(By.id("continue"));
	    assert1.assertEquals("Continue",button.getText());
	    assert1.assertTrue(button.isDisplayed());
	    assert1.assertTrue(button.isEnabled());
	    button.click();

	    WebElement passw=driver.findElement(By.id("ap_password"));
	    assert1.assertTrue(passw.isDisplayed());
	    assert1.assertTrue(passw.isEnabled());
	    passw.sendKeys(pass);
	    
	    WebElement button1=driver.findElement(By.id("signInSubmit"));
	    assert1.assertTrue(button1.isDisplayed());
	    assert1.assertTrue(button1.isEnabled());
	    button1.click();
	    
	   assert1.assertAll();
			
	   driver.quit();
	}


}
