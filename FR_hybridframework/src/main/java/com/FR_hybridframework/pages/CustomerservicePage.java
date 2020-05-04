package com.FR_hybridframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.FR_hybridframework.keywords.Constants;



public class CustomerservicePage{
	@FindBy(xpath = "/html/body/div[1]/header/div/div[3]/div[3]/div/div/a[2]")
	static WebElement customerservice_tab;

	@FindBy(xpath = "//input[@type=\"search\"]")
	static WebElement FindMoreSolutions;

	@FindBy(xpath = "//input[@class=\"a-button-input\"]")
	static WebElement go_tab;
	
//	@FindBy(xpath = "//a[contains(text(),'Customer Service')]")
//	static WebElement customerservice_tab;

	@FindBy(xpath = "//input[@type=\"search\"]")
	static WebElement find_moresolutions_tab;

	public void selectService() {
		customerservice_tab.click();
	}

	public void findmoreSolutions(String value) {
		find_moresolutions_tab.sendKeys(value);
	}

	public void searchGo() {
		go_tab.click();
	}

	public void clickOnCustomerService() {
		Constants.action = new Actions(Constants.driver);
		Constants.action.moveToElement(customerservice_tab).click().perform();

	}

	public void clickOnFindMoreSolutions(String value) {
//		Constants.action = new Actions(Constants.driver);
//		Constants.action.moveToElement(FindMoreSolutions).sendKeys(value).perform();
		FindMoreSolutions.sendKeys(value);
		
	}

	public void hit_go() {
		go_tab.click();
	}

}
