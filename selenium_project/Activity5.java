package CRMproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
 
  WebDriver driver = new FirefoxDriver();
  @Test
  public void getColour() {
	  
	  driver.findElement(By.id("user_name")).sendKeys("admin");
	  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("bigbutton")).click();
	  
	  
	  WebElement toolbar = driver.findElement(By.className("container-fluid"));
	  //String colour = toolbar.getCssValue("color");
	  System.out.println("Colour of toolbar is:"+ toolbar.getCssValue("color"));
	
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
