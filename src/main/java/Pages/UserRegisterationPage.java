package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;
	
	@FindBy (id="FirstName")
	WebElement fnTxtBox;
	
	@FindBy (id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy (className="result")
	public WebElement successMessage;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	
	@FindBy (linkText="My account")
	WebElement myAccountLink;
	
	public void userRegisteration(String firstName, String lastName, String email, String password)
	{
		
		clickButton(genderRadioBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmpasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userlogout()
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
	

}
