package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {

WebDriver driver;
	
	@BeforeClass
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	@Test
	public void loginPage() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text() ='Log in']")).click();
		String message = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
		System.out.println("Confirmation message is:" +message);
		Assert.assertEquals("Welcome Back, admin", message);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}