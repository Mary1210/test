package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;

public class AddProductToShoppingCart extends TestBase{
	String productName="HTC One Mini Blue";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	
	@Test(priority=1)
	public void UserCanSearchWithAutoSuggest()
	{
		
		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("HTC");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("$100.00"));
	}
	
	@Test(priority=3)
	public void UserCanRemoveProductFromCart()
	{
		cartPage = new ShoppingCartPage(driver);
		cartPage.RemoveProductFromCart();
	}

}
