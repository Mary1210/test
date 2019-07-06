package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (id="FriendEmail")
	WebElement emailFriendTxt;
	
	@FindBy (id="PersonalMessage")
	WebElement presonalMessageTxt;
	
	@FindBy (name="send-email")
	WebElement sendEmailBtn;
	
	@FindBy (css= "div[class='result']")
	public WebElement messagenotification;
	
	public void sendEmailFriend(String friendemail, String personalMessage)
	{
		setTextElementText(emailFriendTxt, friendemail);
		setTextElementText(presonalMessageTxt, personalMessage);
		clickButton(sendEmailBtn);
	}

}
