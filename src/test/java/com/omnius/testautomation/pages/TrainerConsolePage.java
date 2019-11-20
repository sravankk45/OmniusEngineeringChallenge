package com.omnius.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.omnius.testautomation.pages.LoginPage;

/**
* This class is for operations that user performs in Trainer Console Page of Application
* @version 1.0
* @author Sravan
*/

public class TrainerConsolePage {
	
	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;
    LoginPage loginPage;

    @FindBy(xpath="//section[1]//a[2]")
    WebElement annotate;
    
  	WebDriverWait	wait;
  	

    public TrainerConsolePage(WebDriver driver){
    	
        this.driver = driver;
      	wait= new WebDriverWait(driver, 60); 
      	
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //Click on Annotate button
    public void clickAnnotateButton(){
  
    	wait.until(ExpectedConditions.elementToBeClickable(annotate));	
    	annotate.click();

    }

}
