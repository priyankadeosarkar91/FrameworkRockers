package com.framework_PDD.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.framework_PDD.keywords.Constants;

public class HandleBuyProductPage {
	
	@FindBy(how = How.CSS, using = "input#add-to-wishlist-button-submit")
	static WebElement addtowishListbtn;
	//a[@title='Whirlpool 7.5 Kg 5 Star Fully-Automatic Top Loading Washing Machine (WHITEMAGIC ELITE 7.5, Grey, Hard Water Wash)']
	
	@FindBy(how = How.CSS, using = "input#itemSearchTextInput")
	static WebElement searchproductinWLtab;
	
	@FindBy(how = How.XPATH, using = "//a[@class='a-link-normal wl-image-overlay']")
	static WebElement productfromWL;
	
	public void productAddtoWishList() {
		addtowishListbtn.click();
	}
	
	public void productSearchInWishList(String value) {
		searchproductinWLtab.sendKeys(value);
	}
	
	public void keyAction() {
		try {
			Constants.robot=new Robot();
			Constants.robot.keyPress(KeyEvent.VK_ENTER);
			Constants.robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void verifyProductinWishList() {
		productfromWL.click();
	}


}
