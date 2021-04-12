package exp10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginEdge {

public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\Administrator\\Downloads\\Compressed\\edgedriver_win64/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
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
