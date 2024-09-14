package blooms.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import blooms.Pageobjects.BookSlotPage;
import blooms.Pageobjects.ConsultationPage;
import blooms.TestComponents.BaseTest;



public class Consultaion extends BaseTest{
	
	@Test
	public void bookASlot() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    ConsultationPage consultationPage = new ConsultationPage(driver);
	    @SuppressWarnings("unused")
		BookSlotPage bookslotpage = new BookSlotPage(driver);

	    consultationPage.goTocalender();

	    Thread.sleep(3000); // Consider replacing with a more precise wait if needed

	        WebElement emptySlot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='month-slot slot-info ng-star-inserted']")));
	        if (emptySlot.isDisplayed()) {
	            emptySlot.click();
	            consultationPage.assignPatienttotheSlot(); // This method is called only if empty slot is found
	        }
	    } 

}