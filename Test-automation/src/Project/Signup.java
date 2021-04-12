package Project;

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

public class Signup {

	WebDriver driver;	
	static ExtentReports report;
	static ExtentTest testclass; 
	
	
	@BeforeTest
	public void drivers()
	 {    System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.0-win64/geckodriver.exe");
	     driver=new FirefoxDriver();
	     driver.navigate().to("https://www.linkedin.com/");
	     driver.manage().window().maximize();
		
	  }


	@BeforeClass
	public void initializeReport()
	{
		report=new ExtentReports("C:\\Users\\Administrator\\Documents\\SignUpReport.html");
	}


	@BeforeMethod
	public void StartReport(Method result)
	{
	    testclass=report.startTest(result.getName());	
	}
	 
	 
	 @Test(priority=1)
	 public void JoinNowButton()
	  { WebElement button=driver.findElement(By.className("nav__button-tertiary")); 
		
	     boolean display= button.isDisplayed();
	     boolean enable= button.isEnabled();
	     button.click(); 
	  
	    if( display && enable && driver.findElement(By.id("email-or-phone"))!=null )
		{testclass.log(LogStatus.PASS, "Join now button test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Join now button test failed");}
	  
	  }
	  
	  
	 @Test(priority=2)
	  public void SignupEmail()
	  { WebElement signemail=driver.findElement(By.id("email-or-phone"));
		signemail.sendKeys("abcd1221pp@gmail.com"); 
	  
	    if(signemail.isEnabled() && signemail.isDisplayed() && signemail.getText()!=null)
		{testclass.log(LogStatus.PASS, "Signup email test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Signup email test failed");}
	  
	  }
	  
	  
	 @Test(priority=3)
	  public void SignupPassw()       
	  { WebElement signpasswd=driver.findElement(By.id("password"));
	  signpasswd.sendKeys("abcdefghi123"); 
	  
	    if(signpasswd.isEnabled() && signpasswd.isDisplayed() && signpasswd.getText()!=null )
		{testclass.log(LogStatus.PASS, "Signup password test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Signup password test failed");}
	  
	  }

	      
	 @Test(priority=4)
	  public void SignupButton()
	  { WebElement signbutton=driver.findElement(By.id("join-form-submit"));
	  signbutton.click();
	  
	    if(signbutton.isEnabled() && signbutton.isDisplayed() && driver.findElement(By.id("first-name"))!=null )
		{testclass.log(LogStatus.PASS, "Signup button test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Signup button test failed");}
	  
	  }
	  
	  
	 @Test(priority=5)
	  public void SignupName()
	  { WebElement fname=driver.findElement(By.xpath("/html/body/div/main/form/section/div/input[1]"));
	  fname.sendKeys("ABCD"); 
	    
	  WebElement lname=driver.findElement(By.xpath("/html/body/div/main/form/section/div/input[2]"));
	  lname.sendKeys("LAST");
	  
	    if(fname.isEnabled() && fname.isDisplayed() && fname.getText()!=null && lname.isEnabled() && lname.isDisplayed() && lname.getText()!=null)
		{testclass.log(LogStatus.PASS, "Signup First & Last name test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Signup First & Last name test failed");}
	  
	  }
	  
	  
	 @Test(priority=6)
	  public void SignupContinue()
	  { WebElement cbutton=driver.findElement(By.id("join-form-submit"));
	    
	     boolean display3= cbutton.isDisplayed();
	     boolean enable3= cbutton.isEnabled();
	   
	     cbutton.click();
	  
	    if(display3 && enable3 )
		{testclass.log(LogStatus.PASS, "Signup continue button test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Signup continue button test failed");}
	  
	  }
	  
	  
	  @AfterTest
		public void closing()
		{
			driver.quit();
		}
	  
	  @AfterClass
		public void closingReport()
		{
			report.endTest(testclass);
			report.flush();
		}
		
	  
}
