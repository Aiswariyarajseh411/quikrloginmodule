package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.homepage;

public class tc1_launchapplication {
	WebDriver driver;
	@Given("the application in the home page")
	public void the_application_in_the_home_page() {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-notifications");
		driver=new ChromeDriver(options);
	    driver.get("http://www.quikr.com/");
	    
	}

	@When("the user clicks on the Register\\/Login button")
	public void the_user_clicks_on_the_Register_Login_button() {
		homepage home = new homepage(driver);
		home.Login();
	    
	}

	@Then("he reaches the Login\\/Sign Up page")
	public void he_reaches_the_Login_Sign_Up_page() throws InterruptedException {
		Thread.sleep(5000);
	    driver.quit();
	}

  
}