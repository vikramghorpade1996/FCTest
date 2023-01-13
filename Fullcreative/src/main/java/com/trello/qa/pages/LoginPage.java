package com.trello.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trello.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//a[@href='/login' and @class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
	private WebElement loginButton;

	@FindBy(id = "user")
	private WebElement userName;

	@FindBy(id = "login")
	private WebElement continueButton;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-submit")
	private WebElement submitButton;

	public LoginPage() {	
		PageFactory.initElements(driver, this);
	}


	public DashboardPage validLogin(String username, String pass) {
		loginButton.click();
		userName.sendKeys(username);
		continueButton.click();
		WebDriverWait w = new WebDriverWait(driver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"login-submit\"]")));
		password.sendKeys(pass);
		
		w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id=\"login-submit\"]")));
		submitButton.click();

		return new DashboardPage();
	}
}


