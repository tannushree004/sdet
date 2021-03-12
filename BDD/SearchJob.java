package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Search_for_a_jobActivity extends Baseclass {
	
@Given("^Open the browser$")
	
	public void openBrowser() {
   Baseclass.browserSetup();
}

@Then("^user is on jboard home page$")
public void getURL() {
	driver.get("https://alchemy.hguy.co/jobs/");
	  String title =driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
}

@Then("^click on jobs page$")
public void navigateToJobs_page() {
	 driver.findElement(By.xpath("//a[text()='Jobs']")).click();
	  
}

@Then("^Search for Job using keyword textbox$")
public void search_job() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.id("search_keywords")).sendKeys("Cucumber_tester");
}
	
@And("^Uncheck all job types except Full Time using xpath$")
public void getFullTimejob() {
	WebElement jobtypes = driver.findElement(By.xpath("//div[@class='job_listings']/form/ul"));
	List<WebElement> checkboxes = jobtypes.findElements(By.xpath("//li/label"));
	for(int i=1;i<=checkboxes.size();i++) {
		String Text= driver.findElement(By.xpath("//li["+i+"]/label")).getText();
		if(Text.contains("Full Time")) {
			continue;
		}
		else {
			driver.findElement(By.xpath("//li["+i+"]/label/input[@type='checkbox']")).click();
		}
	}
}
	
@And("^Find the job listing using xpath and click on job$")
public void getJobListings()  {
	try {
		Thread.sleep(3000);
		WebElement jobname=driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a[1]"));
	    jobname.click();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
@Then("^print the title of the job$")
public void getJobTitle() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String jobtitle=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
	 Assert.assertEquals(jobtitle, "Cucumber_Tester");
	 System.out.println("Title of the job is :" +jobtitle);
	 Thread.sleep(2000);
	
}
@And("^click on Apply for job button$")
public void clickonApplyJobBtn() {
	driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
	String applicationtext =driver.findElement(By.xpath("//div[@class='application_details']/p")).getText();
	System.out.println("Text appeard on clicking submit button :" +applicationtext);
}
}



	
	
