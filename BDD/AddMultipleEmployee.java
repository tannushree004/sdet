package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class orangeHRM_AddMutliple_Employees_3 extends Baseclass{
	
	@And ("^Navigate to PIM option$")
	public void clickOnPIM() throws InterruptedException {
		Thread.sleep(3000);
   	    driver.findElement(By.xpath("//b[text()='PIM']")).click();
   	    
	}
	
	@Then("^Click Add button$")
	 public void addcandidate() throws InterruptedException {
		Thread.sleep(3000);
		 driver.findElement(By.id("btnAdd")).click();
	 } 
	
	@Then ("^Enter following details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void enteremployee_details(String firtsname,String lastname,String username,String password,String cnfrmpwd ) {
		 driver.findElement(By.id("firstName")).sendKeys(firtsname);
		 driver.findElement(By.id("lastName")).sendKeys(lastname);
		 driver.findElement(By.id("chkLogin")).click();
		 driver.findElement(By.id("user_name")).sendKeys(username);
		 driver.findElement(By.id("user_password")).sendKeys(password);
		 driver.findElement(By.id("re_password")).sendKeys(cnfrmpwd );	
	}
	
	@Then ("^click save button$")
	public void clickSavebtn() {
		 driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}
	
	  @And ("^verify employee and print it to console$")
	  public void verifyEmplye() {
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='profile-pic']")));
		  String emplname = driver.findElement(By.xpath("//div[@id='profile-pic'] /h1")).getText();
		  if(emplname.contains("sravya Gotti")) {
		  Assert.assertEquals(emplname,"sravya Gotti");
		  
	  }
		  else {
			  Assert.assertEquals(emplname,"mounika Sai");
		  }

	  }
}