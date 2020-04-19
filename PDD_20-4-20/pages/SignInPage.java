package com.framework_PDD.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.framework_PDD.keywords.Constants;


public class SignInPage {
	@FindBy(css ="a#nav-link-accountList")
	static WebElement signintab_Mhover;
	
	@FindBy(id="ap_email")
	static WebElement username_tb;
	
	@FindBy(css ="input#continue")
	static WebElement continue_btn;
	
	@FindBy(id ="ap_password")
	static WebElement password_tb;
	
	@FindBy(css ="input#signInSubmit")
	static WebElement login_btn;
	
	@FindBy(id ="continue")
	static WebElement authenticationlogin_btn;
	
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
	
	public void clickonAuthenticationLogin() {
		authenticationlogin_btn.click();
	}
	

}
