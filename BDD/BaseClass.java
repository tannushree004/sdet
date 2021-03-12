package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	//creating a driver instance
   public static  WebDriver driver ;
	public static WebDriverWait wait;
	public static  void browserSetup() {
	System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
	 driver=new ChromeDriver();
     wait = new WebDriverWait(driver,15);
     driver.manage().window().maximize();
	}
    

}