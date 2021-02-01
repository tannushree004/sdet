package CRMproject;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Activity1 {
	 WebDriver driver = new FirefoxDriver();
  @Test
  public void pageTitle() {
	  
	  String pageTitle= driver.getTitle();
	 Assert.assertEquals(pageTitle, "SuiteCRM");
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
