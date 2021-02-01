package CRMproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	 WebDriver driver = new FirefoxDriver();
	 
	  @Test
	  public void getUrlofImage() {
		  
		  WebElement pageHeader = driver.findElement(By.xpath("//div[@class='companylogo']/img"));
		  System.out.println("Url of the image is :-"+ pageHeader.getAttribute("src"));
		  		
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
