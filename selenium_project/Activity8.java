package CRMproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	

	@BeforeMethod 
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/crm/");
	
		

	}
	@Test
	public void printOddNumNames() {
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
	    try {
	    	
	    	WebElement sales=driver.findElement(By.xpath("//a[@id='grouptab_0']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(sales).perform();
	    	WebElement accounts=driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[2]//a"));
	    	action.moveToElement(accounts).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		   System.out.println(e);
		
		}
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class ='list view table-responsive']/tbody/tr/td")));
	    List<WebElement> tablerows = driver.findElements(By.xpath("//td[@type='name']"));
	    for (int i=0;i<10;i=i+2) 
	    {
	    	String Row = tablerows.get(i).getText();
	        System.out.println(Row);
	       
	    }
	    }
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	   
}
