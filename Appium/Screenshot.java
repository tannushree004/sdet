package mobile_testing;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenshotExample {
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
		public void screenshot() throws IOException {
			
			File Screenshotname;
			// Take screenshot
			File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// This specifies the location the screenshot will be saved
			Screenshotname = new File("src/test/resources/screenshot.jpg");
			//this will copy the file to destination path
			FileUtils.copyFile(scrfile, Screenshotname);
			// set the path for image
			String Filepath = "../"+Screenshotname.toString();
			// set iamge in  html report 
			String path = "<img src='"+Filepath +" '/>";
			// show report
			Reporter.log(path);
			
		}
		
		@AfterClass
		public void teardown() {
			driver.quit();
		}

}