package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Post_A_Job_Activity extends Baseclass {
	
	
@Given("^open the browser$")
	
	public void openBrowser() {
   Baseclass.browserSetup();
	
		}
  @When ("^user is on jobs page$")
  public void navigateToJobspage() {
	  driver.get("https://alchemy.hguy.co/jobs/");
	  String title =driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
	  
	    
  }
  @Then("^Goto postjobs page and login$")
  public void clickOnPostJobs() {
	  driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main[@id='main']")));
	  driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
  }
  /** @And("^user enters the job details$")
   public void enterjobDetails(DataTable table) {
	   List<String> data = table.asList();
	   //Enter data
	  
	   driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(data.get(0));
	   driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys(data.get(1));
	   driver.switchTo().frame("job_description_ifr");
	   driver.findElement(By.xpath("/html/body[@id='tinymce']")).sendKeys(data.get(2));
	   driver.switchTo().defaultContent();
	   WebElement cmpnyname=driver.findElement(By.xpath("//input[@id='company_name']"));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   //js.executeScript("arguments[0].scrollIntoView();", cmpnyname);
	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   cmpnyname.sendKeys(data.get(3)); 
	   
   } **/
   
   @And("^Enter \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
   public void enterJobDetails(String jobtitle,String location,String description, String cmpany ) {
	   driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(jobtitle);
	   driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys(location);
	   driver.switchTo().frame("job_description_ifr");
	   driver.findElement(By.xpath("/html/body[@id='tinymce']")).sendKeys(description);
	   driver.switchTo().defaultContent();
	   WebElement cmpnyname=driver.findElement(By.xpath("//input[@id='company_name']"));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   cmpnyname.sendKeys(cmpany);
	   
   }
   @Then("^Click on Preview and then submit$")
   public void clickSubmit() {
	   driver.findElement(By.xpath("//input[@name='submit_job']")).click();
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   driver.findElement(By.id("job_preview_submit_button")).click();
   }
   
   @And("^Goto Jobs page$")
   public void gotojobspage() {
	   driver.findElement(By.xpath("//a[text()='Jobs']")).click();
   }
   @Then("^Search for posted job$")
   public void searchJobs() {
	 WebElement keywords=  driver.findElement(By.xpath("//input[@id='search_keywords']"));
	 keywords.clear();
	 keywords.sendKeys("Cucumber_Tester",Keys.ENTER);
   }
   @And("^Verify the posted job$")
   public void verifyJobs() {
	 String jobname=driver.findElement(By.xpath("//div[@id='content']//li[1]/a[1]/div/h3[1]")).getText();
	 System.out.println(jobname);
	 Assert.assertEquals(jobname, "Cucumber_Tester");
	   
   }
   
  

}