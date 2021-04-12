package exp11;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Extreport {

	static ExtentReports report;
	static ExtentTest testclass;
	
	WebDriver driver;

	
	@BeforeTest
	public void drivers()
	{
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
	    driver=new FirefoxDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void initializeReport()
	{
		report=new ExtentReports("/root/Music/extreports.html");
	}
	
	@BeforeMethod
	public void StartReport(Method result)
	{
	    testclass=report.startTest(result.getName());	
	}
	
	
	
	@Test(priority=1)
	public void SiginButton()
	{
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	
		if(driver.findElement(By.id("ap_email"))!=null )
		{testclass.log(LogStatus.PASS, "successfully clicked sigin button");}
		
		else
		{testclass.log(LogStatus.FAIL, "Failed to click sigin button");}
	}
	
	
	@Test(priority=2)
	public void EnterEmail()
	{
		driver.findElement(By.id("ap_email")).sendKeys("hello@gmail.com");
	
		if(driver.findElement(By.id("ap_email")).getText()!=null)
		{testclass.log(LogStatus.PASS, "E-mail entered successfully");}
		
		else
		{testclass.log(LogStatus.FAIL, "Failed to enter the e-mail");}
		
		
		
		
	}
	
	@Test(priority=3)
	public void ContinueButton()
	{
		driver.findElement(By.id("continue")).click();
	
		if(driver.findElement(By.id("ap_password"))!=null)
		{testclass.log(LogStatus.PASS, "successfully clicked continue button");}
		
		else
		{testclass.log(LogStatus.FAIL, "Failed to click continue button");}
		

	}
	
	
	@Test(priority=4)
	public void EnterPassw()
	{
		driver.findElement(By.id("ap_password")).sendKeys("hellohello");
	
		if(driver.findElement(By.id("ap_password")).getText()!=null)
		{testclass.log(LogStatus.PASS, "password entered successfully");}
		
		else
		{testclass.log(LogStatus.FAIL, "Failed to enter the password");}
		
		
	}
	
	
	@Test(priority=5)
	public void LoginButton()           
	{
		driver.findElement(By.id("signInSubmit")).click();
	    String name=driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();  
		
	    if(!(name.equals("Hello, Sign in")))
		{testclass.log(LogStatus.PASS, "Login successfully");}
		
		else
		{testclass.log(LogStatus.FAIL, "Failed to Login");}
	    
	   
	}
	
	
	
	@AfterClass
	public void closingReport()
	{
		report.endTest(testclass);
		report.flush();
	}
	
	@AfterTest
	public void closing()
	{
		driver.quit();
	}
	
	
}
