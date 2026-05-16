package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	WebDriver driver;

	// Constructor

	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators

	private By hamburgerMenu = By.id("react-burger-menu-btn");

	private By allItems = By.id("inventory_sidebar_link");

	private By aboutLink = By.id("about_sidebar_link");

	private By logoutLink = By.id("logout_sidebar_link");

	private By resetAppState = By.id("reset_sidebar_link");

	private By cartIcon = By.className("shopping_cart_link");

	private By productTitle = By.className("inventory_item_name");

	private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");

	private By removeButton = By.id("remove-sauce-labs-backpack");

	private By filterDropdown = By.className("product_sort_container");

	private By cartBadge = By.className("shopping_cart_badge");

	// Open Hamburger Menu

	public void openHamburgerMenu() {

		driver.findElement(hamburgerMenu).click();
	}
	
	// Verify Hamburger Menu Displayed

	public boolean isHamburgerMenuDisplayed() {

		return driver.findElement(By.className("bm-menu-wrap")).isDisplayed();
	}

	// Click All Items

	public void clickAllItems() {

		driver.findElement(allItems).click();
	}

	// Click About

	public void clickAbout() {

		driver.findElement(aboutLink).click();
	}

	// Click Logout

	public void clickLogout() {

		driver.findElement(logoutLink).click();
	}

	// Click Reset App State

	public void clickResetAppState() {

		driver.findElement(resetAppState).click();
	}

	// Open Cart

	public void openCart() {

		driver.findElement(cartIcon).click();
	}

	// Open Product

	public void openProduct() {

		driver.findElement(productTitle).click();
	}

	// Add Product

	public void addProductToCart() {

		driver.findElement(addToCartButton).click();
	}
	
	// Add Bike Light Product

	public void addBikeLightProduct() {

		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	}

	// Remove Product

	public void removeProductFromCart() {

		driver.findElement(removeButton).click();
	}

	// Get Cart Badge Count

	public String getCartBadgeCount() {

		return driver.findElement(cartBadge).getText();
	}

	// Verify Cart Badge Displayed

	public boolean isCartBadgeDisplayed() {

		return driver.findElements(cartBadge).size() > 0;
	}

	// Verify Product Displayed

	public boolean isProductDisplayed() {

		return driver.findElement(productTitle).isDisplayed();
	}

	// Get Product Count

	public int getProductCount() {

		return driver.findElements(productTitle).size();
	}

	// Sort A to Z

	public void sortProductAToZ() {

		Select sc = new Select(driver.findElement(filterDropdown));

		sc.selectByVisibleText("Name (A to Z)");
	}

	// Sort Z to A

	public void sortProductZToA() {

		Select sc = new Select(driver.findElement(filterDropdown));

		sc.selectByVisibleText("Name (Z to A)");
	}

	// Sort Price Low to High

	public void sortPriceLowToHigh() {

		Select sc = new Select(driver.findElement(filterDropdown));

		sc.selectByVisibleText("Price (low to high)");
	}

	// Sort Price High to Low

	public void sortPriceHighToLow() {

		Select sc = new Select(driver.findElement(filterDropdown));

		sc.selectByVisibleText("Price (high to low)");
	}

	// Get Selected Filter Option

	public String getSelectedFilterOption() {

		Select sc = new Select(driver.findElement(filterDropdown));

		return sc.getFirstSelectedOption().getText();
	}
}