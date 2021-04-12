package Project;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ForgotPassword {

WebDriver driver;
static ExtentReports report;
static ExtentTest testclass; 


	public void drivers()
	 {    System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.0-win64/geckodriver.exe");
	     driver=new FirefoxDriver();
	     driver.navigate().to("https://www.linkedin.com/");
	     driver.manage().window().maximize();
		
	  }

	
	@BeforeClass
	public void initializeReport()
	{
		report=new ExtentReports("C:\\Users\\Administrator\\Documents\\ForgotPwdReport.html");
	}


	@BeforeMethod
	public void StartReport(Method result)
	{
	    testclass=report.startTest(result.getName());	
	}
	
	  
	  @Test(dataProviderClass=Project.Dataclass.class, dataProvider="forgotpasswd")
	  public void ForgotPasswd(String email1) 
	  {
		  drivers();
		  ForgotpasswdLink();
		  ForgotpasswdEmail(email1);
		  ForgotpasswdButton();
		  closing();
		  
		  	  
	  }
	  
	  
	  
	  public void ForgotpasswdLink()
	  { WebElement fplink=driver.findElement(By.className("sign-in-form__forgot-password-link"));
	    
	   boolean display2= fplink.isDisplayed();
	   boolean enable2= fplink.isEnabled();
	   fplink.click();
		  
	    
	  if( display2 && enable2 && driver.findElement(By.id("username"))!=null )
		{testclass.log(LogStatus.PASS, "forgot password link test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "forgot password link test failed");}
		  
	  }
	  
	  
	  
	  public void ForgotpasswdEmail(String email0)
	  {
		  WebElement fpemail=driver.findElement(By.id("username"));
		  fpemail.sendKeys(email0);
		  
		  if(fpemail.isEnabled() && fpemail.isDisplayed() && driver.findElement(By.id("username")).getText()!=null )
			{testclass.log(LogStatus.PASS, "forgot password email test passed");}
			
			else
			{testclass.log(LogStatus.FAIL, "forgot password email test failed");}
		  
	  }
	  
	  
	  
	  public void ForgotpasswdButton()
	  {
		  WebElement fpbutton=driver.findElement(By.id("reset-password-submit-button"));
		   boolean display1= fpbutton.isDisplayed();
		   boolean enable1= fpbutton.isEnabled();
		  
		     fpbutton.click();
		  
		  if(enable1 && display1 )
			{testclass.log(LogStatus.PASS, "forgot password find account button test passed");}
			
			else
			{testclass.log(LogStatus.FAIL, "forgot password find account button test failed");}
		  
	  }
	  

	  
	  
	  
	  
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
