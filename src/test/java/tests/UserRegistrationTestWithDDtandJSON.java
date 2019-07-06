package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import data.JsonDataReader;

public class UserRegistrationTestWithDDtandJSON extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Test (priority=1, alwaysRun=true)
	public void UserCanRegistrationSuccessfully() throws JsonIOException, JsonSyntaxException, IOException, ParseException
	{
		JsonDataReader jsonRead = new JsonDataReader();
		jsonRead.JsonReader();
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration(jsonRead.firstname, jsonRead.lastname, jsonRead.email, jsonRead.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userlogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(jsonRead.email, jsonRead.password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}



}
