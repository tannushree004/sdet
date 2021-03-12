package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on Login page$")
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver","C:\\Mounika\\softwares\\Chromedriver_win32\\chromedriver.exe" );
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver,10);
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().window().maximize();
		}
	@When("^User enters username and password$")
	public void cerdLogin() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void dataExampleLogin(String username, String password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@Then("^Read the page title and confirmation message$")
	public void getTitle() {
		String title = driver.getTitle();
		String actionmsg = driver.findElement(By.id("action-confirmation")).getText();
	    System.out.println("Title of the page is : " +title);
	    System.out.println("Confirmation message is :" + actionmsg);
	    if(actionmsg.contains("admin")) {
            Assert.assertEquals(actionmsg, "Welcome Back, admin");
        } else {
            Assert.assertEquals(actionmsg, "Invalid Credentials");
        }
	}
	 @And("^Close the Browser$")
	 public void tearDown() {
			driver.close();
		}


}