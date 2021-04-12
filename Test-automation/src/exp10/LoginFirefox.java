package exp10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFirefox {

public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.0-win64/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.amazon.in/");
        driver.manage().window().maximize();
        
        WebElement signin=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	    signin.click();
        
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
