package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

public class Checkoutpage extends Abstractcommponents {
	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectcntry;

	@FindBy(css = ".action__submit")
	WebElement submit;
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;

	By countrydisplayed = By.cssSelector(".ta-results");

	public void selectcntrydropdown(String country) {

		Actions a = new Actions(driver);

		a.sendKeys(selectcntry, country).build().perform();
		waitForelementtoappear(countrydisplayed);

		selectcountry.click();

		

	}
	
	public Confirmationpage submitorder()
	{
		submit.click();
		Confirmationpage confirmpage= new Confirmationpage(driver);
		return confirmpage;
	}
}
