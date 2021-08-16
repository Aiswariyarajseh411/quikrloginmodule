package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fbpage {
	WebDriver driver;
	//WebElement Click;
	public fbpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//driver.findElement(By.cssSelector("#loginLink > span > label")).click();

/*	public void Click() {
		boolean staleElement = true; 

		while(staleElement){

		  try{

		WebElement Click = driver.findElement(By.id("Facebook"));
		Click.click();

		     staleElement = false;


		  } catch(StaleElementReferenceException e){

		    staleElement = true;

		  }

		}	
		
	//Click = driver.findElement(By.id("Facebook"));
    //Click.click();		
	}*/


}
