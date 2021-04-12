package exp5;

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


public class Testing {

	public static void main(String[] args) {
		
	
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
        WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 9 (Sporty Orange, 4GB RAM, 128GB Storage)");
        
        driver.findElement(By.id("nav-search-submit-button")).click(); 
        
        WebElement phone= driver.findElement(By.linkText("Redmi 9 (Sporty Orange, 4GB RAM, 128GB Storage)"));
        
        String ph=phone.getText();                                      //phone on first page
        assertTrue(ph.contains("Redmi 9"));		
		assertTrue(phone.isDisplayed());
		System.out.println("test pass:phone name is verified");
		
		phone.click();
		
	   
		try {  Thread.sleep(4000);}
		catch(Exception e)
		{System.out.println("test case failed");}

					
		ArrayList<String> no=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(no.get(1));                               //switching to 2nd window
		
		
		
		
		WebElement price=driver.findElement(By.cssSelector(".a-size-medium a-color-price priceBlockDealPriceString"));         //checking price
		assertEquals("₹ 9,999.00",price.getText());
		assertFalse(price.isSelected());
		System.out.println("test passed: price is verified");
		
		WebElement image=driver.findElement(By.id("landingImage"));                     //checking image
		assertNotNull(image);
		System.out.println("test passed: image is present"); 
		
		
		WebElement cart=driver.findElement(By.id("add-to-cart-button"));           //checking add to cart button
		assertNotEquals("submit.add",cart.getText());
		System.out.println("test passed: add to cart");
		
		driver.quit();
	
	
	
	
	}

}
