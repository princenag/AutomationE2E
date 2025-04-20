package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcommponents;

public class Confirmationpage extends Abstractcommponents{
WebDriver driver;
	public Confirmationpage(WebDriver driver) {
		//TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css = ".hero-primary")
	WebElement confirmmsg;
	
	public String verifysuccessfulorder()
	{
		return confirmmsg.getText();
	}
}
