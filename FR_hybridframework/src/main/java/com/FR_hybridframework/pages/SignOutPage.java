package com.FR_hybridframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.FR_hybridframework.keywords.Constants;

public class SignOutPage {
	
	@FindBy(css ="a#nav-link-accountList")
	static WebElement accounttab_Mhover;
	
	@FindBy(css ="a#nav-item-signout")
	static WebElement signout_tab;
	
	public void mousehoverOnAccountTab() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(accounttab_Mhover).perform();
	}
	
	public void clickonSignoutTab() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(signout_tab).click().perform();
	}

}
