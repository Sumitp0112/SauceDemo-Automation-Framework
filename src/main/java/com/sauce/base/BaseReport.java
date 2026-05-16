package com.sauce.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sauce.utilities.ExtentManager;
import com.sauce.utilities.ScreenshotUtil;

public class BaseReport extends BaseTest {

	public static ExtentReports extent;

	public static ExtentTest test;

	// Initialize Report

	@BeforeSuite

	public void setupReport() {

		extent = ExtentManager.getReportInstance();
	}

	// Capture Test Result

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) {

		test = extent.createTest(result.getName());

		// PASS

		if (result.getStatus() == ITestResult.SUCCESS) {

			test.pass("Test Passed Successfully");
		}

		// FAIL

		else if (result.getStatus() == ITestResult.FAILURE) {

			test.fail(result.getThrowable());

			// Capture Screenshot Only For Failed Test Cases

			ScreenshotUtil.captureScreenshot(driver, result.getName());
			System.out.println("Screenshot saved");
		}

		// SKIP

		else {

			test.skip("Test Skipped");
		}
	}

	// Flush Report

	@AfterSuite

	public void tearDownReport() {

		extent.flush();
	}
}


//package com.sauce.base;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.sauce.utilities.ExtentManager;
//
//public class BaseReport {
//
//	public static ExtentReports extent;
//
//	public static ExtentTest test;
//
//	// Initialize Report
//
//	@BeforeSuite
//
//	public void setupReport() {
//
//		extent = ExtentManager.getReportInstance();
//	}
//
//	// Capture Test Result
//
//	@AfterMethod
//
//	public void getResult(ITestResult result) {
//
//		test = extent.createTest(result.getName());
//
//		if (result.getStatus() == ITestResult.SUCCESS) {
//
//			test.pass("Test Passed Successfully");
//		}
//
//		else if (result.getStatus() == ITestResult.FAILURE) {
//
//			test.fail(result.getThrowable());
//		}
//
//		else {
//
//			test.skip("Test Skipped");
//		}
//	}
//
//	// Flush Report
//
//	@AfterSuite
//
//	public void tearDownReport() {
//
//		extent.flush();
//	}
//}