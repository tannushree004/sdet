package stepDefinitions;

import io.cucumber.java.en.And;


public class Closecurrent_browser extends Baseclass{
	 @And ("^close browser$")
	 public void teardown(){
		 driver.quit();
	 }  

}