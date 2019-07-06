package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;

public class UserRegisterationWithDDTandDataProvider extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object [] [] {
			{"Mary", "Alfons", "testmail59212@gmail.com", "12345678"},{"Ahmed","Ali","testse0r96@gmail.com","1345678"}
			};
	}
	
	@Test (priority=1, alwaysRun=true, dataProvider="testData")
	public void UserCanRegistrationSuccessfully(String fname,String lname,String email,String password)
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userlogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userlogout();
	}
	

}
