package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;

	@BeforeMethod 
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(" https://www.training-support.net");
	}
	 @Test
	 public void loginPage() {
	// get the title of the page
	String title = driver.getTitle();
	System.out.println("Title of the page is: " + title);
	Assert.assertEquals("Training Support", title);
	// click on About us button
	driver.findElement(By.id("about-link")).click();
	System.out.println("Title of new page :" +driver.getTitle());
	Assert.assertEquals("About Training Support",driver.getTitle());
	
	 }
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
	}
		
	

	
		
	
}