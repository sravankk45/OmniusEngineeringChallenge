package com.omnius.testautomation.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.omnius.testautomation.pages.LoginPage;
import com.omnius.testautomation.pages.TrainerConsolePage;
import com.omnius.testautomation.pages.TrainerDocumentExplorerPage;
import com.omnius.testautomation.utilities.ConfigParams;

/**
 * The class creates the test cases for Login Page of the application
 * 
 * @version 1.0
 * @author Sravan
 */

public class TrainerDocumentExplorerTests {

	WebDriver driver;
	TrainerDocumentExplorerPage trainerDocumentExplorerPage;
	LoginPage loginPage;
	TrainerConsolePage trainerConsolePage;
	
	TrainerDocumentExplorerTests() {

		driver = Driver.DriverSetup();
		trainerDocumentExplorerPage = new TrainerDocumentExplorerPage(driver);
		loginPage=new LoginPage(driver);
		trainerConsolePage=new TrainerConsolePage(driver);

	}

	@BeforeTest
	public void launchSite() {
		
		driver.get("https://omniustest.omnius.com/trainer/ui/");	
		loginPage.setUserName(ConfigParams.userName);
		loginPage.setPassword(ConfigParams.userName);
		loginPage.login();

		
	}
	
	@BeforeMethod
	public void login() {

		driver.get("https://omniustest.omnius.com/trainer/ui/");	
		
	}
	

	// Test Case Document Explorer page opening
	@Test(priority = 1)
	@Parameters({ "collectionName" })
	public void createNewCollection(String collectionName) {
	
		trainerConsolePage.clickAnnotateButton();
		trainerDocumentExplorerPage.clickCreateNewCollectionButton();
		trainerDocumentExplorerPage.enterNewCollectionName(collectionName);
		trainerDocumentExplorerPage.clickCreateCollection();

	}

	@Test(priority = 2)
	@Parameters({ "searchCollection" })
	public void searchCollection(String collectionName) {

		trainerConsolePage.clickAnnotateButton();
		trainerDocumentExplorerPage.searchCollection(collectionName);

	}

	@Test(priority = 3)
	@Parameters({ "fileName","searchCollection" })
	public void uploadDocuments(String fileName,String collectionName) {
	
		trainerConsolePage.clickAnnotateButton();
		trainerDocumentExplorerPage.searchCollection(collectionName);
		trainerDocumentExplorerPage.clickCollection();
		trainerDocumentExplorerPage.clickuploadDocumentsButton();
		
		  try { 
			  
		 //File name passed as Command Line Argument for AutoIt tool			 
		 Process process=Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\FileUploadTool.exe"+"  "+System.getProperty("user.dir")+ "\\src\\test\\resources\\"+fileName);

		  //This step to make WebDriver to wait until System Process to upload file completes		 
		 process.waitFor();
		 
		 trainerDocumentExplorerPage.verifyUpload();
		 trainerDocumentExplorerPage.clickClearFinishedButton();
		  
		  }
		  
		  catch(IOException ioe) {
			  
		  Assert.fail("File not uploaded successfully");
		  ioe.printStackTrace(); 
		  
		  }		  
		
		  catch(InterruptedException ie) {
		  
		  Assert.fail("File not uploaded successfully");
		  ie.printStackTrace();
		  
		  } 
		 
	}
	
	
	@AfterTest
	public void closeBrowser() {
			
		driver.quit();
	}
	

}
