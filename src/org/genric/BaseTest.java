package org.genric;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst {
	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws Exception {
		String bname = ReadData.readValue("Browser");
		if (bname.equalsIgnoreCase("chrome")) {
			System.setProperty(Chrome_Key, Chrome_value);
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty(Firefox_Key, Firefox_value);
			driver = new FirefoxDriver();
		} else {
			driver = null;
		}
		driver.manage().window().maximize();
		String url = ReadData.readValue("URL");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult testResult) throws IOException {
		int status = testResult.getStatus();
		String name = testResult.getName();
		if (status == 1) {
			Reporter.log("Test Case " + name + " is pass", true);
		} else {
			Reporter.log("Test Case " + name + " is fail", true);
			ScreenShot.takePic(driver, screenShot_path + name + ".png");
		}
		driver.close();

	}

}
