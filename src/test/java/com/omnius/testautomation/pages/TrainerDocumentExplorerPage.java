package com.omnius.testautomation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
* This class is for operations that user performs in Trainer Document Explorer Page of Application
* @version 1.0
* @author Sravan
*/

public class TrainerDocumentExplorerPage {
	
	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(xpath="//collections[@class='picnicGridColumn2']/heading/button")
    WebElement createNewCollectionButton;
    
    
    @FindBy(xpath="//input[@placeholder='Name']")
    WebElement newCollectionTextBox;
    
    
    @FindBy(xpath="//button[contains(text(),'Create')]")
    WebElement createCollectionButton;
    
    
    @FindBy(xpath="(//input[contains(@placeholder,'Search')])[1]")
    WebElement searchCollection;
    
      
    @FindBy(xpath="//table//tr")
    List<WebElement> rowsCollection;
    
    
    @FindBy(xpath="//table//tr//td[1]")
    List<WebElement> listCollection;
    
    
    @FindBy(xpath="//button[contains(text(),'Upload')]")
    WebElement uploadDocumentsButton;
    
    
    @FindBy(xpath="//documents//chunk[contains(text(),'finished uploading')]")
    WebElement uploadSuccessMessage;
    
    
    @FindBy(xpath="//documents//chunk[contains(text(),'clear finished')]")
    WebElement clearFinishedButton;
    
    
    @FindBy(xpath="//table//th[contains(@class,'sortable')]/icons")
    WebElement sortButton;
    
    
	WebDriverWait	wait;
	JavascriptExecutor js;
	Actions actions;
	SoftAssert softAssertion= new SoftAssert();

    
    public TrainerDocumentExplorerPage(WebDriver driver){
    	
        this.driver = driver;
        wait= new WebDriverWait(driver, 60);  
        
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
    
    //Click on Create New Collection button
    public void clickCreateNewCollectionButton(){
    	
    	js = (JavascriptExecutor) driver; 
    	js.executeScript("arguments[0].click();", createNewCollectionButton);

    }
    
    public void enterNewCollectionName(String collectionName){    	
    	 
    	wait.until(ExpectedConditions.visibilityOf(newCollectionTextBox));
    	newCollectionTextBox.sendKeys(collectionName);

    }
    
    public void clickCreateCollection(){
  
    	wait.until(ExpectedConditions.visibilityOf(newCollectionTextBox));
    	createCollectionButton.click();

    }
    
    public void searchCollection(String collectionName){
    	
    	SoftAssert softAssertion= new SoftAssert();
    	wait.until(ExpectedConditions.elementToBeClickable(searchCollection));	
    	searchCollection.sendKeys(collectionName);
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    	//wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElements(listCollection));   
    	try {
    		
    		Thread.sleep(3000);	
    	}
    	
    	catch(InterruptedException ie) {
   		  
   		  ie.printStackTrace();
   		  
   		  } 
      	int rowSize=rowsCollection.size();

    	for(int i=0;i<rowSize;i++) {
    		
    		String tdCollection=listCollection.get(i).getText();
    		boolean collectionStringCheck=tdCollection.contains(collectionName);
    		softAssertion.assertTrue(collectionStringCheck, "Collection Displayed");
    	}

    }
    
  public void clickCollection(){
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  listCollection.get(0).click();
	  
  }
  
  public void clickuploadDocumentsButton(){
	  

	 // wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(uploadDocumentsButton));
	 // actions.moveToElement(uploadDocumentsButton).click().perform();
	  js = (JavascriptExecutor) driver; 
  	  js.executeScript("arguments[0].click();", uploadDocumentsButton);


  }
  
  public void verifyUpload() {
	  wait.until(ExpectedConditions.visibilityOf(uploadSuccessMessage));
	  actions.moveToElement(uploadSuccessMessage);
	  Assert.assertTrue(uploadSuccessMessage.getText().contains("finished uploading"),"File Uploaded Successfully");
  }
  
  public void clickClearFinishedButton() {
	 
	  actions.moveToElement(clearFinishedButton).click().perform();
	  
  }
      	

}
