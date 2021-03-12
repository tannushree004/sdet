package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;

	@BeforeClass
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(" https://www.training-support.net/selenium/login-form");
	}
	
    @DataProvider(name = "Authentication")
	
    public static Object[][] credentials() {
	
        return new Object[][] { { "admin", "password" }};
	
    }
	
    
	
    @Test (dataProvider = "Authentication")
	
    public void loginTestCase(String username, String password) {
	
        //Find username and pasword fields
	
        WebElement usernameField = driver.findElement(By.id("username"));
	    WebElement passwordField = driver.findElement(By.id("password"));
	
       //Enter values
	
        usernameField.sendKeys(username);
	    passwordField.sendKeys(password);
	     //Click Log in
	
        driver.findElement(By.cssSelector("button[type='submit']")).click();
	
        //Assert Message
	
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	
    }
	
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
© 2021 GitHub, Inc.