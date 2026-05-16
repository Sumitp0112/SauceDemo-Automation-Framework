package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private WebDriver driver;

	// Constructor

	public CartPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators

	private By cartIcon = By.className("shopping_cart_link");

	private By cartItem = By.className("cart_item");

	private By removeButton = By.id("remove-sauce-labs-backpack");

	private By continueShoppingButton = By.id("continue-shopping");

	private By checkoutButton = By.id("checkout");

	private By cartBadge = By.className("shopping_cart_badge");

	// Open Cart

	public void openCart() {

		driver.findElement(cartIcon).click();
	}

	// Remove Product

	public void removeProduct() {

		driver.findElement(removeButton).click();
	}

	// Continue Shopping

	public void clickContinueShopping() {

		driver.findElement(continueShoppingButton).click();
	}

	// Click Checkout

	public void clickCheckout() {

		driver.findElement(checkoutButton).click();
	}

	// Get Cart Item Count

	public int getCartItemsCount() {

		return driver.findElements(cartItem).size();
	}

	// Verify Cart Item Displayed

	public boolean isCartItemDisplayed() {

		return driver.findElements(cartItem).size() > 0;
	}

	// Verify Continue Shopping Button

	public boolean isContinueShoppingButtonDisplayed() {

		return driver.findElement(continueShoppingButton).isDisplayed();
	}

	// Verify Checkout Button

	public boolean isCheckoutButtonDisplayed() {

		return driver.findElement(checkoutButton).isDisplayed();
	}

	// Get Cart Badge Count

	public String getCartBadgeCount() {

		return driver.findElement(cartBadge).getText();
	}

	// Verify Cart Badge Displayed

	public boolean isCartBadgeDisplayed() {

		return driver.findElements(cartBadge).size() > 0;
	}
}