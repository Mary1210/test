package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="div[class='add-to-wishlist']")
	WebElement addToWishListBtn;
	
	@FindBy (css="strong[class='current-item']")
	public WebElement productNamebreadCrumb;
	
	@FindBy (css="input[value='Email a friend']")
	WebElement emailFriendBtn;
	
	@FindBy (css= "span[class='price-value-4']" )
	public WebElement ProductPriceLbl;
	
	@FindBy(linkText= "Add your review")
	public WebElement addReviewLink;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ;
	
	@FindBy (css="input[value='Add to cart']")
	WebElement addToCartBtn;
	
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(addReviewLink);
	}
	public void AddProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void AddProductToCompare() 
	{
		clickButton(addToCompareBtn);
	}
	
	public void AddProductToCart()
	{
		clickButton(addToCartBtn);
	}

}
