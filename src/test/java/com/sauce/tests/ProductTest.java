package com.sauce.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.BaseReport;
import com.sauce.base.BaseTest;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductPage;
import com.sauce.utilities.ScreenshotUtil;

public class ProductTest extends BaseReport {

	LoginPage lp;
	ProductPage pp;

	@BeforeMethod(alwaysRun = true)

	public void setup() {

		launchBrowser();

		lp = new LoginPage(driver);

		pp = new ProductPage(driver);

		lp.loginToApplication("standard_user", "secret_sauce");
	}

	// TC015 - Verify Product Listing Page

	@Test(priority = 1)

	public void verifyProductListingPage() {

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//ScreenshotUtil.captureScreenshot(driver, "ProductListingPage");

		System.out.println("Product Listing Page Verified");
	}

	// TC016 - Verify Product Name Displayed

	@Test(priority = 2)

	public void verifyProductNameDisplayed() {

		Assert.assertTrue(pp.isProductDisplayed());

		//ScreenshotUtil.captureScreenshot(driver, "ProductName");

		System.out.println("Product Names Displayed Successfully");
	}

	// TC017 - Verify Product Description Displayed

	@Test(priority = 3)

	public void verifyProductDescriptionDisplayed() {

		List<WebElement> descriptions = driver.findElements(By.className("inventory_item_desc"));

		Assert.assertTrue(descriptions.size() > 0);

		//ScreenshotUtil.captureScreenshot(driver, "ProductDescription");

		System.out.println("Product Descriptions Displayed Successfully");
	}

	// TC018 - Verify Product Price Displayed

	@Test(priority = 4)

	public void verifyProductPriceDisplayed() {

		List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

		Assert.assertTrue(prices.size() > 0);

		//ScreenshotUtil.captureScreenshot(driver, "ProductPrice");

		System.out.println("Product Prices Displayed Successfully");
	}

	// TC019 - Verify Product Image Displayed

	@Test(priority = 5)

	public void verifyProductImageDisplayed() {

		List<WebElement> images = driver.findElements(By.className("inventory_item_img"));

		Assert.assertTrue(images.size() > 0);

		//ScreenshotUtil.captureScreenshot(driver, "ProductImage");

		System.out.println("Product Images Displayed Successfully");
	}

	// TC020 - Verify Hamburger Menu

	@Test(priority = 6)

	public void verifyHamburgerMenu() {

		pp.openHamburgerMenu();

		Assert.assertTrue(pp.isHamburgerMenuDisplayed());

		//ScreenshotUtil.captureScreenshot(driver, "HamburgerMenu");

		System.out.println("Hamburger Menu Verified");
	}

	// TC021 - Verify All Items

	@Test(priority = 7)

	public void verifyAllItemsOption() {

		pp.openHamburgerMenu();

		pp.clickAllItems();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//ScreenshotUtil.captureScreenshot(driver, "AllItems");

		System.out.println("All Items Option Verified");
	}

	// TC022 - Verify About Link

	@Test(priority = 8)

	public void verifyAboutLink() {

		pp.openHamburgerMenu();

		pp.clickAbout();

		Assert.assertTrue(driver.getCurrentUrl().contains("saucelabs"));

		//ScreenshotUtil.captureScreenshot(driver, "AboutLink");

		System.out.println("About Link Verified");
	}

	// TC023 - Verify Logout

	@Test(priority = 9)

	public void verifyLogoutFunctionality() {

		pp.openHamburgerMenu();

		pp.clickLogout();

		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));

		//ScreenshotUtil.captureScreenshot(driver, "Logout");

		System.out.println("Logout Verified");
	}

	// TC024 - Verify Reset App State

	@Test(priority = 10)

	public void verifyResetAppState() {

		pp.addProductToCart();

		pp.openHamburgerMenu();

		pp.clickResetAppState();

		pp.openCart();

		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

		Assert.assertEquals(cartItems.size(), 0);

		//ScreenshotUtil.captureScreenshot(driver, "ResetAppState");

		System.out.println("Reset App State Verified");
	}

	// TC025 - Verify Cart Icon

	@Test(priority = 11)

	public void verifyCartIcon() {

		pp.openCart();

		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

		//ScreenshotUtil.captureScreenshot(driver, "CartIcon");

		System.out.println("Cart Page Verified");
	}

	// TC026 - Verify Product Details Page

	@Test(priority = 12)

	public void verifyProductDetailsPage() {

		pp.openProduct();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"));

		//ScreenshotUtil.captureScreenshot(driver, "ProductDetails");

		System.out.println("Product Details Page Verified");
	}

	// TC027 - Verify Add To Cart

	@Test(priority = 13)

	public void verifyAddToCart() {

		pp.addProductToCart();

		String actualCount = pp.getCartBadgeCount();

		Assert.assertEquals(actualCount, "1");

		//ScreenshotUtil.captureScreenshot(driver, "AddToCart");

		System.out.println("Add To Cart Verified");
	}

	// TC028 - Verify Remove Product

	@Test(priority = 14)

	public void verifyRemoveProduct() {

		pp.addProductToCart();

		pp.removeProductFromCart();

		Assert.assertFalse(pp.isCartBadgeDisplayed());

		//ScreenshotUtil.captureScreenshot(driver, "RemoveProduct");

		System.out.println("Remove Product Verified");
	}

	// TC029 - Verify Sort A to Z

	@Test(priority = 15)

	public void verifySortAToZ() {

		pp.sortProductAToZ();

		List<WebElement> products = driver.findElements(By.className("inventory_item_name"));

		List<String> actualList = new ArrayList<String>();

		for (WebElement product : products) {

			actualList.add(product.getText());
		}

		List<String> expectedList = new ArrayList<String>(actualList);

		Collections.sort(expectedList);

		Assert.assertEquals(actualList, expectedList);

		//ScreenshotUtil.captureScreenshot(driver, "SortAToZ");

		System.out.println("Sort A to Z Verified");
	}

	// TC030 - Verify Sort Z to A

	@Test(priority = 16)

	public void verifySortZToA() {

		pp.sortProductZToA();

		List<WebElement> products = driver.findElements(By.className("inventory_item_name"));

		List<String> actualList = new ArrayList<String>();

		for (WebElement product : products) {

			actualList.add(product.getText());
		}

		List<String> expectedList = new ArrayList<String>(actualList);

		Collections.sort(expectedList, Collections.reverseOrder());

		Assert.assertEquals(actualList, expectedList);

		//ScreenshotUtil.captureScreenshot(driver, "SortZToA");

		System.out.println("Sort Z to A Verified");
	}

	// TC031 - Verify Price Low to High

	@Test(priority = 17)

	public void verifyPriceLowToHigh() {

		pp.sortPriceLowToHigh();

		List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

		List<Double> actualPrices = new ArrayList<Double>();

		for (WebElement price : priceElements) {

			actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
		}

		List<Double> expectedPrices = new ArrayList<Double>(actualPrices);

		Collections.sort(expectedPrices);

		Assert.assertEquals(actualPrices, expectedPrices);

		//ScreenshotUtil.captureScreenshot(driver, "PriceLowToHigh");

		System.out.println("Price Low To High Verified");
	}

	// TC032 - Verify Price High to Low

	@Test(priority = 18)

	public void verifyPriceHighToLow() {

		pp.sortPriceHighToLow();

		List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

		List<Double> actualPrices = new ArrayList<Double>();

		for (WebElement price : priceElements) {

			actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
		}

		List<Double> expectedPrices = new ArrayList<Double>(actualPrices);

		Collections.sort(expectedPrices, Collections.reverseOrder());

		Assert.assertEquals(actualPrices, expectedPrices);

		//ScreenshotUtil.captureScreenshot(driver, "PriceHighToLow");

		System.out.println("Price High To Low Verified");
	}

	// TC033 - Verify Session Activity

	@Test(priority = 19)

	public void verifySessionActivity() {

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

		//ScreenshotUtil.captureScreenshot(driver, "SessionActivity");

		System.out.println("Session Activity Verified");
	}

	// TC034 - Verify Quantity Functionality

	@Test(priority = 20)

	public void verifyQuantityFunctionality() {

		List<WebElement> quantityButtons = driver.findElements(By.className("quantity_button"));

		Assert.assertEquals(quantityButtons.size(), 0);

		//ScreenshotUtil.captureScreenshot(driver, "QuantityFunctionality");

		System.out.println("Quantity Functionality Validation Completed");
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		closeBrowser();
	}
}