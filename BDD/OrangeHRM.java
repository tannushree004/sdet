package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class OrangeHRM_Activities extends Baseclass{
	
     @Given("^open chromeBrowser$")
	
	   public void openBrowser() {
             Baseclass.browserSetup();
	
   }
     @Given("^User navigates to orange hrm site$")
     public void openOrangeHRM() {
	        driver.get("http://alchemy.hguy.co/orangehrm");
}
     @And("^login with userid and pwd$")
      public void enerCred() {
    	 driver.findElement(By.id("txtUsername")).sendKeys("orange");
    	 driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
    	 driver.findElement(By.id("btnLogin")).click();
    	 String title =driver.getTitle();
    	 Assert.assertEquals(title, "OrangeHRM");
     }
     
     @And("^Navigate to Recruitment page$")
     public void gotoRecruitmentPage() throws InterruptedException {
    	 Thread.sleep(3000);
    	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='wrapper']")));
    	 driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
     }
     
     
     @And ("^Navigate to vacancies page$")
     public void clickOnVacancies() {
    	 driver.findElement(By.xpath("//a[contains(text(),'Vacancies')]")).click();
     }
     
     @And ("^Click on Add vacancy button$")
     public void clickaddVacancy() throws InterruptedException {
    	 driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
    	// Thread.sleep(3000);
    	// Select jobtitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	// jobtitle.selectByVisibleText("DevOps Engineer");
     }
     
  /**   @throws InterruptedException 
 * @Then ("^Fill necessary details and click save$")
     public void fillDetails() {
    	 Select jobtitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	 jobtitle.selectByVisibleText("DevOps Engineer");
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_name']")).sendKeys("DevsecOps");
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_hiringManager']")).sendKeys("IBM 05",Keys.ENTER);
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys("10");
    	 driver.findElement(By.xpath("//textarea[@id='addJobVacancy_description']")).sendKeys("Require 4+ years experience in Devsecops");
    	 driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    	 
     } **/
     
     @Then("^Fill \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
     public void filldetailswithExamples(String jobtitle,String vacancyname,String hiremngr, String positions,String description) throws InterruptedException  {
    	 Thread.sleep(3000);
        Select jobtitles = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
        jobtitles.selectByVisibleText(jobtitle);
     
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_name']")).sendKeys(vacancyname);
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_hiringManager']")).sendKeys(hiremngr,Keys.ENTER);
    	 driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys(positions);
    	 driver.findElement(By.xpath("//textarea[@id='addJobVacancy_description']")).sendKeys(description);
    	 driver.findElement(By.xpath("//input[@id='btnSave']")).click();
     }
     
     @And ("^click back button$")
     public void clickBack() {
    	 driver.findElement(By.id("btnBack")).click();
     }
     
     @Then("^Enter vacancy details in textboxes and click searchbtn \"(.*)\" and \"(.*)\"$")
     public void searchvacancies(String title, String name) throws InterruptedException {
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vacancySearch_jobTitle")));
    	 Select jobtitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
    	 jobtitle.selectByVisibleText(title);
    	 Thread.sleep(2000);
    	 WebElement vacancy = driver.findElement(By.id("vacancySearch_jobVacancy"));
    	 Select jobvacancy = new Select(vacancy);
    	 List<WebElement> options = jobvacancy.getOptions();
    	 System.out.println(options.size());
    	 for(WebElement ele:options) {
    		 String  optiontxt = ele.getText();
    		 if(optiontxt.contains(name)) {
    			 ele.click();
    			 break;
    		 }
    	 }
    	  
    	 driver.findElement(By.id("btnSrch")).click();
    	// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("resultTable")));
    }
     
     @Then ("^Verify the vacancy has been created$")
     public void verifyVacancy() {
    	String jobtitle=driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
    	if (jobtitle.contains("DevOps Engineer")) {
    	
    	Assert.assertEquals(jobtitle, "DevOps Engineer");
     }
    	else 
    		Assert.assertEquals(jobtitle, "Automation Test Engineer");
    		
    	
    	 
     }
}

