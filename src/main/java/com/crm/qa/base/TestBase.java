package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static Logger log = Logger.getLogger(TestBase.class);
	
	
	public TestBase()
	{

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		public static void initialization() {
			
			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				//driver = new ChromeDriver();
				
		        // Create ChromeOptions to customize Chrome settings
		        ChromeOptions options = new ChromeOptions();

		        // Add incognito mode argument
		        options.addArguments("--incognito");

		        // Initialize the Chrome driver with the options
		        driver = new ChromeDriver(options);

		        //log.info("Launching Chrome in Incognito Mode !!!");
				
				
			} else if (browserName.equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				//log.info("Launching Firefox !!!");

			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			/*
			 * driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
			 * java.util.concurrent.TimeUnit.SECONDS);
			 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
			 * java.util.concurrent.TimeUnit.SECONDS);
			 * 
			 */
			
			log.info("entering application URL");
			driver.get(prop.getProperty("url"));
			log.warn("Hey this just a warning message");
			log.fatal("hey this is just fatal error message");
			log.debug("this is debug message");
		}
		
	
	}







