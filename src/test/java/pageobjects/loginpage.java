package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	WebDriver driver;

	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	/*public void email() throws InterruptedException {
		WebElement email = driver.findElement(By.cssSelector("#loginLink > span > label"));
		email.click();
		Thread.sleep(3000);
		
	}
	public void continuebutton() {
		driver.findElement(By.id("email")).sendKeys("aishuaishu1604@gmail.com");
		
	}
	public void pass() {
		// TODO Auto-generated method stub
		
	}
	public void login() {
		// TODO Auto-generated method stub
		
	}*/

}
