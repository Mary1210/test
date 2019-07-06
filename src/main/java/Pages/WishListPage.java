package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (css="td.product")
	public WebElement ProductCell;
	
	@FindBy(css="h1")
	public WebElement WishlistHeader;
	
	@FindBy (name="updatecart")
	WebElement updateWishlistBtn;
	
	 @FindBy (name="removefromcart")
	 WebElement removefromCartCheck;
	
	 @FindBy (css= "div[class='no-data']")
	 public WebElement EmptyCartbl;
	 
	 public void removeProductFromCart()
	 {
		 clickButton(removefromCartCheck);
		 clickButton(updateWishlistBtn);
		 //Assert.assertTrue(EmptyCartbl.getText().contains("empty!"));
	 }
	 

}
