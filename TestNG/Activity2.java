package Testng_sessions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;



public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("  https://www.training-support.net/selenium/target-practice");
	}
	@Test
	public void getTitle() {
		String title =driver.getTitle();
		System.out.println("Page Title is :" +title);
		Assert.assertEquals("Target Practice", title);
		
	}
	//test case fails
	@Test
	public void findBlackButton() {
		WebElement blackbutton=driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackbutton.isDisplayed());
		Assert.assertEquals(blackbutton.getText(),"black");
		
	}
	@Test(enabled=false)
	public void skipmethod() {
		System.out.println("Skip this method");
	}
	
	@Test
	public void skipExceptionTest() throws SkipException {
		String condition ="skip";
		if(condition .equals("skip")) {
			throw new SkipException("skipping this testcase");
			}
		else {
			System.out.println("execute other TC");
		}
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	

}