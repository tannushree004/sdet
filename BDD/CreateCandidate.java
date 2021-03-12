package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class orangehrm_Create_candidate_2 extends Baseclass {
	
	 @And("^Click Add Button$")
	 public void addcandidate() {
		 driver.findElement(By.id("btnAdd")).click();
	 }
	 
	 @And ("^fill the candidate details and upload Resume$")
	 public void fillDetails() {
		 //fill details
		 driver.findElement(By.id("addCandidate_firstName")).sendKeys("sundeep");
		 driver.findElement(By.id("addCandidate_middleName")).sendKeys("sai");
		 driver.findElement(By.id("addCandidate_lastName")).sendKeys("sri");
		 driver.findElement(By.id("addCandidate_email")).sendKeys("Mounika@gmail.com");
		 //upload resume
		 driver.findElement(By.id("addCandidate_resume")).sendKeys("C:\\Users\\SriSaiMounikaGottimu\\Desktop\\orangetxt.txt");
		 //click consent checkbox
		 driver.findElement(By.id("addCandidate_consentToKeepData")).click();
		 
	 }
	 @Then ("^click Save$")
	 public void saveDetails() {
		 driver.findElement(By.id("btnSave")).click();
		 
	 
	 }
	 @Then ("^Click Back$")
	  public void NavigatetoRecuitement() {
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnBack")));
		 driver.findElement(By.id("btnBack")).click();
	 }
	 
	 @And ("^Verify Candidate entry$")
	 public void verifycandidate() {
		 driver.findElement(By.xpath("//input[@id='candidateSearch_candidateName']")).sendKeys("sundeep sai sri",Keys.ENTER);
		 driver.findElement(By.id("btnSrch")).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr")));
		 
		 List<WebElement> candiname = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		 for(int i=1;i<=candiname.size();i++) {
			 String candidate= driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText();
			 if(candidate.contains("sundeep sai sri")) {
				 Assert.assertEquals(candidate, "sundeep sai sri");
			 }
		 }
		 
	 }
	 

}