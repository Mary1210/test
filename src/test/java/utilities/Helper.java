package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Helper {

	//Method to take screenshot when the test cases fail

	public static void captureScreenShot (WebDriver webDriver, String screenshotname)
	{
		Path dest =Paths.get("./Screenshots", screenshotname + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());

			out.write(((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} 
		catch (IOException e) 
		{

			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}

	}

}
