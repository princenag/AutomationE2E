package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Abstractcomponents.Abstractcommponents;
import rahulshettyacademy.Testcomponents.BaseTests;
import rahulshettyacademy.pageobjects.Cartpage;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Confirmationpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.Orderhistorypage;
import rahulshettyacademy.pageobjects.Productcatalog;

public class submitordertest extends BaseTests {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitorder(HashMap<String, String> input) throws IOException, InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "/Users/raoma/Downloads/Nagendra-selenium/chromedriver-win64/chromedriver.exe");

		Productcatalog productcatalog = landingpage.loginaplication(input.get("email"), input.get("password"));

		List<WebElement> products = productcatalog.getproductlist();
		productcatalog.addproducttocart(input.get("productName"));
		// Thread.sleep(5000);
		Cartpage cartpage = productcatalog.gotocartpage();

		Boolean match = cartpage.verifyproductdisplayed(input.get("productName"));

		Assert.assertTrue(match);
		Checkoutpage checkoutpage = cartpage.checkoutpagecta();

		checkoutpage.selectcntrydropdown("india");

		Confirmationpage confirmpage = checkoutpage.submitorder();
		String confirmMessage = confirmpage.verifysuccessfulorder();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitorder" })
	public void OrderhistoryTest() {

		Productcatalog productcatalog = landingpage.loginaplication("nagendrrks@gmail.com", "Pursuit94");

		Orderhistorypage orderhistorypage = productcatalog.gotoorderpage();

		Boolean match = orderhistorypage.verifyitemsinOrderhstpage(productName);
		Assert.assertTrue(match);

	}

	@DataProvider
	public Object[][] getData() throws IOException

	{

		// using hashmap we can generalize more.,,but for each data set create different
		// hashmaps //method 2
//		HashMap<Object , Object> hash= new HashMap <Object , Object>();
//		hash.put("email", "nagendrrks@gmail.com");
//		hash.put("password", "Pursuit94");
//		hash.put("productName", "ZARA COAT 3");
//		
//		HashMap<Object , Object> hashh= new HashMap <Object , Object>();
//		hashh.put("email", "manasa95@gmail.com");
//		hashh.put("password", "Mana1124");
//		hashh.put("productName", "ADIDAS ORIGINAL");

		// data drivern sing json data and using jackson databind dpenecy //method 3
		List<HashMap<String, String>> data = getJsondata(
				System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//Productorder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
