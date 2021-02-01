package CRMproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	 WebDriver driver = new FirefoxDriver();
	  @Test
	  public void copyrightText() {
		  WebElement pageHeader = driver.findElement(By.id("admin_options"));
		  String copyrightText= pageHeader.getText();
		  System.out.println("Copyright text is :-" + copyrightText);
		  
		
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
