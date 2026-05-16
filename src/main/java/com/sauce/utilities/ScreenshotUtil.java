package com.sauce.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void captureScreenshot(WebDriver driver, String testName) {

		// Convert Driver To Screenshot

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		// Create Timestamp

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		// File Path

		File destination = new File(
				System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png");

		try {

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot Saved Successfully");

		} catch (IOException e) {

			System.out.println("Unable To Capture Screenshot");

			e.printStackTrace();
		}
	}
}
