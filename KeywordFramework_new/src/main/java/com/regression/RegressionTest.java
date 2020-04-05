package com.regression;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.keywords.Constant;
import com.keywords.Keyword;
import com.utils.Propertiesfile;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class RegressionTest {
	@BeforeTest
	public void regressionTest() throws InterruptedException {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.amazon.in");
		Keyword.maximizeBrowser();
		Keyword.applyWait();
		System.out.println("open url for testcase");
	}
	@Test
	public void signIn() throws IOException, InterruptedException {
		Keyword.clickonElement("XPATH", "//span[contains(text(),'Hello. Sign in')]");
	//	Keyword.enterText(Propertiesfile.getLocator("#ap_email")[0],Propertiesfile.getLocator("ap_email")[1],"piyupatil5029@gmail.com");
		Keyword.enterText("CSS", "#ap_email", "piyupatil5029@gmail.com");
		Keyword.clickonElement("XPATH", "//input[@id='continue']");
		Keyword.enterText("CSS", "#ap_password", "nishikantpatil");
		Keyword.clickonElement("CSS", "#signInSubmit");
		System.out.println("Login successful");
		Keyword.applyWait();
		Keyword.takeScreenshot();
	}

	@Test(priority = 3)
	public void tabtoSearchbox() {
		Keyword.clickonElement("XPATH","//*[@id=\"nav-xshop\"]/a[5]");
		}

/*	@Test(priority = 2)
	public void addtoCart() throws InterruptedException {
		Keyword.clickonElement("CSS", "#nav-xshop");
		System.out.println("product added to cart");
	}*/

/*	@Test(priority = 4)
	public void screenshot() {
		AShot ashot=new AShot();
		BufferedImage image=ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(Constant.driver).getImage();	
			try {
				ImageIO.write(image, "JPG", new File("D:\\Screenshot.UsingAshot.jpg"));
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				Constant.driver.quit();
			}
	}	*/
		@Test(priority=5)
	public void verifyCustomerservice() {
		Keyword.clickonElement("", "");
		
	}

	//@Test(priority = 6)
	//public void closeBrowser() {
//		Keyword.closeBrowser();
//	}

	//@Test(priority = 5)
	//public void tearDown() {
	//	Keyword.closeAllbrowser();
	//}
}
