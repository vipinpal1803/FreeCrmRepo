package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;


	public HomePageTest()
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
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle  = homePage.verifyHomePageTitle();

		Assert.assertEquals(homePageTitle , "CRMPRO", "Home page title not matched");
	}

	@Test(priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		boolean flag =homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}


	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		testUtil.switchToFrame();
		contactPage =homePage.clickOnContactLink();

	}

	@Test(priority=4, enabled = false)
	public void verifyDealsLinkTest()
	{
		dealsPage =homePage.clickOnDealLink();

	}

	@Test(priority=5, enabled = false)
	public void verifyTasksLinkTest()
	{
		tasksPage =homePage.clickOnTasksLink();

	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
