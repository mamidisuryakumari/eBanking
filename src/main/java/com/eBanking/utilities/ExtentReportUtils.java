package com.eBanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {

	private static ExtentReports extent;
	private static ExtentTest test;

	
	

	public static void initReport() {
		if (extent == null) {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
					"ExtentReport.html" + CommonUtils.getCurrentDateTime());
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Automation Test Report");
			htmlReporter.config().setReportName("Ecommerce BDD Test Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
	}

	public static void createTest(String featureName,String scenarioName) {
		test = extent.createTest(featureName +"------"+scenarioName );
	}

	public static void logInfo(String message) {
		test.info(message);
	}

	public static void logPass(String message) {
		test.pass(message);
	}

	public static void logfail(String message) {
		test.fail(message);
	}

	public static void addScreenShot(String message) {
		test.addScreenCaptureFromPath(message);
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}

}
