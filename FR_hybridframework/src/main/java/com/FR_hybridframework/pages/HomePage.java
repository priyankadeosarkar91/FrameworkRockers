package com.FR_hybridframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(id="twotabsearchtextbox")
	static WebElement entersearch_tab;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	static WebElement search_tab;
	
	@FindBy(id="searchDropdownBox")
	static WebElement dropdown_tab;
	
	public void tabTosearch(String value) {
		entersearch_tab.sendKeys(value);
		
	}
	public void searchButton() {
		search_tab.click();
	}
	public void check_Dropdown(String value) {
		dropdown_tab.sendKeys(value);
	}

}
