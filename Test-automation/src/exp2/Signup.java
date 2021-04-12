package exp2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Signup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Fhomepage.html%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        driver.manage().window().maximize();
        
        WebElement email=driver.findElement(By.id("ap_email"));
        email.sendKeys("hello@gmail.com");
        
        WebElement button=driver.findElement(By.id("continue"));
        button.click();

        WebElement pass=driver.findElement(By.id("ap_password"));
        pass.sendKeys("hellohello");
        
        WebElement button1=driver.findElement(By.id("signInSubmit"));
        button1.click();
        
	}

}
