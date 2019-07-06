package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	EmailPage emailObject;
	
	// 1-User registeration
	@Test (priority=1, alwaysRun=true)
	public void UserCanRegistrationSuccessfully()
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mary", "Alfons", "tesail5822@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	// 2- Search for products
	
	@Test (priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try
		{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		}
		catch(Exception e)
		{
			System.out.println("Error occured " + e.getMessage());
		}
	}
	// 3- Email to friend
	
	@Test (priority=3)
	public void RegisterUserCanSendProductToFriend()
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailFriend("aaa@ttt.com", "Hello my friend");
		Assert.assertTrue(emailObject.messagenotification.getText().contains("Your message has been sent"));
	}
	
	
	// 4- Logout
	
	@Test (priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
	}

}
