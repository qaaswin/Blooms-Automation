package blooms.Tests;


import org.testng.annotations.Test;

import java.io.IOException;
import blooms.Pageobjects.ClinicPage;
import blooms.TestComponents.BaseTest;

public class Clinics extends BaseTest {
	
	

	
@Test 
public void webdClinicAddition() throws InterruptedException, IOException
{
	
//		extent.createTest("doctorAddition");
		

		loginpage.goToAdministration();
		
		ClinicPage clinicpage = new ClinicPage(driver);
		
		clinicpage.clinicRedirection();
		
		clinicpage.addClinic();
		
		clinicpage.clinicdetailfetch();
		
		clinicpage.cropandSubmit();
		
		
}

@Test 
public void webeditClinic() throws InterruptedException, IOException
{
	
//	extent.createTest("doctorAddition");
	
	loginpage.goToAdministration();
	
	ClinicPage clinicPage = new ClinicPage(driver);
	
	clinicPage.clinicRedirection();
	
	clinicPage.editClinicPage();
	
	
}

@Test
public void websearchClinic() throws InterruptedException, IOException
{
	ClinicPage clinicPage = new ClinicPage(driver);
	
	clinicPage.goToAdministration();
	
	clinicPage.clinicRedirection();
	
	clinicPage.searchName();
	
}

@Test
public void webpaginationCheck() throws InterruptedException
{
	ClinicPage clinicPage = new ClinicPage(driver);
	
	clinicPage.goToAdministration();
	
	clinicPage.clinicRedirection();
	
	clinicPage.paginationExecution();;
	
}

@Test
public void webdeleteClinic() throws InterruptedException
{
	ClinicPage clinicPage = new ClinicPage(driver);
	
	clinicPage.goToAdministration();
	
	clinicPage.clinicRedirection();
	
	clinicPage.deleteClinic();;
}







}
