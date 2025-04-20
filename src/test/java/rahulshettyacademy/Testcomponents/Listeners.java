package rahulshettyacademy.Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.Resources.ExtentrepoterNG;

public class Listeners extends BaseTests implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentrepoterNG.getReportObject();
ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();//thread safe bcz while paralel execution it falsely send failure to different testname
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" + result.getName());
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);// assign one unique id;
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method" + result.getName());
		extenttest.get().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method" + result.getName());
		extenttest.get().log(Status.FAIL, "Test Failed");
	extenttest.get().fail(result.getThrowable());
		// below try catch is for to get instance of driver to getscreenshot method
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileimgpath = null;
		try {
			fileimgpath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// screenshot
		extenttest.get().addScreenCaptureFromPath(fileimgpath, result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage" + result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		extent.flush();
	}

}
