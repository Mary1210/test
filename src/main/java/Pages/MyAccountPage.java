package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	
	@FindBy (id="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy (id="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy (id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy (css="input[value='Change password']")
	WebElement changePasswordBtn;
	
	@FindBy (css= "div.result")
	public WebElement resultLbl;
	
	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}
	
	public void Changepassword (String oldpassword, String newpassword)
	{
		setTextElementText(oldPasswordTxt, oldpassword);
		setTextElementText(newPasswordTxt, newpassword);
		setTextElementText(confirmPasswordTxt, newpassword);
		//public JavascriptExecutor jse;
		//jse.
		
		clickButton(changePasswordBtn);
		
	}

}
