package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class ProductHoverMenuTest extends TestBase{
	
	HomePage homeObject;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.SelectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	

}
