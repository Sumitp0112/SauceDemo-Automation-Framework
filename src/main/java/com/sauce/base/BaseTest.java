package com.sauce.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	// Method to launch browser and open application

	public void launchBrowser() {

		// Setup ChromeDriver

		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser

		driver = new ChromeDriver();

		// Maximize Browser Window

		driver.manage().window().maximize();

		// Implicit Wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Application URL

		String url = "https://www.saucedemo.com/";

		driver.get(url);
	}

	// Method to close browser

	public void closeBrowser() {

		if (driver != null) {

			driver.quit();
		}
	}
}