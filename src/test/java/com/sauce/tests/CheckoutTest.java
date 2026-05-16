package com.sauce.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.BaseReport;
import com.sauce.base.BaseTest;
import com.sauce.pages.CartPage;
import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ScreenshotUtil;

public class CheckoutTest extends BaseReport {

	LoginPage lp;
	ProductPage pp;
	CartPage cp;
	CheckoutPage ch;

	@BeforeMethod(alwaysRun = true)

	public void setup() {

		launchBrowser();

		lp = new LoginPage(driver);

		pp = new ProductPage(driver);

		cp = new CartPage(driver);

		ch = new CheckoutPage(driver);

		lp.loginToApplication("standard_user", "secret_sauce");
	}

	// TC041 - Verify Checkout Button

	@Test(priority = 1)

	public void verifyCheckoutButton() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));

		//ScreenshotUtil.captureScreenshot(driver, "CheckoutButton");

		System.out.println("Checkout Button Verified");
	}

	// TC042 - Verify Checkout With Empty Cart

	@Test(priority = 2)

	public void verifyCheckoutWithEmptyCart() {

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertEquals(ch.getCartItemCount(), 0);

		//ScreenshotUtil.captureScreenshot(driver, "EmptyCartCheckout");

		System.out.println("Checkout With Empty Cart Verified");
	}

	// TC043 - Verify Checkout With Valid Details

	@Test(priority = 3)

	public void verifyCheckoutWithValidDetails() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertTrue(ch.isCheckoutOverviewDisplayed());

		//ScreenshotUtil.captureScreenshot(driver, "ValidCheckout");

		System.out.println("Checkout With Valid Details Verified");
	}

	// TC044 - Empty First Name

	@Test(priority = 4)

	public void verifyEmptyFirstName() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterLastName("Patil");

		ch.enterPostalCode("411001");

		ch.clickContinue();

		Assert.assertTrue(ch.getErrorMessage().contains("First Name"));

		//ScreenshotUtil.captureScreenshot(driver, "EmptyFirstName");

		System.out.println("First Name Validation Verified");
	}

	// TC045 - Empty Last Name

	@Test(priority = 5)

	public void verifyEmptyLastName() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterFirstName("Sumit");

		ch.enterPostalCode("411001");

		ch.clickContinue();

		Assert.assertTrue(ch.getErrorMessage().contains("Last Name"));

		//ScreenshotUtil.captureScreenshot(driver, "EmptyLastName");

		System.out.println("Last Name Validation Verified");
	}

	// TC046 - Empty Zip Code

	@Test(priority = 6)

	public void verifyEmptyZipCode() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterFirstName("Sumit");

		ch.enterLastName("Patil");

		ch.clickContinue();

		Assert.assertTrue(ch.getErrorMessage().contains("Postal Code"));

		//ScreenshotUtil.captureScreenshot(driver, "EmptyZipCode");

		System.out.println("Zip Code Validation Verified");
	}

	// TC047 - Verify Checkout Overview Product

	@Test(priority = 7)

	public void verifyCheckoutOverviewProduct() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"));

		//ScreenshotUtil.captureScreenshot(driver, "CheckoutOverviewProduct");

		System.out.println("Checkout Overview Product Verified");
	}

	// TC048 - Verify Payment Information

	@Test(priority = 8)

	public void verifyPaymentInformation() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertTrue(driver.getPageSource().contains("SauceCard"));

		//ScreenshotUtil.captureScreenshot(driver, "PaymentInformation");

		System.out.println("Payment Information Verified");
	}

	// TC049 - Verify Shipping Information

	@Test(priority = 9)

	public void verifyShippingInformation() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertTrue(driver.getPageSource().contains("Free Pony Express"));

		//ScreenshotUtil.captureScreenshot(driver, "ShippingInformation");

		System.out.println("Shipping Information Verified");
	}

	// TC050 - Verify Total Calculation

	@Test(priority = 10)

	public void verifyTotalCalculation() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		Assert.assertTrue(ch.getItemTotal().contains("Item total"));

		Assert.assertTrue(ch.getTax().contains("Tax"));

		Assert.assertTrue(ch.getFinalTotal().contains("Total"));

		//ScreenshotUtil.captureScreenshot(driver, "TotalCalculation");

		System.out.println("Total Calculation Verified");
	}

	// TC051 - Verify Finish Button

	@Test(priority = 11)

	public void verifyFinishButton() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		ch.clickFinish();

		Assert.assertTrue(ch.isCheckoutCompleteDisplayed());

		//ScreenshotUtil.captureScreenshot(driver, "FinishButton");

		System.out.println("Finish Button Verified");
	}

	// TC052 - Verify Order Confirmation Message

	@Test(priority = 12)

	public void verifyOrderConfirmationMessage() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		ch.clickFinish();

		Assert.assertEquals(ch.getCompleteMessage(), "Thank you for your order!");

		//ScreenshotUtil.captureScreenshot(driver, "OrderConfirmation");

		System.out.println("Order Confirmation Verified");
	}

	// TC053 - Verify Back Home Button

	@Test(priority = 13)

	public void verifyBackHomeButton() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		ch.clickFinish();

		ch.clickBackHome();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//ScreenshotUtil.captureScreenshot(driver, "BackHome");

		System.out.println("Back Home Button Verified");
	}

	// TC054 - Verify Cancel Button From Checkout Information

	@Test(priority = 14)

	public void verifyCancelButtonFromCheckoutInformation() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.clickCancel();

		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

		//creenshotUtil.captureScreenshot(driver, "CancelCheckoutInfo");

		System.out.println("Cancel Button From Checkout Information Verified");
	}

	// TC055 - Verify Cancel Button From Checkout Overview

	@Test(priority = 15)

	public void verifyCancelButtonFromCheckoutOverview() {

		pp.addProductToCart();

		cp.openCart();

		ch.clickCheckout();

		ch.enterCheckoutInformation("Sumit", "Patil", "411001");

		ch.clickContinue();

		ch.clickCancel();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//ScreenshotUtil.captureScreenshot(driver, "CancelCheckoutOverview");

		System.out.println("Cancel Button From Checkout Overview Verified");
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		closeBrowser();
	}
}