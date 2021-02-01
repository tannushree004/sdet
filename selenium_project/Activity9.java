package CRMproject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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

public class Activity9 {
WebDriver driver;
	

	@BeforeMethod 
	public void browserAcess() {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().window().maximize();
		

	}
	@Test
	public void printLeadTableData() {
	    try {
	    	driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
	    	WebElement sales=driver.findElement(By.xpath("//a[@id='grouptab_0']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(sales).perform();
	    	WebElement accounts=driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a"));
	    	action.moveToElement(accounts).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		System.out.println(e);
		
		}
	    //clearing filter if filter is applied
	    try {
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		    WebElement clearfilterbtn =driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0);
	    	clearfilterbtn.click();	
	    }
	    	catch(ElementNotInteractableException e) {
	    	System.out.println("table is not filtered");
	    }
	    
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class ='list view table-responsive']/tbody/tr/td")));
	    
	    int i=1;
		 while(i<=10) {
		    String name= driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
		    String user1= driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr["+i+"]/td[8]")).getText();
			System.out.println("Name"+(i)+":-" +name+"|User"+(i)+ ":-" +user1);
			System.out.println("\n");
			i++;
		  }
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
		
}
