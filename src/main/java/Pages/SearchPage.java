package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTextBox;
	
	@FindBy (css="input[value='Search']")
	WebElement SearchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList;
	
	@FindBy (linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextElementText(searchTextBox, productName);
		clickButton(SearchBtn);
	}
	
	public void OpenProductDetailsPage()
	{
		clickButton(productTitle);
	}
	public void ProductSearchUsingAutoSuggest(String Searchtxt)
	{
		setTextElementText(searchTextBox, Searchtxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductList.get(0).click();
	}
	
	public void ProductSearchUsingAutoSuggest_1(String Searchtxt)
	{
		setTextElementText(searchTextBox, Searchtxt);
		ProductList.get(0).click();
	}
}
