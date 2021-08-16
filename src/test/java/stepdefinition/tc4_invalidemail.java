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

public class tc4_invalidemail {
	WebDriver driver;
	@Given("user is in home page")
	public void user_is_in_home_page() throws InterruptedException {
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
	@When("the user enters invalid email id")
	public void the_user_enters_invalid_email_id() throws Throwable {
		WebElement email = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/input"));
		email.sendKeys("1234Aishu");
		/*WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		continueBtn.click();
		Thread.sleep(3000);
        String expectedMsg = "Invalid email address";
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/p"));
        String value1 = errorMsg.getText();
		if(value1.equalsIgnoreCase(expectedMsg)) { 
			System.out.println(value1);
		} else {
			System.out.println("Invalid email fail");
		}
		driver.quit();*/
	}
	@When("the user clicks on the continue button")
	public void the_user_clicks_on_the_continue_button() throws InterruptedException {
		WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		continueBtn.click();
		Thread.sleep(3000);
        String expectedMsg = "Invalid email address";
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/p"));
        String value1 = errorMsg.getText();
		if(value1.equalsIgnoreCase(expectedMsg)) { 
			System.out.println(value1);
		} else {
			System.out.println("Invalid email fail");
		}
		driver.quit();
	}
	@Then("error is shown")
	public void error_is_shown() {
		driver.quit();
	}

}
