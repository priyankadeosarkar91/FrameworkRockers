package com.framework_PDD.amazon.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework_PDD.keywords.Constants;
import com.framework_PDD.pages.ProductPage;

public class ProductPageTest {
	@Test
	public void verifyProductSelection() {
		//Configure setup is in class >>> Config_test.java
		
		//Expected to execute sign-in page first before product page
	
		ProductPage productPage=PageFactory.initElements(Constants.driver.switchTo().window(Constants.driver.getWindowHandle()), ProductPage.class);
		productPage.enterTextToBeSearched("washing machine 7.5 kg");
		productPage.searchProduct();
		Constants.driver.switchTo().window(Constants.driver.getWindowHandle());
		Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		productPage.selectBrandsRefinements("2 Stars & Up");
		productPage.selectBrandsRefinements("Whirlpool");
		productPage.selectProductFromListByIndex();
		Constants.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//System.out.println(Constants.driver.getTitle());
		productPage.productAddtoWishList();
	
		
	}

}
