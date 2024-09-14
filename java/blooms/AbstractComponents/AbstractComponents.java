package blooms.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents{
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(xpath = "//span[@class='fa-solid fa-user-group']")
	WebElement administrtionHeader;

	public void waitElementToAppear(By findBy)
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(findBy));
        
	}
	
	public void waitElementToAppearByElement(WebElement emailId)
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailId));
        
	}
	
	
	public void goToAdministration() throws InterruptedException
	{
		Thread.sleep(6000);
		administrtionHeader.click();
	}
	


	
	

}
