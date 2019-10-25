package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase3 {
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	public static String BaseURL = "http://demo.nopcommerce.com" ; 

	@BeforeTest
	//Parameter will get browser from testng.xml on which browser test to run
	/*   @Parameters("myBrowser")
    public void beforeClass(@Optional("chrome")String myBrowser) throws MalformedURLException{

        RemoteWebDriver driver = null;

        if(myBrowser.equals("chrome")){
            DesiredCapabilities capability = new DesiredCapabilities().chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }
        else if(myBrowser.equals("firefox")){
            DesiredCapabilities capability = new DesiredCapabilities().firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }

        //setting webdriver
        setWebDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        getDriver().navigate().to(BaseURL);

    }*/

	@Parameters("myBrowser")
	public void beforeClass(@Optional("chrome")String myBrowser) throws MalformedURLException{

		RemoteWebDriver driver = null;
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", myBrowser);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getDriver().navigate().to(BaseURL);

	}

	public WebDriver getDriver() {
		return dr.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	@AfterClass
	public void afterClass(){
		getDriver().quit();
		dr.set(null);

	}
}
