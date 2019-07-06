package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import data.LoadProperties;


public class UserRegisterationWithDDTandPropertiesfile extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email= LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
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
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
