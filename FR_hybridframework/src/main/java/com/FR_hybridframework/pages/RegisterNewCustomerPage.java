package com.FR_hybridframework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterNewCustomerPage {
	@FindBy(css ="a#createAccountSubmit")
	static WebElement createaccounttab;
	
	@FindBy(css ="input#ap_customer_name")
	static WebElement enterName;
	
	@FindBy(css ="input#ap_phone_number")
	static WebElement enterphoneno;
	
	@FindBy(css ="input#ap_password")
	static WebElement setpassword;
	
	@FindBy(css ="input#continue")
	static WebElement continuetab;
	
	
	
	public void clickOnCreateAccountTab() {
		createaccounttab.click();
	}
	
	public void enterCustomerName(String value) {
		enterName.sendKeys(value);
	}
	
	public void enterMobileNo(String value) {
		enterphoneno.sendKeys(value);
	}
	
	public void setNewPassword(String value) {
		setpassword.sendKeys(value);
	}
	
	public void clickOncontinue() {
		continuetab.click();
	}
}
