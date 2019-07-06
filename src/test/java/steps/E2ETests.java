package steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Pages.CheckoutPage;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import tests.TestBase;

public class E2ETests extends TestBase{

	SearchPage searchpage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName= "Asus N551JK-XO076H Laptop";
	@Given("^user is on home page$")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));

	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String aproductName) {
		searchpage = new SearchPage(driver);
		searchpage.ProductSearchUsingAutoSuggest(productName);
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));

	}

	@When("^choose two buy new items$")
	public void choose_two_buy_new_items()  {
		cartPage = new ShoppingCartPage(driver);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		productDetails.AddProductToCart();
		driver.navigate().to("http://demo.nopcommerce.com/" + "cart");

	}

	@When("^move to checkout and enter personal details on checkout page and place the order$")
	public void move_to_checkout_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException  {
		checkoutObject = new CheckoutPage(driver);
		cartPage.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct("test","user","Egypt", "testuser@test.com","test address", "123456", 
				"32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());

	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException  {
		orderObject = new OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		//driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		orderObject.PrintOrderDetails();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		
	}

}
