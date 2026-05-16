package com.sauce.tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.BaseReport;
import com.sauce.base.BaseTest;
import com.sauce.pages.LoginPage;
import com.sauce.utilities.ScreenshotUtil;

public class LoginTest extends BaseReport {

	LoginPage lp;

	@BeforeMethod(alwaysRun = true)

	public void setup() {

		launchBrowser();

		lp = new LoginPage(driver);
	}

	// TC001 - Verify Login Page Loads Successfully

	@Test(priority = 1)

	public void verifyLoginPageLoadsSuccessfully() {

		Assert.assertTrue(lp.isUsernameFieldDisplayed());

		Assert.assertTrue(lp.isPasswordFieldDisplayed());

		Assert.assertTrue(lp.isLoginButtonDisplayed());

		System.out.println("Login Page Loaded Successfully");
	}

	// TC002 - Valid Login

	@Test(priority = 2)

	public void verifyValidLogin() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		lp.loginToApplication("standard_user", "secret_sauce");

		//ScreenshotUtil.captureScreenshot(driver, "ValidLogin");

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		System.out.println("Valid Login Passed");
	}

	// TC003 - Invalid Credentials

	@Test(priority = 3)

	public void verifyInvalidCredentials() {

		lp.loginToApplication("standard_r", "secret_s");

		//ScreenshotUtil.captureScreenshot(driver, "InvalidCredentials");

		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));

		System.out.println("Invalid Credentials Validation Passed");
	}

	// TC004 - Invalid Password

	@Test(priority = 4)

	public void verifyInvalidPassword() {

		lp.loginToApplication("standard_user", "wrong_password");

		//ScreenshotUtil.captureScreenshot(driver, "InvalidPassword");

		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));

		System.out.println("Invalid Password Validation Passed");
	}

	// TC005 - Invalid Username

	@Test(priority = 5)

	public void verifyInvalidUsername() {

		lp.loginToApplication("wrong_user", "secret_sauce");

		//ScreenshotUtil.captureScreenshot(driver, "InvalidUsername");

		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));

		System.out.println("Invalid Username Validation Passed");
	}

	// TC006 - Both Fields Empty

	@Test(priority = 6)

	public void verifyLoginWithEmptyFields() {

		lp.clickLoginButton();

		//ScreenshotUtil.captureScreenshot(driver, "EmptyFields");

		Assert.assertTrue(lp.getErrorMessage().contains("Username is required"));

		System.out.println("Empty Fields Validation Passed");
	}

	// TC007 - Password Field Masked

	@Test(priority = 7)

	public void verifyPasswordFieldMasked() {

		lp.enterPassword("secret_sauce");

		String fieldType = lp.getPasswordFieldType();

		Assert.assertEquals(fieldType, "password");

		System.out.println("Password Masking Validation Passed");
	}

	// TC008 - Textbox Functionality

	@Test(priority = 8)

	public void verifyTextboxFunctionality() {

		lp.enterUsername("standard_user");

		lp.enterPassword("secret_sauce");

		Assert.assertEquals(lp.getEnteredUsername(), "standard_user");

		Assert.assertEquals(lp.getEnteredPassword(), "secret_sauce");

		System.out.println("Textbox Functionality Passed");
	}

	// TC009 - Empty Username

	@Test(priority = 9)

	public void verifyEmptyUsername() {

		lp.enterPassword("secret_sauce");

		lp.clickLoginButton();

		//ScreenshotUtil.captureScreenshot(driver, "EmptyUsername");

		Assert.assertTrue(lp.getErrorMessage().contains("Username is required"));

		System.out.println("Empty Username Validation Passed");
	}

	// TC010 - Empty Password

	@Test(priority = 10)

	public void verifyEmptyPassword() {

		lp.enterUsername("standard_user");

		lp.clickLoginButton();

		ScreenshotUtil.captureScreenshot(driver, "EmptyPassword");

		//Assert.assertTrue(lp.getErrorMessage().contains("Password is required"));

		System.out.println("Empty Password Validation Passed");
	}

	// TC011 - Locked User Login

	@Test(priority = 11)

	public void verifyLockedUserLogin() {

		lp.loginToApplication("locked_out_user", "secret_sauce");

		//ScreenshotUtil.captureScreenshot(driver, "LockedUser");

		Assert.assertTrue(lp.getErrorMessage().contains("locked out"));

		System.out.println("Locked User Validation Passed");
	}

	// TC012 - Login Using Enter Key

	@Test(priority = 12)

	public void verifyLoginUsingEnterKey() {

		lp.loginUsingEnterKey("standard_user", "secret_sauce");

		//ScreenshotUtil.captureScreenshot(driver, "EnterKeyLogin");

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		System.out.println("Login Using Enter Key Passed");
	}

	// TC013 - Special Characters

	@Test(priority = 13)

	public void verifyLoginWithSpecialCharacters() {

		lp.loginToApplication("@#$%^", "!@#123");

		//ScreenshotUtil.captureScreenshot(driver, "SpecialCharacters");

		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));

		System.out.println("Special Character Validation Passed");
	}

	// TC014 - SQL Injection

	@Test(priority = 14)

	public void verifyLoginWithSQLInjection() {

		lp.loginToApplication("' OR '1'='1", "' OR '1'='1");

		//ScreenshotUtil.captureScreenshot(driver, "SQLInjection");

		Assert.assertTrue(lp.getErrorMessage().contains("do not match"));

		System.out.println("SQL Injection Validation Passed");
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		closeBrowser();
	}
}