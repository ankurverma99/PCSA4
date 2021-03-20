package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrak {

	public void verifyHPisDisplyed(WebDriver driver, long eto) {
		WebDriverWait ww = new WebDriverWait(driver, eto);
		try {
			ww.until(ExpectedConditions.titleContains("Enter"));
			Reporter.log("Home page is Displyed", true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//div[@id='addTaskButtonId']")
	private WebElement New;

	@FindBy(xpath = "//div[text()='- Select Customer -']")
	private WebElement selectCustomer;

	@FindBy(xpath = "//div[text()='- New Customer -']")
	private WebElement newCustomer;

	public EnterTimeTrak(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void newClick() {
		New.click();
	}

}
