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

public class tc5_invalidpass {
	WebDriver driver;
	@Given("user is in the home page")
	public void user_is_in_the_home_page() throws InterruptedException {
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
	@When("user enters valid email id")
	public void user_enters_valid_email_id() {
		WebElement email = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/input"));
		email.sendKeys("aishuaishu1604@gmail.com");
	}
	@When("clicks on continue button")
	public void clicks_on_continue_button() {
		WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		continueBtn.click();
	}
	@When("the user enters invalidpassword")
	public void the_user_enters_invalidpassword() {
		WebElement password = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div[2]/input"));
		password.sendKeys("aishu");
	}
	@When("the click on login button")
	public void the_click_on_login_button() throws InterruptedException {
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		loginBtn.click();
		Thread.sleep(3000);
        String expectedMsg = "Invalid password";
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/div[1]"));
        String value1 = errorMsg.getText();
		if(value1.equalsIgnoreCase(expectedMsg)) { 
			System.out.println(value1);
		} else {
			System.out.println("Invalid password");
		}
		driver.quit();
	}
	@Then("errormsg is shown")
	public void errormsg_is_shown() {
		driver.quit();
	}

	
}
