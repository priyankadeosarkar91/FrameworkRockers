package com.amazonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonpayPage {
	@FindBy(xpath="//a[contains(text(),'Amazon Pay')]")
	static WebElement selectamazonpay_tab;
	
	public void selectElement() {
		selectamazonpay_tab.click();
	}

}
