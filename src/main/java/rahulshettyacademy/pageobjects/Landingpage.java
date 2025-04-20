package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

//extends used to use common methods like waits , house over etc...
public class Landingpage extends Abstractcommponents {

	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// initelements uses driver argument to intialize all the webelements using
		// findby annotation
	}

//	WebElement usremail= driver.findElement(By.id("userEmail"));
//	WebElement usrpwd= driver.findElement(By.id("userPassword"));
	// WebElement logincta= driver.findElement(By.id("login"));
	// pagefactory
	@FindBy(id = "userEmail")
	WebElement usremail;

	@FindBy(id = "userPassword")
	WebElement usrpwd;

	@FindBy(id = "login")
	WebElement logincta;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errormsg;
	// class="ng-tns-c4-19 ng-star-inserted ng-trigger ng-trigger-flyInOut
	// ngx-toastr toast-error"

	public Productcatalog loginaplication(String email, String password)

	{
		usremail.sendKeys(email);
		usrpwd.sendKeys(password);
		logincta.click();
		Productcatalog productcatalog = new Productcatalog(driver);
		return productcatalog;
	}

	public String geterrormsg()

	{
		waitForbyelementtoappear(errormsg);
		return errormsg.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");

	}

}
