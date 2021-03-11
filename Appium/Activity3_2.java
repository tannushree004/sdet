package mobile_testing;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activiy3_2 {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void smsExample() throws MalformedURLException  {
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
		public void scrollTest() {
			driver.get("https://www.training-support.net/selenium/lazy-loading");
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
			//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Lazy Loading']")));
			String Pagetitle = driver.findElementByXPath("//android.view.View[@text='Lazy Loading']").getText();
			Assert.assertEquals(Pagetitle,"Lazy Loading");
			//images shown on current screen before scrolling
			List<MobileElement> images = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
			System.out.println("Number of images in the page:" +images.size());
		    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.view.View\"), \"helen\")"));
			
			images = driver.findElementsByXPath("//android.view.View/android.view.View/android.view.View/android.widget.Image");
			System.out.println("Number of images in the page:" +images.size());
			
		}
		 @AfterClass	
		    public void afterClass() {	
		        driver.quit();	
		    }

}