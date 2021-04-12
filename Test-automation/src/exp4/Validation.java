package exp4;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Validation {

	public static void validate(WebElement test)
	{
		System.out.println("Name: "+test.getText()+"  Displayed:"+test.isDisplayed()+"  Enabled:"+test.isEnabled());
		
	}
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
        WebDriver driver=new FirefoxDriver();
		
        driver.navigate().to("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("ap_email")).sendKeys("hello@gmail.com");
        
        driver.findElement(By.id("continue")).click();
      
        driver.findElement(By.id("ap_password")).sendKeys("hellohello");
       
        driver.findElement(By.id("signInSubmit")).click();
     
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung Galaxy M21 (Midnight Blue, 4GB RAM, 64GB Storage)");
        
        driver.findElement(By.id("nav-search-submit-button")).click(); 
        
        validate(driver.findElement(By.linkText("Samsung Galaxy M21 (Midnight Blue, 4GB RAM, 64GB Storage)")));
        validate(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div/a/span[1]/span[2]/span[2]")));
        validate(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img"))); 
      
        driver.findElement(By.linkText("Samsung Galaxy M21 (Midnight Blue, 4GB RAM, 64GB Storage)")).click();
        
        ArrayList<String> tab= new ArrayList<String>(driver.getWindowHandles());
        System.out.println("No of windows:"+" "+tab.size());
        driver.switchTo().window(tab.get(1));
        
        try {
        Thread.sleep(2000);}
        
        catch(Exception e)
        {System.out.println("error"+" "+e);}
        
        validate(driver.findElement(By.id("productTitle")));
        validate(driver.findElement(By.id("priceblock_ourprice")));
        validate(driver.findElement(By.id("landingImage")));
        validate(driver.findElement(By.id("add-to-cart-button")));
        validate(driver.findElement(By.id("buy-now-button")));
       
        
	}

}
