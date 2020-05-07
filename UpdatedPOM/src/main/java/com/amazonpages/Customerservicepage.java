package com.amazonpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Customerservicepage {

	@FindBy(xpath = "//a[contains(text(),'Customer Service')]")
	static WebElement customerservice_tab;

	@FindBy(xpath = "//input[@type=\"search\"]")
	static WebElement find_moresolutions_tab;

	@FindBy(xpath = "//input[@class=\"a-button-input\"]")
	static WebElement go_tab;

	public void selectService() {
		customerservice_tab.click();
	}

	public void findmoreSolutions(String value) {
		find_moresolutions_tab.sendKeys(value);
	}

	public void searchGo() {
		go_tab.click();
	}
}
