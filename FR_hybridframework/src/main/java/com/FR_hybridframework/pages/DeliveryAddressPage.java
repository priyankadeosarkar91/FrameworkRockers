package com.FR_hybridframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.FR_hybridframework.keywords.Constants;


public class DeliveryAddressPage {
	@FindBy(xpath = "//*[@id=\"glow-ingress-line2\"]")
	WebElement clickOnDeliveryTo;
	
	@FindBy(xpath = "//*[@id=\"GLUXManageAddressLink\"]/a")
	WebElement clickOnManagerAddressBook;
	
	@FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
	WebElement clickOnApply;
	
	@FindBy(xpath = "//*[@id=\"ya-myab-plus-address-icon\"]")
	WebElement clickOnAddAddress;
	
	public void clickOnDeliveryTo() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnDeliveryTo).click().perform();
	}	
	
	public void ClickOnManageAddressBook() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnManagerAddressBook).click().perform();
	}
	public void clickOnApply() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnApply).click().perform();
	}
	
	public void clickOnAddAddress() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnAddAddress).click().perform();
	}
	
	
}


