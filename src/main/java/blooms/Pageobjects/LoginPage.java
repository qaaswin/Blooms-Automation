package blooms.Pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import blooms.AbstractComponents.AbstractComponents;
import excelDataReader.CredentialDataReader;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	//Constructor which has same class name and it execute before anything inside the the class
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void goToURL()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bloomsemr.cubettech.in/");
	}	
	

//	WebElement emailId = driver.findElement(By.xpath("//input[@placeholder='Email id']"));
	@FindBy(xpath = "//input[@placeholder='Email id']")
	WebElement emailId;
	
//	WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement userPassword;
	
	@FindBy(xpath = "//button[@value='Login']")
	WebElement loginButton;
	
	
	public void loginApplication(String email,String password) throws IOException
	{
	emailId.sendKeys(email);
	userPassword.sendKeys(password);
	loginButton.click();
	}
	
	public void credentialFetcher() throws IOException
	{
		CredentialDataReader authData = new CredentialDataReader();
		ArrayList<String> data = authData.getData("Credential 1");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginApplication(data.get(1), data.get(2));
	}
	
	@FindBy(xpath = "//div[@class='ng-select-container']")
	WebElement clinicDropDown;
	
	@FindBy(xpath = "//div[@role='option'][1]")
	WebElement clinicValue;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clinicSubmit;
	
	public void primaryClinicSelector()
	{
		clinicDropDown.click();
		
		clinicValue.click();
		
		clinicSubmit.click();
	}
	
	

}
