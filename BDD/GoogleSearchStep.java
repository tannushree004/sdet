package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Google Home Page$")
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void googleSearch() {
		 driver.findElement(By.name("q")).sendKeys("cheese",Keys.ENTER);
		 
	}
	
	@Then("^Show how many search results were shown$")
	public void searchResults() throws Throwable  {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));
		String Results = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Number of results found: " +Results);
	}
	@And("^Close the browser$")
	public void tearDown() {
		driver.close();
	}

}
