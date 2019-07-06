package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductReviewPage;
import Pages.SearchPage;
import Pages.UserRegisterationPage;


public class AddProductReviewTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	ProductReviewPage ReviewObject;
	
	// 1-User registeration
	@Test (priority=1, alwaysRun=true)
	public void UserCanRegistrationSuccessfully()
	{
		homeObject =new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject= new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mary", "Alfons", "teail5822@gmail.com", "12345678");
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
	
	//3- Add Review
	@Test (priority=3)
	public void RegisteredUserCanAddReview()
	{
		detailsObject.openAddReviewPage();
		ReviewObject = new ProductReviewPage(driver);
		ReviewObject.AddProductReview("new review message", "The product is very good");
		Assert.assertTrue(ReviewObject.reviewNotification.getText().contains("Product review is successfully added"));
	}
	

	// 4- Logout
	
	@Test (priority=4)
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
	}

}
