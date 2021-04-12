package exp6;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_search {

WebDriver driver;
	
    @BeforeTest
	public void setup()
	{  System.setProperty("webdriver.gecko.driver", "/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
	   driver=new FirefoxDriver();
	   driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
		

	
	@Test(priority=1)
	public void test1()
	{
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 9 (Sporty Orange, 4GB RAM, 128GB Storage)");
	    
	    WebElement search=driver.findElement(By.id("nav-search-submit-button")); 
		assertTrue(search.isEnabled());
		assertTrue(search.isEnabled());
	    search.click();
	}
	
	
	
	@Test(priority=2)
	public void test2()
	{
		WebElement phone= driver.findElement(By.linkText("Redmi 9 (Sporty Orange, 4GB RAM, 128GB Storage)"));	    
	    String ph=phone.getText();                                      //phone on first page
	    assertTrue(ph.contains("Redmi 9"));		
		assertTrue(phone.isDisplayed());
		phone.click();		
	}
	

	@Test(priority=3)
	public void test3()
	{
		ArrayList<String> no=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(no.get(1));                               //switching to 2nd window
		try {  Thread.sleep(3000);}
		catch(Exception e)
		{System.out.println("test case failed");}		
		
	}
	
	
	@Test(priority=4)
	public void test4()
	{
		WebElement price=driver.findElement(By.cssSelector("#priceblock_ourprice"));         //checking price
		assertEquals("₹ 9,999.00",price.getText());
		assertFalse(price.isSelected());
		
	}
	

	@Test(priority=5)
	public void test5()
	{
		WebElement image=driver.findElement(By.id("landingImage"));                     //checking image
		assertNotNull(image);
		
	}
	

	@Test(priority=6)
	public void test6()
	{
		WebElement cart=driver.findElement(By.id("add-to-cart-button"));           //checking add to cart button
		assertNotEquals("submit.add",cart.getText());
		
	}
		
	
	@AfterTest
	public void closing()
	{
	   driver.quit();	
	}
	
	
}
