package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tc2_login {
	WebDriver driver;
	@Given("the user is in home page")
	public void the_user_is_in_home_page() throws InterruptedException {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.get("http://www.quikr.com/");
	    Thread.sleep(3000);
	    WebElement Click = driver.findElement(By.xpath("//*[@id=\"loginLink\"]"));
	    try
	    {
	    	Click.click();
	    }
	    catch(StaleElementReferenceException e)
	    {
	    	Click = driver.findElement(By.xpath("//*[@id=\"loginLink\"]"));
	    	Click.click();
	    }
	}

	@When("the user enters valid username")
	public void the_user_enters_valid_username() throws Throwable {
		WebElement email = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/input"));
		email.sendKeys("aishuaishu1604@gmail.com");
	}

	@When("the user clicks on continue button")
	public void the_user_clicks_on_continue_button() throws Throwable {
		WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		continueBtn.click();
	}

	@When("the user enters password")
	public void the_user_enters_password() throws Throwable {
		WebElement password = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div[2]/input"));
		password.sendKeys("aiswariya");
	}

	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		loginBtn.click();
	}

	@Then("he redirects to application")
	public void he_redirects_to_application() throws Throwable {
		Thread.sleep(10000);
	    driver.quit();
	}
}
