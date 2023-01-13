package com.trello.qa.testcases;


import java.util.TreeMap;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.trello.qa.base.TestBase;
import com.trello.qa.pages.DashboardPage;
import com.trello.qa.pages.LoginPage;
import com.trello.qa.utility.PropertiesUtils;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage = null;
	DashboardPage dashboardPage = null;

	@BeforeSuite
	public void setup() {
		initialization();

		
		loginPage = new LoginPage();
		dashboardPage = loginPage.validLogin(PropertiesUtils.readProperty("username"),
				PropertiesUtils.readProperty("password"));

	}

	@Test
	public void verifyCoordinates() {

		TreeMap actualCoordinates = dashboardPage.getXYCoordintes(PropertiesUtils.readProperty("boardtitle"),
				PropertiesUtils.readProperty("firstlistname"), PropertiesUtils.readProperty("secondlistname"),
				PropertiesUtils.readProperty("cardname"));

		System.out.println("X Coordinate is -- " + actualCoordinates.get("X"));
		System.out.println("Y Coordinate is -- " + actualCoordinates.get("Y"));

		dashboardPage.logOut();

	}

	@AfterSuite
	public void tearDown() {
		report.flush();
		driver.close();

	}

}
