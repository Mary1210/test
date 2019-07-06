package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@Test (priority=1, alwaysRun=true)
	public void UserCanRegistrationSuccessfully()
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mary", "Alfons", "testmail5822@gmail.com", "12345678");
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
		loginObject.UserLogin("testmail5822@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	

}
