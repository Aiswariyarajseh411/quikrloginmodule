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

public class tc3_fb {
	WebDriver driver;
	@Given("the user is in Login\\/Sign Up page")
	public void the_user_is_in_Login_Sign_Up_page() throws InterruptedException  {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.get("http://www.quikr.com/");
	    Thread.sleep(3000);
	    WebElement Click = driver.findElement(By.cssSelector("#loginLink > span > label"));
	    try
	    {
	    	Click.click();
	    }
	    catch(StaleElementReferenceException e)
	    {
	    	Click = driver.findElement(By.cssSelector("#loginLink > span > label"));
	    	Click.click();
	    }
	}

	@When("the user clicks on facebook button")
	public void the_user_clicks_on_facebook_button()  {
		WebElement Click1 = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/footer/div/div/a[1]"));
		Click1.click();
	}
	

	@When("the user enters valid email id and password")
	public void the_user_enters_valid_email_id_and_password() {
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("aiswariyarajesh411@gmail.com");
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("8825946738");
		WebElement fbLoginBtn = driver.findElement(By.name("login"));
		fbLoginBtn.click();
//		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@Then("user navigate to facebook page")
	public void user_navigate_to_facebook_page() throws Throwable {
	    driver.quit();
	}

}
