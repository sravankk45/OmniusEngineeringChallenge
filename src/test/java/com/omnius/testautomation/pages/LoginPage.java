package com.omnius.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
* This class is for operations that user performs in Login Page of Application
* @version 1.0
* @author Sravan
*/

public class LoginPage {
	
	 
	/**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(id="username")

    WebElement username;

    

    @FindBy(id="password")

    WebElement password;

    

    @FindBy(id="kc-login")

    WebElement login;

      

    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    //Set Email id in Email Textbox

    public void setUserName(String userName){

    	username.sendKeys(userName);    

    }  

    //Set password in password textbox

    public void setPassword(String strPassword){

    password.sendKeys(strPassword);

    }

    //Click on login button

    public void login(){

    	login.click();

    }
	
	
	
}