package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	TestUtil testUtil;

	//Page Factory --OR

	@FindBy(xpath = "//td[contains(text(),'User: Gagan Khanna')]")
	public WebElement userNameLabel; 


	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;


	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	public WebElement dealLink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	public WebElement tasksLink;


	//Initializing the Page Objects:

	public HomePage()
	{
		PageFactory.initElements(driver, this);

	}

	//Actions

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}

	public ContactPage clickOnContactLink(){

		contactsLink.click();
		return new ContactPage();
	}


	public DealsPage clickOnDealLink(){

		dealLink.click();
		return new DealsPage();

	}

	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink()  {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newContactLink);

		//newContactLink.click();
	}



}
