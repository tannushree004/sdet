package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Jobboard_activities  extends Baseclass{
	
	
	@Given("^open browser$")
	
	public void openBrowser() {
   Baseclass.browserSetup();
	
		}
	@When ("^user is on jobboard application login page$")
	public void login_activity_page() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}
	
    @And("^enter username and password$")
    public void enteruname_pwd() {
    	driver.findElement(By.id("user_login")).sendKeys("root");
    	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    	driver.findElement(By.id("wp-submit")).click();
    	String title= driver.getTitle();
    	System.out.println(title);
    	Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress");
    }
  
	@And("^click on Users in left menu$")
	public void clickonUsers() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='adminmenuwrap']")));
		driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();
		
	}
	
	 @When ("^click on Add New button$")
	 public void addnewUser() {
	 driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
	
	 
	 
	 }
     @Then ("^Fill the required UserDetails$") 
      public void addUserdetails() {
    	 driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Mounika");
    	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sai@gmail.com");
    	 driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Sai");
    	 driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Mounika");
     }
	 @And("^click add user$")
	 public void addUserbtn() {
		 driver.findElement(By.xpath("//input[@id='createusersub']")).click();
	 }
	 
	 @Then ("^verify the user is created$")
	 public void verifyUser() {
	     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//form[@method='get']//table[@class='wp-list-table widefat fixed striped users']")));
		 driver.findElement(By.xpath("//input[@id='user-search-input']")).sendKeys("Mounika");
		 driver.findElement(By.xpath("//input[@id='search-submit']")).click();
		 String username = driver.findElement(By.xpath("//td[@data-colname='Username']")).getText();
		 System.out.println(username);
		 Assert.assertEquals(username, "Mounika");
		 
	 }
	

}