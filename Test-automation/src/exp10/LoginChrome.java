package exp10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginChrome {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
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
