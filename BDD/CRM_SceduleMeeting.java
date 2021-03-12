package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CRM_ScheduleMeeting_3 extends Baseclass {
	
	@And("^navigate to activities and click on meetings option$")
	public void clickOnmeetings() {
		try {

	    	WebElement activities=driver.findElement(By.xpath("//a[@id='grouptab_3']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(activities).perform();
	    	WebElement meetings=driver.findElement(By.xpath("//li[5]//span[2]//ul[1]//li[4]//a"));
	    	action.moveToElement(meetings).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		   System.out.println(e);
		
		}
	}
	
	@Then ("^click on schedule meeting$")
	public void click_OnCreateLeads() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebar']")));
		driver.findElement(By.xpath("//div[text()='Schedule Meeting']")).click();
	}
	
	@And("^Give the meeting details \"(.*)\" and \"(.*)\"$")
	public void enterMeetingDetails(String user1,String user2) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("name")).sendKeys("one to one meeting");
		Select starthour = new Select(driver.findElement(By.id("date_start_hours")));
		Select startmins = new Select(driver.findElement(By.id("date_start_minutes")));
		Select endhours= new Select(driver.findElement(By.id("date_end_hours")));
		Select endmins = new Select(driver.findElement(By.id("date_end_minutes")));
		starthour.selectByValue("16");
		startmins.selectByValue("30");
		endhours.selectByValue("17");
		endmins.selectByValue("15");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		
		WebElement user=driver.findElement(By.id("search_first_name"));
	    WebElement search=driver.findElement(By.id("invitees_search"));
		
		
		ArrayList<String> addusers = new ArrayList<String>();
		addusers.add(user1);
		addusers.add(user2);
		for(int i=0;i< addusers.size();i++) {
			user.sendKeys(addusers.get(i));
			search.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='list_div_win']//table/tbody/tr")));
			driver.findElement(By.xpath("//input[@id='invitees_add_1']")).click();
		}
		
		
		}
	
	@And ("^click the save button$")
	public void saveMeeting() {
		driver.findElement(By.xpath("//form[@id='EditView']/div/input[1]")).click();
	}
	@Then ("^navigate to view meetings page$")
	public void viewMeetings() {
		driver.findElement(By.xpath("//div[text()='View Meetings']")).click();
	}
	
	@And("^verify the created meeting$")
	public void verifyMeeting() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/form[@id='MassUpdate']/div[3]/table[1]")));
		 //clearing filter if filter is applied
	    try {
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		    WebElement clearfilterbtn =driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[4]")).get(0);
	    	clearfilterbtn.click();	
	    }
	    	catch(ElementNotInteractableException e) {
	    	System.out.println("table is not filtered");
	    }

		WebElement filter=driver.findElement(By.xpath("//a[@title='Filter']"));
		filter.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='searchList']")));
		driver.findElement(By.xpath("//input[@id='name_basic']")).sendKeys("one to one meeting");
		driver.findElement(By.xpath("//input[@id='search_form_submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr")));	
		List<WebElement> table= driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
		System.out.println(table.size());
		for(int i=1; i<table.size();i++) {
		 String name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[4]")).getText();
		 if(name.contains("one to one")) {
			 Assert.assertEquals(name,"one to one meeting");
			 break;
		 }
		 else {
			 System.out.println("No such meeting exists");
		 }
	
		
		
		
	}
	
}
}
