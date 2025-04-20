package rahulshettyacademy.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.Cartpage;
import rahulshettyacademy.pageobjects.Orderhistorypage;

public class Abstractcommponents {
	WebDriver driver;

	public Abstractcommponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css ="[routerlink*='cart']")
	WebElement carticon;

	@FindBy(css ="[routerlink*='myorders']")
	WebElement orderheader;

	public void waitForelementtoappear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForbyelementtoappear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void waitForelementtodisappear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

	public Cartpage gotocartpage() {
		carticon.click();
		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
	}

	public Orderhistorypage gotoorderpage() {
		orderheader.click();
		Orderhistorypage orderhistorypage = new Orderhistorypage(driver);
		return orderhistorypage;
	}

}
