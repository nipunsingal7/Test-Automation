package exp1000;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Signin {

	

 public void login(String id,String passwd)
 {
	 System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.0-win64/geckodriver.exe");
	   WebDriver driver=new FirefoxDriver();
		driver.navigate().to("https://www.amazon.in/");
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
	    
	    WebElement email=driver.findElement(By.id("ap_email"));
	    email.sendKeys(id);
	    
	    WebElement button=driver.findElement(By.id("continue"));
	    button.click();

	    WebElement passw=driver.findElement(By.id("ap_password"));
	    passw.sendKeys(passwd);
	    
	    WebElement button1=driver.findElement(By.id("signInSubmit"));
	    button1.click();
	    
	    driver.quit();
	 
	 
 }
 

 @Test
 public void start() throws IOException
 {   FileInputStream stm;
	   
	try
	{ String id1,passwd1;
		
    stm =new FileInputStream("D:\\signin.xlsx");
	 
	XSSFWorkbook wb =new XSSFWorkbook(stm);

	XSSFSheet sh=wb.getSheet("login");
	//wb.getSheetAt(0);
	
	for(int i=1;i<=sh.getLastRowNum();i++)
	{XSSFRow row= sh.getRow(i); 
	   id1=row.getCell(0).getStringCellValue();
	  //id=rw.getCell(0).getRawValue.toString();
	   passwd1=row.getCell(1).getStringCellValue();
	   
	 //  if(rw.getCell(0).getCellType()== CellType.NUMERIC)
	   //{   id=rw.getCell(0).getRawValue().toString();     }
	   
	  login(id1,passwd1);
	}
	
	wb.close();
	stm.close();
	
	}
	
        catch (FileNotFoundException e) {
		e.printStackTrace();
	}
 }
 
 
}
