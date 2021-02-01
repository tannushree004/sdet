package CRMproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Activity7  {
	WebDriver driver;
	
	@BeforeMethod 
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		}
	
	@Test
	public void getPhoneNumber() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		try {

	    	WebElement sales=driver.findElement(By.xpath("//a[@id='grouptab_0']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(sales).perform();
	    	WebElement accounts=driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a"));
	    	action.moveToElement(accounts).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		   System.out.println(e);
		
		}
	   
	    try {
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		    WebElement clearfilterbtn =driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0);
	    	clearfilterbtn.click();	
	    }
	    	catch(ElementNotInteractableException e) {
	    	System.out.println("table is not filtered");
	    }
	        WebDriverWait wait = new WebDriverWait(driver,30);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			WebElement filter=driver.findElement(By.xpath("//a[@title='Filter']"));
			filter.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='searchList']")));
			driver.findElement(By.xpath("//input[@id='first_name_advanced']")).sendKeys("sanjay");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement searchbtn =driver.findElement(By.xpath("//input[@title='Search']"));
		    searchbtn.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Additional Details']")));
		    driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui-id-5']")));
		    String phonenum = driver.findElement(By.xpath("//span[@class='phone']")).getText();
		    System.out.println("Mobile number :" +phonenum);
		     } 
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	 
		
}

