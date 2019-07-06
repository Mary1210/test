package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test (priority=1)
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		
	}
	
	@Test (priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try
		{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		Assert.assertTrue(detailsObject.ProductPriceLbl.getText().contains("Ђ"));
		System.out.println(detailsObject.ProductPriceLbl.getText());
		}
		catch(Exception e)
		{
			System.out.println("Error occured " + e.getMessage());
		}
	}

	
	

}
