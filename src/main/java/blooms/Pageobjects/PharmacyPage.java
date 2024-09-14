package blooms.Pageobjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blooms.AbstractComponents.AbstractComponents;
import excelDataReader.PharmacyDataReader;

public class PharmacyPage extends AbstractComponents {

	WebDriver driver;

	public PharmacyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[formcontrolname='pharmacy_name']")
	WebElement pharmacyName;

	@FindBy(css = "input[formcontrolname='pharmacy_email']")
	WebElement pharmacyEmail;

	@FindBy(css = "input[formcontrolname='pharmacy_phone_number']")
	WebElement pharmaNumber;

	@FindBy(css = "textarea[placeholder='Enter Address']")
	WebElement pharmaAddress;

//	@FindBy(css = "button[type='submit']" )
//	WebElement submit ;
	
	public void goToPharmacy() throws InterruptedException
	{
//		waitElementToAppear(By.xpath("//span[normalize-space()='Pharmacy']"));
		Thread.sleep(6000);

		WebElement clinicElement = driver.findElement(By.xpath("//span[normalize-space()='Pharmacy']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clinicElement);
		
	}
	public void pharamacyAdd() throws InterruptedException
	{
		Thread.sleep(9000);
//		waitElementToAppear(By.cssSelector("button[class='btn btn-sm btn-primary cButton']"));
		driver.findElement(By.cssSelector("button[class='btn btn-sm btn-primary cButton']")).click();
	}

	public void pharmacyDetailAddition(String name, String email, String number, String address) {
		pharmacyName.sendKeys(name);
		pharmacyEmail.sendKeys(email);
		pharmaNumber.sendKeys(number);
		pharmaAddress.sendKeys(address);

	}
	
	public void pharmacydetailfetch() throws IOException {

		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmData = d.getData("Pharmacy 1");
		PharmacyPage pharmacyPage = new PharmacyPage(driver);

		pharmacyPage.pharmacyDetailAddition(pharmData.get(1), pharmData.get(2), pharmData.get(3), pharmData.get(4));
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Pharmacy']")
	WebElement pharmacySearch;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]")
	WebElement searchResult;
	
	public void searchPharmacyName() throws IOException, InterruptedException
	{
//		Thread.sleep(4000);
		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmdata = d.getData("Pharmacy 1");
		waitElementToAppearByElement(pharmacySearch);
		pharmacySearch.sendKeys(pharmdata.get(1));
		waitElementToAppearByElement(searchResult);
		searchResult.isDisplayed();
	}
	
	public void pharmacyinvalidEmailfetch() throws IOException {

		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmData = d.getData("Pharmacy 2");
		PharmacyPage pharmacyPage = new PharmacyPage(driver);

		pharmacyPage.pharmacyDetailAddition(pharmData.get(1), pharmData.get(2), pharmData.get(3), pharmData.get(4));
	}
	
	@FindBy(css = "button[type='submit']")
	WebElement submitPhramcyButton;
	
	public void pharmacySubmit()
	{
		submitPhramcyButton.click();
	}
	
	@FindBy(xpath = "//small[normalize-space()='Enter a valid Email']")
	WebElement invalidMail;
	
	public void invalidEmailAlertCheck()
	{
		waitElementToAppearByElement(invalidMail);
		invalidMail.isDisplayed();
	}
	
	public void invalidNumberCheck() throws IOException
	{
		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmData = d.getData("Pharmacy 3");
		PharmacyPage pharmacyPage = new PharmacyPage(driver);

		pharmacyPage.pharmacyDetailAddition(pharmData.get(1), pharmData.get(2), pharmData.get(3), pharmData.get(4));
	}
	
	@FindBy(xpath = "//small[contains(text(),'Enter a valid mobile number with minimum 7 & maxim')]")
	WebElement invalidPhoneAlert;
	
	public void invalidPhone()
	{
		invalidPhoneAlert.isDisplayed();
	}
	
	public void existingMailFetch() throws IOException
	{
		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmData = d.getData("Pharmacy 4");
		PharmacyPage pharmacyPage = new PharmacyPage(driver);

		pharmacyPage.pharmacyDetailAddition(pharmData.get(1), pharmData.get(2), pharmData.get(3), pharmData.get(4));
	}
	
	@FindBy(xpath = "//div[@aria-label='Email already Exists']")
	WebElement existingMailAlert;
	
	public void existingAlertCheck() throws InterruptedException
	{
		waitElementToAppearByElement(existingMailAlert);
		existingMailAlert.isDisplayed();
	}
}
