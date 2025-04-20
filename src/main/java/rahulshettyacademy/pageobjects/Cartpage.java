package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

public class Cartpage extends Abstractcommponents {
	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartproducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutcta;

	public boolean verifyproductdisplayed(String productName) {
		Boolean match = cartproducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public Checkoutpage checkoutpagecta() {
		checkoutcta.click();
		Checkoutpage checkoutpage=new Checkoutpage(driver);
		return checkoutpage;
	}
}
