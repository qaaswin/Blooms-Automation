package blooms.Pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blooms.AbstractComponents.AbstractComponents;

public class BookSlotPage extends AbstractComponents {


	WebDriver driver;

	public BookSlotPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void goToBookSlot() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[@class='fa-calendar-plus fa-solid']")).click();
	}
	
	@FindBy(xpath="//input[@value='Add Slot']")
	WebElement AddSlotButton;
	
	
	@FindBy(xpath="//input[@name='startTime']")
	WebElement startTimeField;
	
	@FindBy(xpath="//input[@name='endTime']")
	WebElement endTimeField;
	
	@FindBy(xpath="//ng-select[@placeholder='Please select duration']//div[@class='ng-select-container ng-has-value']")
	WebElement durationField;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitButton;
	
	
	
	
	public void createaSlot() throws InterruptedException
	{
		
		waitElementToAppearByElement(startTimeField);
	
		startTimeField.sendKeys("06:00 PM");
		
		waitElementToAppear(By.xpath("//div[@class='time-slots border mb-4']"));
	
		driver.findElement(By.xpath("//div[@class='time-slots border mb-4']")).click();

		endTimeField.sendKeys("07:00 PM");
		
		
		waitElementToAppearByElement(durationField);
		durationField.click();
		driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div[2]/div[2]")).click();
		

		AddSlotButton.click();

		submitButton.click();

	}



}
