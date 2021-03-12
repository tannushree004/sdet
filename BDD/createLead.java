package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class CRM_Createlead_2 extends Baseclass{
	
	@And("^open CRM and id and pwd$")
	public void open_crm() {
		driver.get("https://alchemy.hguy.co/crm/");
		String title =driver.getTitle();
		Assert.assertEquals(title,"SuiteCRM");
		System.out.println(title);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
	}
	
	@And ("^navigate to sales and click on leads option$")
	public void clickOnLeads() {
		try {

	    	WebElement sales=driver.findElement(By.xpath("//a[@id='grouptab_0']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(sales).perform();
	    	WebElement leads=driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a"));
	    	action.moveToElement(leads).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		   System.out.println(e);
		
		}
	}
	
	@Then ("^click on create leads$")
	public void click_OnCreateLeads() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebar']")));
		driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
	}
	
	@And ("^Give the lead values \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void createLeadDetails(String salutation,String firstname,String lastname, String mobilenum) {
		Select saltutationdrpdwn= new Select(driver.findElement(By.id("salutation")));
		saltutationdrpdwn.selectByVisibleText(salutation);
     
    	 driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);
    	 driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastname);
    	 driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(mobilenum);
	}
	
	@And ("^click on save button$")
	public void clickSave() {
	driver.findElement(By.xpath("//td[@class='buttons']/div/input[@id='SAVE']")).click();
	}
	
	@Then ("^navigate to view leads page$")
	public void gotoViewLeads() {
		driver.findElement(By.xpath("//div[text()='View Leads']")).click();
		
	}
	
	@And ("^verify the created lead$")
	public void verifyLead() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/form[@id='MassUpdate']/div[3]/table[1]")));
		 //clearing filter if filter is applied
	    try {
	    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		    WebElement clearfilterbtn =driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0);
	    	clearfilterbtn.click();	
	    }
	    	catch(ElementNotInteractableException e) {
	    	System.out.println("table is not filtered");
	    }

		WebElement filter=driver.findElement(By.xpath("//a[@title='Filter']"));
		filter.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='searchList']")));
		driver.findElement(By.xpath("//input[@id='search_name_basic']")).sendKeys("sundeep");
		driver.findElement(By.xpath("//input[@id='search_form_submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr")));
		
	    List<WebElement> table= driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
		System.out.println(table.size());
		for(int i=1; i<table.size();i++) {
		 String name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]")).getText();
		 if(name.contains("sundeep")) {
			 Assert.assertEquals(name,"Mr.sundeep Pogula");
			 break;
		 }
		 else {
			 System.out.println("No such name exists");
		 }
		 
		 }
	} 
	
	 
	
	

}