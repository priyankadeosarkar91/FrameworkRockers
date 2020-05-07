package com.amazonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.keywords.Constantss;

public class SignInPage {
	@FindBy(xpath="//*[@id=\"nav-signin-tooltip\"]/a/span")
	static WebElement signin_tab;
	
	@FindBy(css="#ap_email")
	static WebElement emailphone_tab;
    
	@FindBy(xpath="//input[@id='continue']")
	static WebElement continue_tab;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	static WebElement password_tab;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	static WebElement login_tab;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	static WebElement password_tabsecure;
	
	@FindBy(xpath="//*[@id=\"auth-captcha-guess\"]")
	static WebElement captcha_tab;
	
	@FindBy(css ="a#nav-link-accountList")
	static WebElement signintab_Mhover;
	
	
	public void clickSignin() {
		signin_tab.click();		
	}
	public void emailorPhone(String value) {
		emailphone_tab.sendKeys(value);
	}
	public void continueSignin() {
		continue_tab.click();
	}
	public void password(String value) {
		password_tab.sendKeys(value);
	}
	public void login() {
		login_tab.click();
	}
	public void securepassword(String value) {
		password_tabsecure.sendKeys(value);
	}
	public void entercaptcha(String value) {
		captcha_tab.sendKeys(value);
	}
	public void mousehoverOnSignInTab() {
		Constantss.action=new Actions(Constantss.driver);
		Constantss.action.moveToElement(signintab_Mhover).perform();
		
	}
	public void clickonSignInTab() {
		Constantss.action=new Actions(Constantss.driver);
		Constantss.action.moveToElement(signintab_Mhover).click().perform();
	}


}
