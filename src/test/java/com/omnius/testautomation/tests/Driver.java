package com.omnius.testautomation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
* The class creates the WebDriver object and returns
* It is singleton class to ensure same WebDriver object is passed on to all the test cases
* @version 1.0
* @author Sravan
*/

public class Driver {
	
	//Private WebDriver variable to ensure no access to outside class
	private static WebDriver driver;
	
	//Private constructor to ensure Object creation not possible outside class
	private Driver() {
	
	}
	
	public static WebDriver DriverSetup() {	
	
		//Check if the WebDriver object is already created and present returns same object else creates new object
		if(driver==null) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver(chromeOptions);
				
		}
		return	driver;
	}
}