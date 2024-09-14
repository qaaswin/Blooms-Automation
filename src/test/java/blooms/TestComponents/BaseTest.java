package blooms.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import blooms.Pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public ExtentReports extent;
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/blooms/Resources/GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
			//Headless mode
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--remote-allow-origins=*");
			// Configure ChromeDriver logging
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    options.addArguments("--remote-allow-origins=*");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--disable-software-rasterizer");


		    // Set ChromeDriver log path with verbose logging
		    System.setProperty("webdriver.chrome.logfile", System.getProperty("user.dir") + "/chromedriver.log");
		    System.setProperty("webdriver.chrome.verboseLogging", "true");

		    driver = new ChromeDriver(options);






//            driver = new ChromeDriver(options);

		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	
//	public String getScreenshot(String testCaseName) throws IOException
//	{
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir")+"/reports/" + testCaseName + ".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
//	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Email id']")
	WebElement eamilID;
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		loginpage = new LoginPage(driver);
		loginpage.goToURL();
		loginpage.credentialFetcher();
		loginpage.primaryClinicSelector();
		return loginpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Blooms Automation Result");
		reporter.config().setDocumentTitle("BloomsEMR");
		
		//main class
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Executed By", "Aswin M K");
		
	}
	
	
	
}
