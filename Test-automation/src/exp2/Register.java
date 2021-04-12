package exp2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Register {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Dnav_logo%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	   driver.manage().window().maximize();
	   
	   WebElement name=driver.findElement(By.id("ap_customer_name"));
       name.sendKeys("nipun");
       
       WebElement phone=driver.findElement(By.id("ap_phone_number"));
       phone.sendKeys("1111222234");
       
       WebElement email=driver.findElement(By.id("ap_email"));
       email.sendKeys("nipun112233@gmail.com");
       
       WebElement pass=driver.findElement(By.id("ap_password"));
       pass.sendKeys("nipun123");
       
       WebElement button=driver.findElement(By.id("continue"));
       button.click();
	   
	}

}
