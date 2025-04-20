package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Abstractcomponents.Abstractcommponents;
import rahulshettyacademy.Testcomponents.BaseTests;
import rahulshettyacademy.Testcomponents.Retry;
import rahulshettyacademy.pageobjects.Cartpage;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Confirmationpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.Productcatalog;

public class Errorvalidationtest extends BaseTests {

	@Test(groups = { "Errorhandling" }, retryAnalyzer = Retry.class)
	public void loginerrorvalidtn() throws IOException {
		// String productName = "ZARA COAT 3";

		landingpage.loginaplication("manasa9@gmail.com", "Pursuit");
		String errmsg = landingpage.geterrormsg();
		AssertJUnit.assertEquals(errmsg, "Incorrect email or password.");
	}

	@Test
	public void Producterrorvalidtn() throws IOException {
		String productName = "ZARA COAT 3";

		Productcatalog productcatalog = landingpage.loginaplication("manasa95@gmail.com", "Mana1124");

		List<WebElement> products = productcatalog.getproductlist();
		productcatalog.addproducttocart(productName);
		Cartpage cartpage = productcatalog.gotocartpage();

		Boolean match = cartpage.verifyproductdisplayed("ZARA COAT 35");

		Assert.assertFalse(match);

	}

}
