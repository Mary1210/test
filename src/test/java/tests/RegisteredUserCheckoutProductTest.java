package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegisterationPage;

public class RegisteredUserCheckoutProductTest extends TestBase
{
	/*
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to Cart
	 * 4- Checkout
	 * 5- Logout 
	 */

	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject ; 
	String productName = "HTC One Mini Blue"; 
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	ShoppingCartPage cartPage ; 
	CheckoutPage checkoutObject ; 
	OrderDetailsPage orderObject;

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegisteration("Moataz", "Nabil", "sddf15g2@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new SearchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("HTC");
			detailsObject = new ProductDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

	@Test(priority=3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("100"));
	}

	@Test(priority=4)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartPage.OpenCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetailsPage(driver);
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	
	}

	@Test(priority=5)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userlogout();
	}
}
