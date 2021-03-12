package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alerttesting {
	WebDriver driver;
	WebDriverWait wait;
	Alert alert;
	
	@Given("^User is on the page$")
	public void openBrowser()  {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().window().maximize();
		}
	@When("^User clicks the Simple Alert button$")
	public void clickonSimpleAlert() {
		driver.findElement(By.id("simple")).click();
	}
	
	@When("^User clicks the Confirm Alert button$")
	public void clickonConfirmAlert() {
		  driver.findElement(By.id("confirm")).click();
	}
	@When("^User clicks the Prompt Alert button$")
	public void clickonPromptAlert() {
		driver.findElement(By.id("prompt")).click();
	}
	@Then("^Alert opens$")
	public void switchToAlert() {
		 alert=driver.switchTo().alert();
	}
	
	@And("^Read the text from it and print it$")
	public void readTheAlertText() {
		System.out.println("Text In Alert: " +alert.getText());
	}
	@And("^Write a custom message in it$")
	public void writetextToAlert() {
		alert.sendKeys("prompt alert");
	}
	
	@And("^Close the alert$")
	public void acceptAlert() {
		alert.accept();
	}
	@And("^Close the alert with Cancel$")
	public void dismissAlert() {
		alert.dismiss();
	}
	 @And("^Close Browser$")
	    public void closeBrowser() {
	        driver.close();
	    }

	
	

}