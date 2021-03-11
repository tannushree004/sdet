package mobile_testing;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Activity2_3 {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void contactExample() throws MalformedURLException  {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Pixelemulator");
			caps.setCapability("deviceId", "emulator-5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.android.contacts");
			caps.setCapability("appActivity", ".activities.PeopleActivity");
			//caps.setCapability("noReset", true);
			
			 
		     // Initialize driver
		      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		}
		
		@Test
		public void addContact() {
	   //click on + button
		driver.findElementById("floating_action_button_container").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//close the popup 
		
		// popup=
		driver.findElementById("android:id/custom");
		//driver.switchTo().frame("android:id/custom");
		driver.findElementByXPath("//android.widget.Button[@text='CANCEL']").click();
		//driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//find First name 
		MobileElement firstname=driver.findElementByXPath("//android.widget.EditText[@text='First name']");
		MobileElement lastname=driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
		MobileElement phonenum=driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
		MobileElement savebtn=driver.findElementByXPath("//android.widget.Button[@text='SAVE']");
		
		//Enter values
        firstname.sendKeys("Mounika");
        lastname.sendKeys("Gottimukkala");
        phonenum.sendKeys("9502324009");
        savebtn.click();
        
        //wait until contact card appears 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
       // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/photo")));
        
        MobileElement contactcard = driver.findElement(MobileBy.id("com.android.contacts:id/toolbar_parent"));
        Assert.assertTrue(contactcard.isDisplayed());
        
        String title=driver.findElement(MobileBy.id("com.android.contacts:id/photo_touch_intercept_overlay")).getAttribute("content-desc");
        
        Assert.assertEquals(title, "Mounika Gottimukkala");
        //prints save contact name to console
        System.out.println(title);
		
			
		}
		
		 @AfterClass
		    public void afterClass() {
		        driver.quit();
		    }
		

}