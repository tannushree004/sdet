package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
	
WebDriver driver;
	
	@BeforeTest
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(" https://www.training-support.net/selenium/target-practice");
	}
	
	@Test ( priority=1)
	public void pageTitleTest() {
		String title =driver.getTitle();
		System.out.println("Page Title is :" +title);
		Assert.assertEquals(title, "Target Practice");
	}
	
	@Test (priority=2 ,dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
	public void headerTest1() {
		WebElement thirdelement = driver.findElement(By.id("third-header"));
		Assert.assertEquals(thirdelement.getText(), "Third header");
		System.out.println(thirdelement.getText());
	}
	
	@Test (priority=3 ,dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
	public void headerTest2() {
		WebElement fifthelement = driver.findElement(By.xpath("//h5[text() ='Fifth header']"));
		System.out.println(fifthelement.getCssValue("color"));
		Assert.assertEquals(fifthelement.getCssValue("color"), "rgba(33, 186, 69, 1)");
		
	}
	@Test (priority=4,dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
	public void buttonTest1() {
		WebElement button1 = driver.findElement(By.xpath("//button[text() ='Olive']"));
		Assert.assertEquals(button1.getText(), "Olive");
		System.out.println(button1.getText());
		
	}
	
	@Test (priority=5 ,dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
	public void buttonTest2() {
		WebElement button2 = driver.findElement(By.xpath("//button[text() ='Brown']"));
		System.out.println(button2.getCssValue("color"));
		Assert.assertEquals(button2.getCssValue("color"), "rgba(255, 255, 255, 1)");
		
	}
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}