package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (id="Email")
	WebElement emailTextBox;
	
	@FindBy (id="Password")
	WebElement passwordTextBox;
	
	@FindBy (css="input[value='Log in']")
	WebElement loginBtn;
	
	public void UserLogin(String email, String password)
	{
		setTextElementText(emailTextBox, email);
		setTextElementText(passwordTextBox, password);
		clickButton(loginBtn);
	}
	
	
}
