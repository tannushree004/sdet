package CRMproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver = new FirefoxDriver();
	  @Test
	  public void Activities() {
		  
		  driver.findElement(By.id("user_name")).sendKeys("admin");
		  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("bigbutton")).click();
		  
		  
		  //verify if Activities tab is displayed
		  
		  List<WebElement> list = driver.findElements(By.xpath("//li[@class='topnav']/span/a"));
		  System.out.println("list of webelement:"+list.size());
		  for(WebElement e : list) {
			  System.out.println(e.getText()); 
			
			  String menu=e.getText();
			  if(e.getText().equalsIgnoreCase("activities")) {
				  System.out.println("Activities is present");
				  break;
			  }
			
		  }
		
		 
		
	  }
	
	  @BeforeMethod
	  public void beforeMethod() {
		  driver.get("http://alchemy.hguy.co/crm");
		 
	  }
	  
	  @AfterMethod
	  public void closeBrowser() {
		  System.out.println("Closing browser");
		  driver.quit();
	  }
}
