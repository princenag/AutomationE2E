package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

public class Orderhistorypage extends Abstractcommponents {
WebDriver driver;
	public Orderhistorypage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css ="tr td:nth-child(3)")
	List<WebElement> OrderhistProducts;
	
	
	public boolean verifyitemsinOrderhstpage(String productName) {
		Boolean match = OrderhistProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

}
