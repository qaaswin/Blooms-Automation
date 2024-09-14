package blooms.Pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blooms.AbstractComponents.AbstractComponents;

public class ConsultationPage extends AbstractComponents {


	WebDriver driver;

	public ConsultationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@class='fa fa-calendar-days']")
	WebElement calender;

	
	public void goTocalender() throws InterruptedException
	{
		Thread.sleep(3000);
		calender.click();
	}

	public void selectDayforAppointment() throws InterruptedException
	{
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//mwl-calendar-month-cell[@class='cal-cell cal-day-cell cal-today cal-in-month ng-star-inserted']//div[@class='cal-cell-top ng-star-inserted']")).click();
	}
	
	@FindBy(xpath="//div[@class='ng-select-container']")
	WebElement patientSelection;
	
	@FindBy(xpath="//button[normalize-space()='Confirm']")
	WebElement cofirmButton;
	
	public void assignPatienttotheSlot() throws InterruptedException
	{
		
		waitElementToAppearByElement(patientSelection);
		patientSelection.click();
		
		driver.findElement(By.xpath("//ng-dropdown-panel[@aria-label='Options list']/div/div[2]/div[3]")).click();
		
		cofirmButton.click();
		
		Thread.sleep(3000);
		
	}
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement startConsultButton;
	
	public void startConsultation() throws InterruptedException
	{
		waitElementToAppearByElement(startConsultButton);
		Thread.sleep(2000);
		startConsultButton.click();
	}

}
