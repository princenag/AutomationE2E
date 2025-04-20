package rahulshettyacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentrepoterNG {

	
	public static ExtentReports getReportObject()
	{
		
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter Esr = new ExtentSparkReporter(path);
		Esr.config().setReportName("Web automation results");
		Esr.config().setDocumentTitle("Test results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Esr);
		extent.setSystemInfo("Tester", "Nagendra kumar");
		return extent;
		
	}
}
