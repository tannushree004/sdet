package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features",
		glue= {"stepDefinitions"},
		//tags=" @jbactivity_2"
		  tags="@orangeactuvity_2"
		//plugin = {"html:reports/Htmlreport.html"},
	   // monochrome = true
	
		)

public class JboardRunner {

}