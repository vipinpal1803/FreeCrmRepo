package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory --OR

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginBtn;

	@FindBy(xpath = "//img[@alt='Free CRM Software for customer relationship management, sales and support']")
	public WebElement crmLogo;

	//Initializing the Page Objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
		
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	//  while click on the login button, This method will be return to home page class object
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}



	
	
	
	}




