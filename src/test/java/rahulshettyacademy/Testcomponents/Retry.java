package rahulshettyacademy.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//to rerun failed testcase we use Iretryanalayzer and we need to use this class and as well in @test annotation user retryanalyzer 
	//tagging for specific tests which we feel might fail during execution
	int count = 0;
	int maxtry = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count < maxtry) {
			count++;
			return true;
		}

		return false;

	}

}
