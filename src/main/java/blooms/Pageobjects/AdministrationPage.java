package blooms.Pageobjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import blooms.AbstractComponents.AbstractComponents;
import excelDataReader.UserDataReader;

public class AdministrationPage extends AbstractComponents {

	// Administration page web elements

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement emailId;

	@FindBy(xpath = "//input[@placeholder='License number']")
	WebElement liscenceNumber;

	@FindBy(xpath = "//ng-select[@placeholder='Please select speciality']//div[@class='ng-select-container']")
	WebElement speciality;

	@FindBy(xpath = "//span[normalize-space()='Cardiology']")
	WebElement specialityValue;

	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']")
	WebElement specilityExit;

	@FindBy(xpath = "//ng-select[@placeholder='Please select clinic name']//div[@role='combobox']")
	WebElement clinicDropdown;

	@FindBy(xpath = "//span[normalize-space()='Lissa Hospital']")
	WebElement clinicValue;

	@FindBy(xpath = "//ng-select[@placeholder='Please select clinic name']//span[@class='ng-arrow-wrapper']")
	WebElement clinicExit;

	@FindBy(xpath = "//div[@class='row my-3']//div[1]//input[1]")
	WebElement firstName;

	@FindBy(xpath = "//input[@formcontrolname='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	WebElement dob;

	@FindBy(xpath = "//input[@placeholder='Enter Number']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@title='Update profile picture']")
	WebElement profileImage;

	@FindBy(xpath = "//input[@title='Signature upload']")
	WebElement signatureImage;

	@FindBy(xpath = "//input[@placeholder='Enter National Id']")
	WebElement nationalID;

	@FindBy(xpath = "//textarea[@placeholder='Enter Address']")
	WebElement address;

	WebDriver driver;

	public AdministrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Administration page action methods

	public void doctordetailfetch() throws IOException, InterruptedException {

		excelDataReader.UserDataReader d = new excelDataReader.UserDataReader();
		ArrayList<String> data = d.getData("Doctor");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.doctorDetailAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4),
				data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}

	public void goToDoctors() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Doctors']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}

	public void specialitySelection(String specialityAdd) throws InterruptedException {
		Thread.sleep(2000);
		if (driver
				.findElements(By.xpath(
						"//ng-select[@placeholder='Please select speciality']//div[@class='ng-select-container']"))
				.size() > 0
				&& driver.findElement(By.xpath(
						"//ng-select[@placeholder='Please select speciality']//div[@class='ng-select-container']"))
						.isDisplayed()) {
			driver.findElement(
					By.xpath("//ng-select[@placeholder='Please select speciality']//div[@class='ng-select-container']"))
					.click();

			String specialities = "\"" + specialityAdd + "\"";
			String ROM = "//span[normalize-space()=" + specialities + "]" + "";
			waitElementToAppear(By.xpath(ROM));
			driver.findElement(By.xpath(ROM)).click();
			waitElementToAppear(
					By.xpath("//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']"));
			driver.findElement(
					By.xpath("//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']"))
					.click();
		}
	}

	public void clinicSelection(String nameofclinic) throws InterruptedException {
		waitElementToAppear(
				By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']"));
		if (driver
				.findElements(By.xpath(
						"//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']"))
				.size() > 0
				&& driver.findElement(By.xpath(
						"//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']"))
						.isDisplayed()) {
			driver.findElement(By
					.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']"))
					.click();
			String clinics = "\"" + nameofclinic + "\"";
			String ROM = "//span[normalize-space()=" + clinics + "]" + "";
			waitElementToAppear(By.xpath(ROM));
			driver.findElement(By.xpath(ROM)).click();

		}
	}

	public void genderSelection() {
		WebElement genderDropdown = driver.findElement(
				By.xpath("//select[@class='form-control cForm-control ng-untouched ng-pristine ng-invalid']"));

		Select dropdown = new Select(genderDropdown);

		dropdown.selectByValue("Male");
	}

	public void doctorDetailAddition(String typeofuser, String email, String lcnnumber, String specialityAdd,
			String nameofclinic, String firstname, String lastname, String Stringidno, String dobAdd, String gender,
			String number) throws InterruptedException {
		waitElementToAppearByElement(emailId);

		emailId.sendKeys(email);

		liscenceNumber.sendKeys(lcnnumber);

		specialitySelection(specialityAdd);

		clinicSelection(nameofclinic);

		waitElementToAppearByElement(firstName);

		firstName.sendKeys(firstname);

		lastName.sendKeys(lastname);

		dob.sendKeys(dobAdd);

		genderSelection();

		phoneNumber.sendKeys(number);
		
		String profileImagePath = System.getProperty("user.dir") + "/src/main/java/blooms/Resources/MediaInputFile/ProfileImage.jpg";

		profileImage.sendKeys(profileImagePath);

//		signatureImage.sendKeys("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/MediaFiles/Signature.png");

//		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	public void goToNurse() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[normalize-space()='Nurses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();

	}

	public void nursedetailfetch() throws IOException, InterruptedException {
		
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(".modal-body")).click();
	    
		excelDataReader.UserDataReader d = new excelDataReader.UserDataReader();
		ArrayList<String> data = d.getData("Nurse");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.nurseAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5),
				data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}

	public void nurseAddition(String typeofuser, String email, String lcnnumber, String speciality, String nameofclinic,
			String firstname, String lastname, String Stringidno, String dobAdd, String gender, String number)
			throws InterruptedException {

		waitElementToAppear(By.cssSelector(".modal-body"));

		driver.findElement(By.cssSelector(".modal-body")).click();

		waitElementToAppearByElement(emailId);

		emailId.sendKeys(email);

		clinicSelection(nameofclinic);

		waitElementToAppearByElement(firstName);

		firstName.sendKeys(firstname);

		lastName.sendKeys(lastname);

		dob.sendKeys(dobAdd);

		genderSelection();

		phoneNumber.sendKeys(number);

//		profileImage.sendKeys("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/MediaFiles/NurseImage.jpg");

//		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	public void goToPatient() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[normalize-space()='Patients']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}

	public void patientdetailfetch() throws IOException, InterruptedException {

		excelDataReader.UserDataReader d = new excelDataReader.UserDataReader();
		ArrayList<String> data = d.getData("Patient");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.patientAddition(data.get(1), data.get(7), data.get(5), data.get(6), data.get(8), data.get(9),
				data.get(10), data.get(11));
	}

	public void patientAddition(String email, String idno, String firstname, String lastname, String dobAdd,
			String gender, String number, String patientAddress) throws InterruptedException {

		waitElementToAppear(By.cssSelector(".modal-body"));

		emailId.sendKeys(email);

		nationalID.sendKeys(idno);

		firstName.sendKeys(firstname);

		lastName.sendKeys(lastname);

		dob.sendKeys(dobAdd);

		genderSelection();

		phoneNumber.sendKeys(number);

		address.sendKeys(patientAddress);

//		profileImage.sendKeys("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/MediaFiles/ProfileImage.jpg");

//		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	public void receptionistdetailfetch() throws IOException, InterruptedException {

		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getData("Receptionist");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.receptionAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4),
				data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}

	public void goToReceptionist() throws InterruptedException {
//		waitElementToAppear(By.xpath("//span[normalize-space()='Receptionists']"));
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[normalize-space()='Receptionists']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}

	public void receptionAddition(String typeofuser, String email, String lcnnumber, String speciality,
			String nameofclinic, String firstname, String lastname, String Stringidno, String dobAdd, String gender,
			String number) throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.cssSelector(".modal-body")).click();

		waitElementToAppearByElement(emailId);

		emailId.sendKeys(email);

		clinicSelection(nameofclinic);

		waitElementToAppearByElement(firstName);

		firstName.sendKeys(firstname);

		lastName.sendKeys(lastname);

		dob.sendKeys(dobAdd);

		genderSelection();

		phoneNumber.sendKeys(number);

//		profileImage.sendKeys("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/MediaFiles/NurseImage.jpg");

//		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/app-pages[1]/app-headersidnav[1]/div[1]/div[2]/div[1]/app-user-list-container[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/app-user-list-table-filter[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/table[1]/tr[1]/td[1]/div[1]")
	WebElement editButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	public void editandSubmit() throws InterruptedException {
		waitElementToAppearByElement(editButton);
		editButton.click();
		Thread.sleep(3000);
		submitButton.click();
	}

	@FindBy(xpath = "//input[@placeholder='Search for Names, Emails']")
	WebElement searchName;

	@FindBy(xpath = "//td[normalize-space()='Doctor']")
	WebElement resultName;

	public void usernameFetch() throws IOException, InterruptedException {
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getData("Doctor");
		searchName.sendKeys(data.get(5));
		waitElementToAppearByElement(resultName);
		resultName.isDisplayed();

	}

	public void searchUserName() throws IOException, InterruptedException {

		AdministrationPage adminsitrationpage = new AdministrationPage(driver);
		waitElementToAppearByElement(searchName);
		adminsitrationpage.usernameFetch();

	}

	@FindBy(xpath = "//*[contains(text(),' No Data Available ')]")
	WebElement invalidResult;

	public void invalidKeySearch() {
		waitElementToAppearByElement(searchName);
		searchName.sendKeys("Nonexist");
		waitElementToAppearByElement(invalidResult);
		invalidResult.isDisplayed();
	}

}
