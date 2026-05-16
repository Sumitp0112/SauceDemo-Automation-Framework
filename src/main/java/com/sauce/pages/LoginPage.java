package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Constructor

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators

	private By username = By.id("user-name");

	private By password = By.id("password");

	private By loginButton = By.id("login-button");

	private By errorMessage = By.xpath("//h3[@data-test='error']");

	// Enter Username

	public void enterUsername(String uname) {

		driver.findElement(username).clear();

		driver.findElement(username).sendKeys(uname);
	}

	// Enter Password

	public void enterPassword(String pass) {

		driver.findElement(password).clear();

		driver.findElement(password).sendKeys(pass);
	}

	// Click Login Button

	public void clickLoginButton() {

		driver.findElement(loginButton).click();
	}

	// Complete Login

	public void loginToApplication(String uname, String pass) {

		enterUsername(uname);

		enterPassword(pass);

		clickLoginButton();
	}

	// Login Using Enter Key

	public void loginUsingEnterKey(String uname, String pass) {

		enterUsername(uname);

		driver.findElement(password).sendKeys(pass + Keys.ENTER);
	}

	// Get Error Message

	public String getErrorMessage() {

		return driver.findElement(errorMessage).getText();
	}

	// Verify Password Masked

	public String getPasswordFieldType() {

		return driver.findElement(password).getAttribute("type");
	}

	// Verify Username Field

	public boolean isUsernameFieldDisplayed() {

		return driver.findElement(username).isDisplayed();
	}

	// Verify Password Field

	public boolean isPasswordFieldDisplayed() {

		return driver.findElement(password).isDisplayed();
	}

	// Verify Login Button

	public boolean isLoginButtonDisplayed() {

		return driver.findElement(loginButton).isDisplayed();
	}
	
	public String getEnteredUsername() {

		return driver.findElement(username).getAttribute("value");
	}

	public String getEnteredPassword() {

		return driver.findElement(password).getAttribute("value");
	}
}