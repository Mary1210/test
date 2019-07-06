package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegistrationTestWithjavaFaker extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password =fakeData.number().digits(8).toString();

	@Test (priority=1, alwaysRun=true)
	public void UserCanRegistrationSuccessfully()
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test (dependsOnMethods = {"UserCanRegistrationSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
	}

	@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisterUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}



}
