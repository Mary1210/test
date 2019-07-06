package steps;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

//import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.UserRegisterationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.TestBase;

public class UserRegisteration extends TestBase{

	HomePage home;
	UserRegisterationPage registerObject;
	/*Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();*/


	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() throws InterruptedException  {
		home = new HomePage(driver);
		home.openRegisterationPage();

	}

	@When("^I click on register link$")
	public void i_click_on_register_link() {
		
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS) ;

	}

	/*@When("^I entered the user data$")
	public void i_entered_the_user_data() {
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);

	}*/


	@When("^I entered \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password)  {
		registerObject = new UserRegisterationPage(driver);
		
		
		registerObject.userRegisteration(firstname, lastname,email,password);
		

	}
	@Then("^The registeran page displayed successfully$")
	public void the_registeran_page_displayed_successfully() {
		registerObject.userlogout();

	}

}
