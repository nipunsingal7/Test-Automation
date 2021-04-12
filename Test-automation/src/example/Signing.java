package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signing {

WebDriver driver;	
	
@BeforeTest
public void setVar()
{
	System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver"); 

	
}

@Test(dataProviderClass=example.Data.class,dataProvider="nipun",priority=1)
 public void test1(String id, String pass)
 { 	
	WebDriver driver=new FirefoxDriver();
	driver.navigate().to("https://www.amazon.in/");
    driver.manage().window().maximize();
	
    
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    
	WebElement email=driver.findElement(By.id("ap_email"));
    email.sendKeys(id);
    
    WebElement button=driver.findElement(By.id("continue"));
    button.click();

    WebElement passw=driver.findElement(By.id("ap_password"));
    passw.sendKeys(pass);
    
    WebElement button1=driver.findElement(By.id("signInSubmit"));
    button1.click();
	
    driver.quit();
 }





}
