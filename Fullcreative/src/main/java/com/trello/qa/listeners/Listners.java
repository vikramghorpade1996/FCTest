package com.trello.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.trello.qa.base.TestBase;

public class Listners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "testCase passed with the name:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("testCase failed with the name:" + result.getName());
		test.log(Status.FAIL, "testCase Failed   the name:" + result.getName());
		test.addScreenCaptureFromPath(takeScreenShot(result.getName()));

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "testCase skipped with the name:" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
