package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (name="removefromcart")
	WebElement removecheck;

	@FindBy(name="updatecart")
	WebElement updateCartBtn;

	@FindBy (id="itemquantity28260")
	WebElement quantityTxt;

	@FindBy (css="span[class='product-subtotal']")
	public WebElement totalLbl;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckBox;
	

	@FindBy(id="termsofservice")
	WebElement agreeCheckbox; 
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestCheckoutBtn ; 

	
	public void RemoveProductFromCart()
	{
		clickButton(removecheck);
		clickButton(updateCartBtn);
	}
	
	public void UpdateProductQuantityInCart(String quantity)
	{
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void OpenCheckoutPage()
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
	
	public void openCheckoutPageAsGuest() 
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
		clickButton(guestCheckoutBtn);
	}
}
