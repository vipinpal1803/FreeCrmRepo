package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase {
	
	LoginPage loginPage; // Declare the loginPage object at the class level
	HomePage homePage ;
	static Logger log = Logger.getLogger(LoginPageTest.class);	
	
	public LoginPageTest()
	{
		super(); // super keyword is used to call the super class constructor and initialized the properties defined in Base Class Constructor 
	}
	
	@BeforeMethod
	public void setUp(){
		log.info("****************************** Starting test cases execution  *****************************************");
		initialization();
		 loginPage = new LoginPage();	
		 
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);

	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("******************************End test cases execution *****************************************");
	}

}
