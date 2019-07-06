package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishListPage;

public class AddProductToWishList extends TestBase{
	String productName="HTC One Mini Blue";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistobject;

	@Test (priority=1)
	public void UserCanSearchWithAutoSuggest()
	{

		searchObject =new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("HTC");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}

	@Test (priority=2)
	public void UserCanAddProductToWishList() 
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishlistobject = new WishListPage(driver);
		Assert.assertTrue(wishlistobject.WishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistobject.ProductCell.getText().contains(productName));

	}
	
	@Test (priority=3)
	public void UserCanRemoveProductFromCart()
	{
		wishlistobject = new WishListPage(driver);
		wishlistobject.removeProductFromCart();
		Assert.assertTrue(wishlistobject.EmptyCartbl.getText().contains("empty!"));
	}


}
