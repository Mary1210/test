package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import data.ExcelReader;

public class UserRegistrationTestWithDDtAndExcel extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		//get data from Excel reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test (priority=1, alwaysRun=true, dataProvider="ExcelData")
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
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userlogout();
	}

}
