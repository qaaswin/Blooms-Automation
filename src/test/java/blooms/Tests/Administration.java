package blooms.Tests;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import java.io.IOException;
import blooms.Pageobjects.AdministrationPage;
import blooms.TestComponents.BaseTest;



public class Administration extends BaseTest {
	
	ExtentReports extent;
	
	
@Test
public void webAddDoctor() throws InterruptedException, IOException
{
		
		
		AdministrationPage administrationpage = new AdministrationPage(driver);
		
		loginpage.goToAdministration();
		
		administrationpage.goToDoctors();

		
		administrationpage.doctordetailfetch();
		
		
	}
@Test
public void webAddNurse() throws IOException, InterruptedException
{
	
	AdministrationPage administrationpage = new AdministrationPage(driver);
	
	loginpage.goToAdministration();
	
	administrationpage.goToNurse();
    
    administrationpage.nursedetailfetch();
    
}

@Test
public void webAddPatient() throws InterruptedException, IOException
{
	
	AdministrationPage administrationpage = new AdministrationPage(driver);
	
	loginpage.goToAdministration();

    administrationpage.goToPatient();
    
    administrationpage.patientdetailfetch();

}

//@Test
public void webAddReceptionist() throws InterruptedException, IOException
{
	
    AdministrationPage administrationpage = new AdministrationPage(driver);

    administrationpage.goToAdministration();
    
    administrationpage.goToReceptionist();
    
    administrationpage.receptionistdetailfetch();
}

@Test
public void webeEditUser() throws InterruptedException, IOException
{

	
    AdministrationPage administrationpage = new AdministrationPage(driver);

    administrationpage.goToAdministration();
 
    administrationpage.editandSubmit();
}

@Test
public void webSearchUser() throws InterruptedException, IOException
{
	
	
    AdministrationPage administrationpage = new AdministrationPage(driver);

    administrationpage.goToAdministration();
   
    administrationpage.searchUserName();
}

@Test
public void searchWithInvalidKeyword() throws InterruptedException, IOException
{
    AdministrationPage administrationpage = new AdministrationPage(driver);

    administrationpage.goToAdministration();

    administrationpage.invalidKeySearch();
    
    
}


}
