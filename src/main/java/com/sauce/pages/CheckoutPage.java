package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;

	// Constructor

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators

	private By checkoutButton = By.id("checkout");

	private By firstName = By.id("first-name");

	private By lastName = By.id("last-name");

	private By postalCode = By.id("postal-code");

	private By continueButton = By.id("continue");

	private By finishButton = By.id("finish");

	private By cancelButton = By.id("cancel");

	private By backHomeButton = By.id("back-to-products");

	private By errorMessage = By.xpath("//h3[@data-test='error']");

	private By cartItem = By.className("cart_item");

	private By completeMessage = By.className("complete-header");

	private By itemTotal = By.className("summary_subtotal_label");

	private By taxLabel = By.className("summary_tax_label");

	private By totalLabel = By.className("summary_total_label");

	// Click Checkout

	public void clickCheckout() {

		driver.findElement(checkoutButton).click();
	}

	// Enter First Name

	public void enterFirstName(String fname) {

		driver.findElement(firstName).clear();

		driver.findElement(firstName).sendKeys(fname);
	}

	// Enter Last Name

	public void enterLastName(String lname) {

		driver.findElement(lastName).clear();

		driver.findElement(lastName).sendKeys(lname);
	}

	// Enter Zip Code

	public void enterPostalCode(String zip) {

		driver.findElement(postalCode).clear();

		driver.findElement(postalCode).sendKeys(zip);
	}

	// Click Continue

	public void clickContinue() {

		driver.findElement(continueButton).click();
	}

	// Click Finish

	public void clickFinish() {

		driver.findElement(finishButton).click();
	}

	// Click Cancel

	public void clickCancel() {

		driver.findElement(cancelButton).click();
	}

	// Click Back Home

	public void clickBackHome() {

		driver.findElement(backHomeButton).click();
	}

	// Enter Checkout Information

	public void enterCheckoutInformation(String fname, String lname, String zip) {

		enterFirstName(fname);

		enterLastName(lname);

		enterPostalCode(zip);
	}

	// Get Error Message

	public String getErrorMessage() {

		return driver.findElement(errorMessage).getText();
	}

	// Get Complete Message

	public String getCompleteMessage() {

		return driver.findElement(completeMessage).getText();
	}

	// Get Item Total

	public String getItemTotal() {

		return driver.findElement(itemTotal).getText();
	}

	// Get Tax

	public String getTax() {

		return driver.findElement(taxLabel).getText();
	}

	// Get Final Total

	public String getFinalTotal() {

		return driver.findElement(totalLabel).getText();
	}

	// Get Cart Item Count

	public int getCartItemCount() {

		return driver.findElements(cartItem).size();
	}

	// Verify Checkout Overview Page

	public boolean isCheckoutOverviewDisplayed() {

		return driver.getCurrentUrl().contains("checkout-step-two");
	}

	// Verify Checkout Complete Page

	public boolean isCheckoutCompleteDisplayed() {

		return driver.getCurrentUrl().contains("checkout-complete");
	}
}