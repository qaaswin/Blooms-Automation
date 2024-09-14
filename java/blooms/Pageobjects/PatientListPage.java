package blooms.Pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import blooms.AbstractComponents.AbstractComponents;

public class PatientListPage extends AbstractComponents{
	
	WebDriver driver;
	
	//Constructor which has same class name and it execute before anything inside the the class
	public PatientListPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@class='fa fa-chalkboard-user']")
	WebElement patientList;
	
	public void goToPatientList() throws InterruptedException
	{
		Thread.sleep(3000);
		patientList.click();
		
	}
	

	@FindBy(xpath="//tbody/tr[1]/td[1]")
	WebElement viewPtientListButton;
	
	public void viewPatientDetails() throws InterruptedException
	{
		waitElementToAppearByElement(viewPtientListButton);
		viewPtientListButton.click();
		
	}
	
	@FindBy(xpath="//button[@class='p-ripple p-element p-button-outlined p-button-sm prime-sm-btn p-button p-component']")
	WebElement referButton;
	
	@FindBy(xpath="//div[@class='ng-select-container']")
	WebElement referClinicSelection;
	
	@FindBy(xpath="//div[@class='ng-select-container']")
	WebElement referdoctorSelection;
	
	
	@FindBy(xpath="//div[@class='ng-option ng-star-inserted'][1]")
	WebElement referdropdownvalue;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	
	
	public void refermyPatient() throws InterruptedException
	{
		Thread.sleep(3000);
		referButton.click();
		waitElementToAppearByElement(referClinicSelection);
		referClinicSelection.click();
		referdropdownvalue.click();
		referdoctorSelection.click();
		waitElementToAppearByElement(referdropdownvalue);
		referdropdownvalue.click();
		submitButton.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Add Insurance')]")
	WebElement addInsuranceButton;
	
	@FindBy(xpath="//input[@placeholder='Enter Name']")
	WebElement insuranceName;
	
	@FindBy(xpath="//input[@placeholder='Enter Plan']")
	WebElement insurancePlan;
	
	@FindBy(xpath="//input[@placeholder='Enter Group ID']")
	WebElement insuranceGroupID
	;
	
	@FindBy(xpath="//input[@placeholder='Enter Insurance ID']")
	WebElement insuranceID;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Address']")
	WebElement insurnceAddress;

	
	public void addInsurance() throws InterruptedException
	{
		waitElementToAppearByElement(addInsuranceButton);
		addInsuranceButton.click();
		waitElementToAppearByElement(insuranceName);
		insuranceName.clear();
		Thread.sleep(2000);
		insuranceName.sendKeys("Sample Insurance");
		insurancePlan.sendKeys("Sample Plan");
		insuranceGroupID.sendKeys("Sample group ID");
		insuranceID.sendKeys("Sample");
		insurnceAddress.sendKeys("Address");
		
		submitButton.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//span[@mattooltip='Edit Insurance Details']")
	WebElement EditInsuranceButton;
	
	public void editInsurance() throws InterruptedException
	{
		waitElementToAppearByElement(EditInsuranceButton);
		EditInsuranceButton.click();
		waitElementToAppearByElement(submitButton);
		submitButton.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//div[contains(text(),'Patient Documents')]")
	WebElement patientDocTab;
	
	@FindBy(xpath="//div[contains(text(),'Wearable Info')]")
	WebElement WearableInfoTab;
	
	
	public void swapTabs() throws InterruptedException
	{
		Thread.sleep(5000);
		patientDocTab.click();
		waitElementToAppearByElement(WearableInfoTab);
		WearableInfoTab.click();
		
	}

}
