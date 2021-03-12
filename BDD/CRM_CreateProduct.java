package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CRM_create_a_product_4  extends Baseclass{
	
	@And("^navigate to All option and click on products$")
	public void navigateToALL() {
		try {

	    	WebElement activities=driver.findElement(By.xpath("//a[@id='grouptab_5']"));
	    	Actions action = new Actions(driver);
	    	action.moveToElement(activities).perform();
	    	WebElement meetings=driver.findElement(By.xpath("//li[7]//span[2]//ul[1]//li[25]//a"));
	    	action.moveToElement(meetings).click().perform();
	    	
	    }
		catch (ElementNotVisibleException e) {
		   System.out.println(e);
		
		
		
	}

}
	
	@Then("^click create a product$")
	public void createProduct() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebar']")));
		driver.findElement(By.xpath("//div[text()='Create Product']")).click();
		
	}
	
	@And ("^Give the product details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void giveProdDetails(String prodname,String partnum,String price) throws InterruptedException {
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='tab-content']")));
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys(prodname);
		driver.findElement(By.id("part_number")).sendKeys(partnum);
		driver.findElement(By.id("price")).sendKeys(price);
		
	}
	@And("^click on save Button$")
	public void clickSave() {
		driver.findElement(By.xpath("//table/tbody/tr//td[1]/input[@id='SAVE']")).click();
	}
	
	@Then ("^navigate to view products page$")
	public void viewProducts() {
		driver.findElement(By.xpath("//div[text()='View Products']")).click();
	}
	
	@And("^verify the created product$")
	public void verifyProduct() {
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
		driver.findElement(By.xpath("//input[@id='name_basic']")).sendKeys("oneplusphone");
		driver.findElement(By.xpath("//input[@id='search_form_submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr")));	
		List<WebElement> table= driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
		System.out.println(table.size());
		for(int i=1; i<table.size();i++) {
		 String name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]")).getText();
		 if(name.contains("oneplus")) {
			 Assert.assertEquals(name,"one");
			 break;
		 }
		 else {
			 System.out.println("No such products exists");
		 }
	
	
}
	}
}