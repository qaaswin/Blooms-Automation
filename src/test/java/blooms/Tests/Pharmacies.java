package blooms.Tests;


import org.testng.annotations.Test;

import java.io.IOException;
import blooms.Pageobjects.PharmacyPage;
import blooms.TestComponents.BaseTest;

public class Pharmacies extends BaseTest {
	
	@Test 
	public void AddPharmacy() throws InterruptedException, IOException
	{
		
//		extent.createTest("doctorAddition");
		
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.pharamacyAdd();
		pharmacyPage.pharmacydetailfetch();
//		pharmacyPage.pharmacySubmit();
		
	}
	
	@Test
	public void searchPharmacy() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.searchPharmacyName();
	}
	
	@Test
	public void invalidEmailAlert() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.pharamacyAdd();
		pharmacyPage.pharmacyinvalidEmailfetch();
		pharmacyPage.pharmacySubmit();
		pharmacyPage.invalidEmailAlertCheck();
		
	}
	
	@Test
	public void invalidPhoneAlert() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.pharamacyAdd();
		pharmacyPage.invalidNumberCheck();
		pharmacyPage.invalidPhone();
	}
	
	@Test
	public void existingMailCheck() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.pharamacyAdd();
		pharmacyPage.existingMailFetch();
		pharmacyPage.pharmacySubmit();
		pharmacyPage.existingAlertCheck();
		
	}



}
