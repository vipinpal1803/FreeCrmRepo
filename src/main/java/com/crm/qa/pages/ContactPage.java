package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	//Page Factory --OR
	@FindBy(xpath ="//td[contains(text(), 'Contacts')]")
	WebElement contactsabel;
	
	@FindBy(xpath ="//select[@name='title']")
	WebElement titleField;
	
	@FindBy(xpath ="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(name ="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	

	//Initializing the Page Objects:

	public ContactPage()
	{
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	
	public boolean verifyContactsLabel()
	{
		return contactsabel.isDisplayed();
	}

	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id123']")).click();
	}


	public void createNewContact(String title, String ftName, String ltName, String comp )
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
		
	}
	

}
