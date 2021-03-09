package appium_project_activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
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

public class Google_keep_activities {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void googlekeepExample() throws MalformedURLException  {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Pixelemulator");
			caps.setCapability("deviceId", "emulator-5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.google.android.keep");
			caps.setCapability("appActivity", ".activities.BrowseActivity");
			caps.setCapability("noReset", true);
			
			 
		     // Initialize driver
		      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		      wait = new WebDriverWait(driver, 5);
		}
		
		@Test(priority=1)
		public void addNoteInKeepNote() {
			MobileElement newnote= driver.findElementById("com.google.android.keep:id/new_note_button");
			newnote.click();
			MobileElement titlenote= driver.findElementById("com.google.android.keep:id/editable_title");
			MobileElement notedesc= driver.findElementById("com.google.android.keep:id/edit_note_text");
			MobileElement navback= driver.findElement(MobileBy.AccessibilityId("Navigate up"));
			titlenote.sendKeys("SDET COURSE");
			notedesc.sendKeys("Mobile testing project activities");
			navback.click();
			
			String titletext = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
			String desctext = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
			
			Assert.assertEquals(titletext ,"SDET COURSE");
			Assert.assertEquals(desctext, "Mobile testing project activities");
			}  
		@Test(priority=2)
		public void addRemainder() throws InterruptedException {
			
			MobileElement notetile= driver.findElementById("com.google.android.keep:id/browse_note_interior_content");
			notetile.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			MobileElement remainderbtn= driver.findElementById("com.google.android.keep:id/menu_reminder");
			remainderbtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/bs_list_view")));
			MobileElement pickdatetime= driver.findElementByXPath("//android.widget.TextView[@text='Pick a date & time']");
			pickdatetime.click();
			driver.findElementById("com.google.android.keep:id/date_spinner").click();
			//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")));
			driver.findElementById("com.google.android.keep:id/reminder_date_tomorrow").click();
			driver.findElementById("com.google.android.keep:id/time_spinner").click();
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")));
			driver.findElementByXPath("//android.widget.TextView[@text='Night']").click();
			driver.findElementById("com.google.android.keep:id/save").click();
			
			
			//Navigating to Remainders
			
			driver.findElement(MobileBy.AccessibilityId("Navigate up")).click();
		    driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
			driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders").click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//Adding assertions
			String alarm=driver.findElementByXPath("//android.widget.TextView[@text='Tomorrow, 8:00 PM']").getText();
			String titletext = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
			String desctext = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
			
			Assert.assertEquals(titletext ,"SDET COURSE");
			Assert.assertEquals(desctext, "Mobile testing project activities");
			Assert.assertEquals(alarm, "Tomorrow, 8:00 PM");
			
			
			
		}
		 @AfterClass	
		    public void afterClass() {	
		        driver.quit();	
		 }
		

}