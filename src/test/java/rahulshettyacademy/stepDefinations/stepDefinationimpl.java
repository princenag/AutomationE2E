package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.Testcomponents.BaseTests;
import rahulshettyacademy.pageobjects.Cartpage;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Confirmationpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.Productcatalog;

public class stepDefinationimpl  extends BaseTests{
	
	public Landingpage landingpage;
	public Productcatalog productcatalog;
	public Confirmationpage confirmpage;
	
	@Given("i landed on Ecommerece site")
	public void i_landed_on_Ecommerece_site() throws IOException
	{
		landingpage=launchapplication();
	}

    @Given ("^login with username (.+) and password (.+)$")
    public void login_with_username_and_password(String name, String Password)
    {
		 productcatalog = landingpage.loginaplication(name , Password);

    }

    @When ("^i add product (.+) to cart$")
    public void i_add_product_to_cart(String productname)
    {
    	List<WebElement> products = productcatalog.getproductlist();
		productcatalog.addproducttocart(productname);
    }
    
    @And ("^checkout (.+) and submit the order$")
    public void check_product_and_submit_order(String productname){
    	
    	Cartpage cartpage = productcatalog.gotocartpage();

		Boolean match = cartpage.verifyproductdisplayed(productname);

		Assert.assertTrue(match);
		Checkoutpage checkoutpage = cartpage.checkoutpagecta();

		checkoutpage.selectcntrydropdown("india");

		 confirmpage = checkoutpage.submitorder();
    }
    
    @Then  ("{string} message is displayed on confirmationpage")
    public void verify_message_on_confirmationpage(String string) {
    	
    	String confirmMessage = confirmpage.verifysuccessfulorder();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }
    
 
    		


	
}
