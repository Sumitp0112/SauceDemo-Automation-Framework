package com.sauce.tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.BaseReport;
import com.sauce.base.BaseTest;
import com.sauce.pages.CartPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ScreenshotUtil;

public class CartTest extends BaseReport {

	LoginPage lp;
	ProductPage pp;
	CartPage cp;

	@BeforeMethod(alwaysRun = true)

	public void setup() {

		launchBrowser();

		lp = new LoginPage(driver);

		pp = new ProductPage(driver);

		cp = new CartPage(driver);

		lp.loginToApplication("standard_user", "secret_sauce");
	}

	// TC035 - Verify Cart Page Opens

	@Test(priority = 1)

	public void verifyCartPage() {

		cp.openCart();

		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

		//ScreenshotUtil.captureScreenshot(driver, "CartPage");

		System.out.println("Cart Page Opened Successfully");
	}

	// TC036 - Verify Product Displayed In Cart

	@Test(priority = 2)

	public void verifyProductDisplayedInCart() {
		
		
		pp.addProductToCart();
		
		
		cp.openCart();

		Assert.assertTrue(cp.isCartItemDisplayed());
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//ScreenshotUtil.captureScreenshot(driver, "ProductInCart");

		System.out.println("Product Displayed In Cart Successfully");
	}

	// TC037 - Verify Multiple Products Displayed In Cart

	@Test(priority = 3)

	public void verifyMultipleProductsDisplayedInCart() {
		
		
		pp.addProductToCart();
		
		
		pp.addBikeLightProduct();
		
		
		cp.openCart();
		
		
		Assert.assertEquals(cp.getCartItemsCount(), 2);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//ScreenshotUtil.captureScreenshot(driver, "MultipleProducts");

		System.out.println("Multiple Products Displayed In Cart Successfully");
	}

	// TC038 - Verify Remove Product From Cart

	@Test(priority = 4)

	public void verifyRemoveProductFromCart() {
		
		
		pp.addProductToCart();
		
		
		cp.openCart();
		
		
		cp.removeProduct();
		
		
		Assert.assertEquals(cp.getCartItemsCount(), 0);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//ScreenshotUtil.captureScreenshot(driver, "RemoveProduct");

		System.out.println("Product Removed Successfully From Cart");
	}

	// TC039 - Verify Continue Shopping Button

	@Test(priority = 5)

	public void verifyContinueShoppingButton() {

		
		cp.openCart();
		
		cp.clickContinueShopping();

		
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//ScreenshotUtil.captureScreenshot(driver, "ContinueShopping");

		System.out.println("Continue Shopping Button Verified");
	}

	// TC040 - Verify Product Remains After Refresh

	@Test(priority = 6)

	public void verifyProductRemainsAfterRefresh() {
		
		pp.addProductToCart();
		
		driver.navigate().refresh();
		
		cp.openCart();

		Assert.assertEquals(cp.getCartItemsCount(), 1);
		
		//ScreenshotUtil.captureScreenshot(driver, "RefreshCart");

		System.out.println("Product Remained In Cart After Refresh");
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		closeBrowser();
	}
}