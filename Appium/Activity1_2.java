package mobile_testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1_2 {
	 AppiumDriver<MobileElement> driver = null;
	@BeforeClass
	public void caculator() throws MalformedURLException  {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixelemulator");
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		//caps.setCapability("noReset", true);
		
		 
	     // Initialize driver
	      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}      
		@Test
		public void multiply() {
		     MobileElement numnine = driver.findElementById("digit_9");
		     numnine.click();
		     MobileElement multi = driver.findElementById("op_mul");
		     multi.click();
		     MobileElement seven = driver.findElementById("digit_7");
		     seven.click();
		     MobileElement equal = driver.findElementById("eq");
		     equal.click();
		     //Display Result
		     String answer= driver.findElementById("result").getText();
		     System.out.println(answer);
		     Assert.assertEquals(answer, "63");
		
	}
		
		@AfterClass
		public void teardown() {
			driver.quit();
			
		}
}


