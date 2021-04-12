package exp6;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_signin {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{  System.setProperty("webdriver.gecko.driver", "/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
	 driver=new FirefoxDriver();
	 driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();		
	}
		

	@AfterTest
	public void closing()
	{
	   driver.quit();	
	}
	
	
	@Test(priority=1)
	public void test1()
	{
	    WebElement signin=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    assertEquals(signin.getText(),"Hello, Sign in");
	    assertTrue(signin.isDisplayed());
	    assertTrue(signin.isEnabled());
	    signin.click();
	        		
	}
	
	@Test(priority=2)
	public void test2()
	{
		WebElement email=driver.findElement(By.id("ap_email"));
		assertTrue(email.isDisplayed());
		assertTrue(email.isEnabled());
	    email.sendKeys("hello@gmail.com");
	  
	}
	

	@Test(priority=3)
	public void test3()
	{
		  
	    WebElement button=driver.findElement(By.id("continue"));
	    assertEquals("Continue",button.getText());
	    assertTrue(button.isDisplayed());
	    assertTrue(button.isEnabled());
	    button.click();
	}
	
	@Test(priority=4)
	public void test4()
	{

		WebElement passw=driver.findElement(By.id("ap_password"));
	    assertTrue(passw.isDisplayed());
	    assertTrue(passw.isEnabled());
	    passw.sendKeys("hellohello");	    
	}
	
	
	@Test(priority=5)
	public void test5()
	{

	    WebElement button1=driver.findElement(By.id("signInSubmit"));
	    assertTrue(button1.isDisplayed());
	    assertTrue(button1.isEnabled());
	    button1.click();
	}

}
