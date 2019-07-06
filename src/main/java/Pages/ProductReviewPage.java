package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (name="AddProductReview.Title")
	WebElement ReviewTitleTxt;
	
	@FindBy (id="AddProductReview_ReviewText")
	WebElement ReviewTxt;
	
	@FindBy (id="addproductrating_3")
	WebElement RatingRadioBtn;
	
	@FindBy (name="add-review")
	WebElement addReviewBtn;
	
	@FindBy(css="div[class='result']")
	WebElement SubmitReviewBtn;
	
	@FindBy (css= "div[class='result']")
	public WebElement reviewNotification;
	
	public void AddProductReview (String reviewTitle, String reviewMessage)
	{
		setTextElementText(ReviewTitleTxt, reviewTitle);
		setTextElementText(ReviewTxt, reviewMessage);
		clickButton(addReviewBtn);
		clickButton(SubmitReviewBtn);
	}
	
	

}
