package com.FR_hybridframework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.FR_hybridframework.keywords.Constants;

public class ReturnOrderPage {

	@FindBy(xpath = "//*[@id=\"nav-orders\"]")
	WebElement clickOnreturnAndOrder;

	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[2]/span/span")
	WebElement clickOnOrder;
	
	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[3]/span/a")
	WebElement clickOnbuyAgain;

	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[4]/span/a")
	WebElement clickOnopenOrder;

	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")
	WebElement clickOndigitalOrder;

	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[6]/span/a")
	WebElement clickOncancelledOrder;
	
	@FindBy(id="searchOrdersInput")
	WebElement searchTab;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement checksearchBox;
	
	private WebElement cleartab;
	
	
	public void returnandorder() {
		Constants.action=new Actions(Constants.driver);
		Constants.action.moveToElement(clickOnreturnAndOrder).click().perform();
		
	}
	
	public void order() {
		clickOnOrder.click();
		System.out.println(clickOnOrder.getText());
		
	}
	public void BuyAgain() {
		clickOnbuyAgain.click();
		System.out.println(clickOnbuyAgain.getText());
	}
	public void OpenOrder() {
		clickOnopenOrder.click();
		System.out.println(clickOnopenOrder.getText());
	}
	public void DigitalOrder(){
		clickOndigitalOrder.click();
		System.out.println(clickOndigitalOrder.getText());
	}
	public void cancelledOrder() {
		clickOncancelledOrder.click();
		System.out.println(clickOncancelledOrder.getText());
	}

	public void hit_Search() {
		searchTab.click();
		}
	
	public void tabTosearchBox(String value) {
		searchTab.sendKeys(value);
		System.out.println(searchTab.getText());
	}
	
	public void clearText() {
		cleartab.sendKeys(Keys.BACK_SPACE);
	}

}
