package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy (id="FullName")
	WebElement FullnameTxt;
	
	@FindBy (id="Email")
	WebElement EmailTxt;
	
	@FindBy (id="Enquiry")
	WebElement enquiryTxt;
	
	@FindBy (css= "input[value='Submit']")
	WebElement submitBtn;
	
	@FindBy (css="div[class='result']")
	public WebElement successMessage;
	
	public void ContactUs (String Fullname, String Email, String message)
	{
		setTextElementText(FullnameTxt, Fullname);
		setTextElementText(EmailTxt, Email);
		setTextElementText(enquiryTxt, message);
		clickButton(submitBtn);
	}
	
	
	


}