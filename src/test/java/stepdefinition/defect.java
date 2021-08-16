package stepdefinition;

import static org.testng.Assert.assertEquals;

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

public class defect {
	WebDriver driver;
	@Given("user  in  home page")
	public void user_in_home_page() throws InterruptedException {
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
	/*public void the_user_enters_invalid_email() throws Throwable {
		WebElement email = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/input"));
		email.sendKeys("aishuaishu1604@gmail.conm");
	}*/
	@When("the user enters invalid emailid")
	public void the_user_enters_invalid_emailid() {
		WebElement email = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[1]/div/input"));
		email.sendKeys("aishuaishu1604@gmail.conm");
	}
	@When("the user clicks on the continuetn")
	public void the_user_clicks_on_the_continuetn() throws InterruptedException {
		WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"newLoginSignUpModal\"]/div/div/div/div/form/div[2]/button"));
		continueBtn.click();
		Thread.sleep(3000);
        String expectedMsg = "Invalid email address";
		String errorMsg = driver.findElement(By.xpath("//*[@id=\\\"newLoginSignUpModal\\\"]/div/div/div/div/form/div[1]/div/p")).getText();
        System.out.println(errorMsg);
        assertEquals(errorMsg, expectedMsg);
		System.out.println("Invalid email fail");
		Thread.sleep(3000);
		driver.quit();
	}
	@Then("errormessage is shown")
	public void errormsg_is_shown() {
		driver.quit();
	}

	//*[@id="newLoginSignUpModal"]/div/div/div/div/form/div[1]/div/input
	
	

}
