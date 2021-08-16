package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {
	WebDriver driver;
	WebElement Login;
	public homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Login(){
	Login = driver.findElement(By.cssSelector("#loginLink > span > label"));
	Login.click();
	}
	public boolean verifyTitle()
	{
		String expOutput="Login/Sign Up On Quikr";
		String actOutput = driver.getTitle();
		if(expOutput.equals(actOutput))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}