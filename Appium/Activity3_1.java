package mobile_testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity3_1 {
	
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void smsExample() throws MalformedURLException  {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Pixelemulator");
			caps.setCapability("deviceId", "emulator-5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.google.android.apps.messaging");
			caps.setCapability("appActivity", ".ui.ConversationListActivity");
			//caps.setCapability("noReset", true);
			
			 
		     // Initialize driver
		      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		}
		
		@Test
		public void sendMessage() {
			//click on create new message button
			driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
			//locate and enter phone number in textbox
			driver.findElement(MobileBy.AndroidUIAutomator("description(\"Switch between entering text and numbers\")")).click();
			MobileElement textbox=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")"));
			textbox.sendKeys("9502324009");
			((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//enter message in text box
		    driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");
			// click on send button
			driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     //get the text from message
			String msgtext = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")).getText();
			Assert.assertEquals(msgtext, "Hello from Appium");
			System.out.println(msgtext);
			}
		@AfterClass
		public void teardown() {
			driver.quit();
			
		}

}