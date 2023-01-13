package com.trello.qa.pages;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trello.qa.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "//p[text()='Create']")
	private WebElement createButton;

	@FindBy(id = "header-create-board-button")
	private WebElement createBoardButton;

	@FindBy(xpath = "//form//label/input")
	private WebElement boardTitleInput;

	@FindBy(xpath = "//form/button")
	private WebElement createBoardSubmitBtn;

	@FindBy(xpath = "//span[@class='placeholder']")
	private WebElement addListBtn;

	@FindBy(xpath = "//input[@class='list-name-input']")
	private WebElement listNameInput;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addList;

	@FindBy(xpath = "//span[text()='Add a card']")
	private WebElement addCard;

	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card�']")
	private WebElement enterCardName;

	@FindBy(xpath = "//input[@type='submit' and @value='Add card']")
	private WebElement addCardBtn;

	@FindBy(xpath = "//div[@class='list-card-details js-card-details']")
	private WebElement cardListA;

	@FindBy(xpath = "//div[@class='list-header-target js-editing-target'][2]")
	private WebElement targetListB;

	@FindBy(xpath = "//span[@title='Vikram Ghorpade (vikramghorpade)']")
	private WebElement userAccount;

	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logOutBtn;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public TreeMap getXYCoordintes(String boardTitle, String firstListName, String secondListName, String cardName) {
		WebDriverWait w = new WebDriverWait(driver, 3);
		// presenceOfElementLocated condition
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Create']")));
		createButton.click();
		w.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/section/div/div/nav/ul/li[1]/button")));
		createBoardButton.click();
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form//label/input")));
		boardTitleInput.sendKeys(boardTitle);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/button")));
		createBoardSubmitBtn.click();

		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='list-name-input']")));
		listNameInput.sendKeys(firstListName);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));
		addList.click();
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='list-name-input']")));
		listNameInput.sendKeys(secondListName);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));
		addList.click();
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add a card']")));
		addCard.click();

		w.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//textarea[@placeholder='Enter a title for this card�']")));
		enterCardName.sendKeys(cardName);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit' and @value='Add card']")));
		addCardBtn.click();

		Actions actions = new Actions(driver);
		w.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='list-card-details js-card-details']")));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/div[1]/div[2]/div[1]/div/main/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div[1]/div[1]")));

		actions.dragAndDrop(cardListA, targetListB).build().perform();

		Point point = cardListA.getLocation();

		TreeMap coordinates = new TreeMap();

		coordinates.put("X", point.getX());
		coordinates.put("Y", point.getY());

		return coordinates;

	}

	public void logOut() {

		WebDriverWait w = new WebDriverWait(driver, 3);
		// presenceOfElementLocated condition
		w.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@title='Vikram Ghorpade (vikramghorpade)']")));
		userAccount.click();
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Log out']")));
		logOutBtn.click();
	}

}
