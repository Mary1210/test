package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	String oldPassword="123456";
	String newPassword="12345678";
	String firstName="Mary";
	String lastName="Alfons";
	String email = "testmail16822@gmail.com";

	
	@Test (priority=1)
	public void UserCanRegistrationSuccessfully()
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName,  email , oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test (priority=2)
	public void RegisteredUserCanChangePassword()
	{
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.Changepassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		
	}
	@Test (dependsOnMethods = {"RegisteredUserCanChangePassword"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
	}
	
	@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisterUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email , newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	

}
