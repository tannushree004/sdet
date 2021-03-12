package Testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity10 {
	WebDriver driver;
	


	
	@BeforeTest
	public void browserAcess() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(" https://www.training-support.net/selenium/sliders");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	//middle of the slider
	
	@Test(priority=1)
	public void middleSlider() {
		WebElement slider= driver.findElement(By.id("slider"));
		Actions actions= new Actions(driver);
	    Dimension dim = slider.getSize();
		int x = dim.getWidth();
		System.out.println(x);
		actions.clickAndHold(slider).moveByOffset(x-129,0).release().perform();
		String volume = driver.findElement(By.cssSelector("span#value")).getText();
        System.out.println(" Current volume is" +volume);
       Assert.assertEquals(volume, "50");
        
		
		
	}
	@Test(priority=2)
	public void maxSlider() {
		WebElement slider= driver.findElement(By.id("slider"));
		Actions actions= new Actions(driver);
	    Dimension dim = slider.getSize();
		int x = dim.getWidth();
		actions.clickAndHold(slider).moveByOffset(x,0).release().perform();
		String volume = driver.findElement(By.cssSelector("span#value")).getText();
        System.out.println(" Current volume is" +volume);
       Assert.assertEquals(volume, "100");
        
	}
	
	@Test(priority=3)
	public void minSlider() {
		WebElement slider= driver.findElement(By.id("slider"));
		Actions actions= new Actions(driver);
	    Dimension dim = slider.getSize();
		int x = dim.getWidth();
		actions.clickAndHold(slider).moveByOffset(x-258,0).release().perform();
		String volume = driver.findElement(By.cssSelector("span#value")).getText();
        System.out.println(" Current volume is" +volume);
       Assert.assertEquals(volume, "0");
	}
	
	@Test(priority=4)
	public void sliderTo30() {
		WebElement slider= driver.findElement(By.id("slider"));
		Actions actions= new Actions(driver);
	    Dimension dim = slider.getSize();
		int x = dim.getWidth();
		actions.clickAndHold(slider).moveByOffset(x-152,0).release().perform();
		String volume = driver.findElement(By.cssSelector("span#value")).getText();
        System.out.println(" Current volume is" +volume);
        Assert.assertEquals(volume, "30");
	}
	@Test(priority=5)
	public void sliderTo80() {
		WebElement slider= driver.findElement(By.id("slider"));
		Actions actions= new Actions(driver);
	    Dimension dim = slider.getSize();
		int x = dim.getWidth();
		actions.clickAndHold(slider).moveByOffset(x-95,0).release().perform();
		String volume = driver.findElement(By.cssSelector("span#value")).getText();
        System.out.println(" Current volume is" +volume);
        Assert.assertEquals(volume, "80");
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}