package com.sauce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getReportInstance() {

		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/test-output/ExtentReport.html");

			spark.config().setReportName("Sauce Demo Automation Report");

			spark.config().setDocumentTitle("Automation Test Results");

			extent = new ExtentReports();

			extent.attachReporter(spark);

			extent.setSystemInfo("Tester", "Sumit");

			extent.setSystemInfo("Project", "Sauce Demo");

			extent.setSystemInfo("Environment", "QA");
		}

		return extent;
	}
}