package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


public class LoginSearch {

WebDriver driver;	
static ExtentReports report;
static ExtentTest testclass; 
FileInputStream stm;
XSSFWorkbook wb;
XSSFSheet sh;


public void drivers()
 {    System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.0-win64/geckodriver.exe");
     driver=new FirefoxDriver();
     driver.navigate().to("https://www.linkedin.com/");
     driver.manage().window().maximize();
	
  }


@BeforeClass
public void initializeReport()
{
	report=new ExtentReports("C:\\Users\\Administrator\\Documents\\LoginSearchReport.html");
}


@BeforeMethod
public void StartReport(Method result)
{
    testclass=report.startTest(result.getName());	
}



  @Test()
  public void Logins() throws IOException{
	  
	  try {
		  stm=new FileInputStream("C:\\Users\\Administrator\\Documents\\data.xlsx"); 
		  wb= new XSSFWorkbook(stm);  
		  sh=wb.getSheet("login");
		  
		  for(int i=1;i<=sh.getLastRowNum();i++)
		  { XSSFRow rw=sh.getRow(i);
		    String id=rw.getCell(0).getStringCellValue();
		    String password=rw.getCell(1).getStringCellValue();	
		    String name=rw.getCell(2).getStringCellValue();
		 
		    drivers(); 
		    LoginEmail(id);
		    LoginPasswd(password);
		    SiginButton();
		    Searchbox(name);
		    closing();
		    
		  }
		  
		    wb.close();
			stm.close();
	  }
	  
	  catch (FileNotFoundException e) {
			e.printStackTrace();}
	  
	  
  }
  
  

  
  
 
  public void LoginEmail(String email)
  {
	  WebElement mail=driver.findElement(By.id("session_key"));
	  mail.sendKeys(email);
	  
	  if(mail.isEnabled() && mail.isDisplayed())
		{testclass.log(LogStatus.PASS, "E-mail test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "E-mail test failed");}
	  	  
  }
  
  


  public void LoginPasswd(String passwd)
  {
	  WebElement password=driver.findElement(By.id("session_password"));
	  password.sendKeys(passwd);
	  
	  if(password.isEnabled() && password.isDisplayed())
		{testclass.log(LogStatus.PASS, "password test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "password test failed");}
	  	  
  }
  
  
 
  
  public void SiginButton()
  { WebElement button1=driver.findElement(By.xpath("/html/body/main/section[1]/div[2]/form/button"));
  
    boolean display= button1.isDisplayed();
    boolean enable= button1.isEnabled();
     button1.click();
	
	WebElement post=driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div/div/div/div/main/div[1]/div/div[1]/button"));

	if(display && enable && post!=null)
	{testclass.log(LogStatus.PASS, "signin test passed");}
	
	else
	{testclass.log(LogStatus.FAIL, "signin test failed");}
	
    
  }
  
  
  
 
  
  
  public void Searchbox(String name)
  {
	  WebElement box=driver.findElement(By.xpath("/html/body/div[8]/header/div[2]/div/div/div[1]/div[2]/input"));
	  box.sendKeys(name);
	  box.sendKeys(Keys.ENTER);
	  
	  if(box.isEnabled() && box.isDisplayed() && box.getText()!=null )
		{testclass.log(LogStatus.PASS, "Search box test passed");}
		
		else
		{testclass.log(LogStatus.FAIL, "Search box test failed");}
	  	  
	  try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
