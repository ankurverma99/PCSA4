package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeHome {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(id = "loginButton")
	private WebElement login;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotePassword;

	@FindBy(linkText = "actiTIME Inc.")
	private WebElement actitimeInc;

	public ActiTimeHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendUsername(String user) {
		username.sendKeys(user);
	}

	public void sendpassWord(String pass) {
		password.sendKeys(pass);
	}

	public void logInClick() {
		login.click();
	}

	public void forgotPassClick() {
		forgotePassword.click();
	}

	public void IncClick() {
		actitimeInc.click();
	}

}
