package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

public class Productcatalog extends Abstractcommponents {

	WebDriver driver;

	public Productcatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsby = By.cssSelector(".mb-3");
	By addproduct = By.xpath(".//div[@class='card-body']/button[2]");
	By toastmsg = By.cssSelector("#toast-container");

	public List<WebElement> getproductlist() {
		waitForelementtoappear(productsby);
		return products;
	}

	public WebElement getproductbyName(String productName) {

		WebElement prod = getproductlist().stream().filter(product ->

		product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addproducttocart(String productName) {
		WebElement prod = getproductbyName(productName);
		prod.findElement(addproduct).click();
		waitForelementtoappear(toastmsg);
		waitForelementtodisappear(spinner);

	}

}
