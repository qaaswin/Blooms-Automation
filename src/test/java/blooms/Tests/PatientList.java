package blooms.Tests;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import blooms.Pageobjects.PatientListPage;
import blooms.TestComponents.BaseTest;



public class PatientList extends BaseTest {
	
	
	@Test
	public void webReferMyPatient() throws InterruptedException
	{
		PatientListPage patientlistPage = new PatientListPage(driver);
		patientlistPage.goToPatientList();
		patientlistPage.viewPatientDetails();
		patientlistPage.refermyPatient();
		
	}

//	@Test
	public void insuranceAddition() throws InterruptedException {
	    PatientListPage patientlistPage = new PatientListPage(driver);
	    patientlistPage.goToPatientList();
	    patientlistPage.viewPatientDetails();
	    
	    // Use findElements instead of findElement
	    java.util.List<WebElement> buttons = driver.findElements(By.xpath("//span[contains(text(),'Add Insurance')]"));
	    
	    if (buttons.isEmpty()) {
	        // If the list is empty, the element is not present
	        System.out.println("Add Insurance button not found. Executing editInsurance().");
	        patientlistPage.editInsurance();
	    } else {
	        // If the list is not empty, the element is present
	        WebElement button = buttons.get(0);
	        if (button.isDisplayed()) {
	            System.out.println("Found and displayed 'Add Insurance' button, executing addInsurance()...");
	            patientlistPage.addInsurance();
	        } else {
	            System.out.println("'Add Insurance' button is not displayed. Executing editInsurance().");
	            patientlistPage.editInsurance();
	        }
	    }
	}
	
	@Test
	public void swapthePages() throws InterruptedException
	{
		PatientListPage patientlistPage = new PatientListPage(driver);
		patientlistPage.goToPatientList();
		patientlistPage.viewPatientDetails();
		patientlistPage.swapTabs();
	}

}
