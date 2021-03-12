package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class Dashlet_count_CRM1 extends Baseclass {
	
	@And ("^count the dashlets and print to console$")
	public void dashLetCount() throws InterruptedException {
		  List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
		   Thread.sleep(1000);
		   dashlets=driver.findElements(By.className("dashlet-title"));
		   Assert.assertEquals(dashlets.size(),7);
		   System.out.println("The number of dashlets are " + dashlets.size());
		   for (WebElement webElement : dashlets) {
	           String name = webElement.getText();
	           System.out.println(name);
	       }
		
			
	}

}