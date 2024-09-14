package blooms.Pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blooms.AbstractComponents.AbstractComponents;
import excelDataReader.ClinicDataReader;

public class ClinicPage extends AbstractComponents {

	WebDriver driver;

	public ClinicPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// ClinicsPage WebElements

	@FindBy(xpath = "//span[normalize-space()='Clinic']")
	WebElement clinicHeader;

	@FindBy(xpath = "//button[normalize-space()='Add New Clinic']")
	WebElement addClinicButton;

	@FindBy(css = "input[placeholder='Enter Name']")
	WebElement clinicName;

	@FindBy(css = "textarea[placeholder='Enter Address']")
	WebElement clinicAddress;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadFile;

	@FindBy(xpath = "(//div[@class='cursor'][normalize-space()='Edit'])[1]")
	WebElement editButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement editUpdate;

	By editLocator = By.xpath("(//div[@class='cursor'][normalize-space()='Edit'])[1]");

	@FindBy(xpath = "//em[@class='fa-regular fa-circle-check fa-xl']")
	WebElement cropSave;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clinicSubmit;

//Clinic page Action methods

	public void clinicRedirection() throws InterruptedException {

		Thread.sleep(5000);
		By headerBy = By.xpath("//span[normalize-space()='Clinic']");

		waitElementToAppear(headerBy);

		clinicHeader.click();

	}

	public void addClinic() throws InterruptedException {
		Thread.sleep(5000);
		addClinicButton.click();
	}

	public void clinicAddition(String name, String address) throws InterruptedException {
		waitElementToAppearByElement(clinicName);
		clinicName.sendKeys(name);
		clinicAddress.sendKeys(address);
		uploadFile.sendKeys("/home/cubet/Desktop/Selenium/BloomsAutomationProject/Blooms/MediaFiles/logoimage.jpeg");
	}

	public void clinicdetailfetch() throws IOException, InterruptedException {

		ClinicDataReader d = new ClinicDataReader();
		ArrayList<String> data = d.getData("Clinic 1");
		ClinicPage clinicPage = new ClinicPage(driver);

		clinicPage.clinicAddition(data.get(1), data.get(2));
	}

	public void cropandSubmit() {
		cropSave.click();

//		clinicSubmit.click();
	}

	public void editClinicPage() throws InterruptedException {

		waitElementToAppearByElement(editButton);

		editButton.click();
		
		waitElementToAppearByElement(editUpdate);

		editUpdate.click();
	}

	@FindBy(xpath = "//input[@placeholder='Search for Clinic']")
	WebElement searchClinic;

	@FindBy(xpath = "//tbody/tr[3]/td[1]/div[1]/div[1]/div[1]")
	WebElement clinicresult;

	public void searchName() throws IOException, InterruptedException {
		ClinicDataReader d = new ClinicDataReader();
		ArrayList<String> data = d.getData("Clinic 1");
		waitElementToAppearByElement(searchClinic);
		searchClinic.sendKeys(data.get(1));
		waitElementToAppearByElement(clinicresult);
		clinicresult.isDisplayed();
	}

	@FindBy(xpath = "//li[@class='page-item ng-star-inserted']")
	List<WebElement> paginationButtons;
	@FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-clinicname mat-column-clinicname ng-star-inserted']")
	List<WebElement> nameList;
	@FindBy(xpath = "//div[@id='mat-tab-label-0-7']")
	WebElement clinicLabel;

	public void paginationExecution() throws InterruptedException {
	    Thread.sleep(3000);

	    int paginationSize = paginationButtons.size();

	    List<String> names = new ArrayList<String>();

	    for (int i = 1; i <= paginationSize; i++) {
	        String paginationSelector = "(//a[@class='page-link ng-star-inserted'])[" + i + "]";
	        driver.findElement(By.xpath(paginationSelector)).click();
	        Thread.sleep(2000);
	        List<WebElement> namesElements = nameList;

	        for (WebElement namesElement : namesElements) {
	            names.add(namesElement.getText());
	        }
	    }

//	    int totalNames = names.size();
//
//	    System.out.println("Total table count = " + totalNames);
//
//	    String clinicLabelText = clinicLabel.getText();
//	    String displayedCount = "0";
//
//	    // Split the label text safely
//	    if (clinicLabelText != null && !clinicLabelText.isEmpty()) {
//	        String[] parts = clinicLabelText.split(" ");
//	        if (parts.length > 1) {
//	            displayedCount = parts[1];
//	        }
//	    }
//
//	    System.out.println("Total displayed count " + displayedCount);
//
//	    // Ensure displayedCount is a number before comparison
//	    try {
//	        Assert.assertEquals(displayedCount, String.valueOf(totalNames));
//	    } catch (AssertionError e) {
//	        System.out.println("Assertion failed. Displayed count: " + displayedCount + ", Total names: " + totalNames);
//	        throw e; // rethrow the assertion error after logging
//	    }
//
//	    Thread.sleep(3000);
	}


	@FindBy(xpath = "//tbody/tr[1]/td[3]/div[1]/div[2]")
	WebElement deleteButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement deleteSubmit;

	public void deleteClinic() {
		deleteButton.click();

		deleteSubmit.click();
	}
}
