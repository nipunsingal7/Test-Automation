package exp2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","/root/Downloads/geckodriver-v0.29.0-linux64/geckodriver");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.amazon.in");
	   driver.manage().window().maximize();
	   
	   WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
       search.sendKeys("Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB Storage)");
       
       WebElement button=driver.findElement(By.id("nav-search-submit-button"));
       button.click();    
       
       WebElement search1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span"));
       search1.click();

	}

}
