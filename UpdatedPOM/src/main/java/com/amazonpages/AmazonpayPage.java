package com.amazonpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.keywords.Constantss;

public class AmazonpayPage {
	@FindBy(xpath="//a[contains(text(),'Amazon Pay')]")
	static WebElement selectamazonpay_tab;
	
	@FindBy(xpath="//*[@id=\"BirthdayGiftCards\"]/span/a/div[2]/span")
	static WebElement birthdaycards_tab;
	
	@FindBy(xpath="//*[@id=\"leftNav\"]/ul[2]/div/li/span/span/div/label/span/span")
	static WebElement recipient_Friend_tab;
	
	
	@FindBy(xpath="//div[@data-a-input-name='s-ref-checkbox-4464915031']")
	static WebElement language_English_tab;
	
	public void selectElement() {
		selectamazonpay_tab.click();
	}
	public void selectBirthdaycard() {
		birthdaycards_tab.click();
	}
	public void hoverMouse() {
		Constantss.driver.switchTo().window(Constantss.driver.getWindowHandle());
		language_English_tab.isDisplayed();
	}

}
