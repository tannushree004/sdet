package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
WebDriver driver;
	
	@BeforeClass
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(" https://www.training-support.net/selenium/login-form");
	}
	
	@Test
	@Parameters({"username","password"})
	public void loginValidation( String username, String password) {
		WebElement loginid = driver.findElement(By.id("username"));
		WebElement loginpwd = driver.findElement(By.id("password"));
		
		loginid.sendKeys(username);
		loginpwd.sendKeys(password);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String Loginmessage = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(Loginmessage, "Welcome Back, admin");
		
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	

}