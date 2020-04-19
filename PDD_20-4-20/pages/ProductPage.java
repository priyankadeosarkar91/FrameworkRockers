package com.framework_PDD.pages;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.framework_PDD.keywords.Constants;



public class ProductPage {
	@FindBy(how = How.CSS, using = "input#twotabsearchtextbox")
	static WebElement texttosearch;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Go']")
	static WebElement searchbtn;
	
	@FindBy(how = How.CSS, using = "div#brandsRefinements>ul>li>span>a>span")
	static List<WebElement> brandsrefinements;
	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"js_45\"]/div/div/ul/li[1]/a/span/span")
//	static WebElement speedOfRotation;
//	@FindBy(how = How.XPATH, using = "//*[@id=\"js_45\"]/div/div/ul/li[1]/a/span/span")
//	static WebElement color;
	
	@FindBy(how = How.XPATH, using = "(//a[@class='a-link-normal']/div)[2]") // Select 2nd product from list
	static WebElement productselect;
	
	@FindBy(how = How.CSS, using = "a#wishListMainButton-announce")
	static WebElement addtowishListbtn;
	

	public void enterTextToBeSearched(String value) {
		texttosearch.sendKeys(value);
	}
	public void searchProduct() {
		searchbtn.click();
	}
	
	public void selectBrandsRefinements(String enterText) {
		for (WebElement selectOptionFromList : brandsrefinements) {
			if (selectOptionFromList.getText().equalsIgnoreCase(enterText)) {
				selectOptionFromList.click();
				break;
			}
		}
	}
	
	public void selectProductFromListByIndex() {
		Constants.parentWindowHandle=Constants.driver.getWindowHandle();
		productselect.click();
		Set <String> childWindow=Constants.driver.getWindowHandles();
		System.out.println("child Window handles : " + childWindow);
		
		for(String handle:childWindow) {
			if(!Constants.parentWindowHandle.equalsIgnoreCase(handle)) {
				Constants.driver.switchTo().window(handle);
			}
		}
	}
	
	public void productAddtoWishList() {
		addtowishListbtn.click();
	}
	
}
