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

public class Testng_register {

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
	{	  driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	      WebElement register=driver.findElement(By.id("createAccountSubmit"));
	      assertEquals(register.getText(),"Create your Amazon account");
	      assertTrue(register.isDisplayed());
		    assertTrue(register.isEnabled());
		   register.click(); 
}
	
	@Test(priority=2)
	public void test2()
	{
		WebElement name=driver.findElement(By.id("ap_customer_name"));
		assertTrue(name.isDisplayed());
	    assertTrue(name.isEnabled());
	    name.sendKeys("nipun");
	    
	}
	
	@Test(priority=3)
	public void test3()
	{
	   WebElement phone=driver.findElement(By.id("ap_phone_number"));
	   assertTrue(phone.isDisplayed());
	    assertTrue(phone.isEnabled());
	    phone.sendKeys("1111222234");
	}

	
	@Test(priority=4)
	public void test4()
	{
		 WebElement email=driver.findElement(By.id("ap_email"));
		 assertTrue(email.isDisplayed());
		    assertTrue(email.isEnabled());
		    email.sendKeys("nipun112233@gmail.com");
	}
	
	@Test(priority=5)
	public void test5()
	{
		 WebElement pass=driver.findElement(By.id("ap_password"));
		 assertTrue(pass.isDisplayed());
		    assertTrue(pass.isEnabled());
		    pass.sendKeys("nipun123");
	}
	
	@Test(priority=6)
	public void test6()
	{
		 
	    WebElement button=driver.findElement(By.id("continue"));
	    assertTrue(button.isDisplayed());
	    assertTrue(button.isEnabled());
	    button.click();
	}
	
	
	
    
    
    
   
    
   
   
	
}
