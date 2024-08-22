package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	String sheetName = "contacts";
	
	

	public ContactPageTest()
	{
		super(); // super keyword is used to call the super class constructor and initialized the properties defined in Base Class Constructor 
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		contactPage = new ContactPage();
		loginPage = new LoginPage();		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage =homePage.clickOnContactLink();
	}



	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactsLabel(), "Contact Label is mismatched on the page");
	}

	@Test(priority=2)
	public void verifySelectContactsByNameTest()
	{
		contactPage.selectContactsByName("Amy Bell");

	}

	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		
		homePage.clickOnNewContactLink();
		//contactPage.createNewContact("Mr.", "Rajat", "Singh", "Google");
		contactPage.createNewContact(title, firstName, lastName, company);
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
