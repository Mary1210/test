package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	
	@Test
	public void UserCanSearchForProducts() 
	{
		detailsObject = new ProductDetailsPage(driver);
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
	
		//Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
	

}
