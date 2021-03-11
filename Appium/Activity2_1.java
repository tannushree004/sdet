package mobile_testing;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2_1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriver wait;
	@BeforeClass
	public void googleExample() throws MalformedURLException  {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixelemulator");
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
	    // Initialize driver
	      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}
       
	 @Test
	 public void testSearch() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.training-support.net/");
		 String PageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		 System.out.println("Page Title is :" +PageTitle);
		 driver.findElementByXPath("//android.view.View[@text='About Us']").click();
		 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 String newTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		 System.out.println("Page Title is :" +newTitle);
		 Assert.assertEquals(PageTitle, "Training Support");
		 Assert.assertEquals(newTitle, "About Us");	 		
	 }
	 
	 @AfterClass
	 public void teardown() {
		 driver.quit();
	 
	 }
	 
}