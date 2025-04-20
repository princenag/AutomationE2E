package rahulshettyacademy.stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import rahulshettyacademy.Testcomponents.BaseTests;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.Productcatalog;

public class Errorvalidstepdefination extends BaseTests{

	public Landingpage landingpage;
	public Productcatalog productcatalog;
	
	@Given("user landed on Ecommerece site")
	public void user_landed_on_Ecommerece_site() throws Exception 
	{
		landingpage=launchapplication();
	}

	
	@Given ("^login with usernae (.+) and password (.+)$")
    public void login_with_usernae_and_password(String name, String Password)
    {
		 productcatalog = landingpage.loginaplication(name , Password);

    }
	
//	@Then ("\"([^\"]*)\" error message is displayed correctly")
//	public void verify_the_errormessage_display_correctly(String  strings) {
//		String errmsg = landingpage.geterrormsg();
//		Assert.assertEquals(errmsg, strings);
//	}
	
	@Then("{string} error message is displayed correctly")
	public void error_message_is_displayed_correctly(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
		Assert.assertEquals(landingpage.geterrormsg(), string);
	}
}
