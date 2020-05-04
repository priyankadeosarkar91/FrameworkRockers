package com.FR_hybridframework.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.FR_hybridframework.keywords.Constants;

public class SignInPage {
	@FindBy(css ="a#nav-link-accountList")
	static WebElement signintab_Mhover;
	
	@FindBy(css="input#ap_email")
	static WebElement username_tb;
	
	@FindBy(css ="input#continue")
	static WebElement continue_btn;
	
	@FindBy(id ="ap_password")
	static WebElement password_tb;
	
	@FindBy(css ="input#signInSubmit")
	static WebElement login_btn;
	
	@FindBy(id ="continue")
	static WebElement authentication;
	
	@FindBy( xpath="/html/body/div[1]/div[2]/div/div/div/div/div/div[1]/form/div[4]/span/span/input")
	static WebElement authentication_login;
	
	public void mousehoverOnSignInTab() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(signintab_Mhover).perform();
	}
	
	public void clickonSignInTab() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(signintab_Mhover).click().perform();
	}
	public void clearUsername() {
		username_tb.clear();
	}
	
	public void enterUsername(String value) {
		username_tb.click();
		username_tb.sendKeys(value);
	}

	public void continueToLogin() {
		continue_btn.click();
	}
	
	public void clearPassword() {
		password_tb.clear();
	}
	
	public void enterPassword(String value) {
		password_tb.click();
		password_tb.sendKeys(value);
	}
	
	public void clickonLogin() {
		login_btn.click();
	}
	
	public void clickforAuthentication() {
		authentication.click();
	}
	
	public void clickOnContinueForAuthentication() {
		authentication_login.click();
	}

}
