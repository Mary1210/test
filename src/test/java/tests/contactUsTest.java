package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class contactUsTest extends TestBase{
	HomePage home;
	ContactUsPage contactPage;

	
	String email ="test@mail.com";
	String fullname= "test user";
	String enquiry="Hello Admin, this is for test";
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Contact Us testcase")
	@Link(name="jira",url="http://google.com")
	public void UserCanContactUs()
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullname, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
	

}
