package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features",
		glue= {"stepDefinitions"},
		 tags="@orangeactivity_4"
		//plugin = {"html:reports/Htmlreport.html"},
	   // monochrome = true
	
		)


public class OrangeHRM_Runner {

}