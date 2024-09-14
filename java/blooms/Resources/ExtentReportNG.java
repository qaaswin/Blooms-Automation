package blooms.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject()
	{
	
	//helper class
	String path = System.getProperty("user.dir") + "/reports/index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Blooms Automation Project");
	reporter.config().setDocumentTitle("BloomsEMR Test Resut");
	
	//main class
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Test Executed By", "Aswin M K");
	return extent;
	}

}
