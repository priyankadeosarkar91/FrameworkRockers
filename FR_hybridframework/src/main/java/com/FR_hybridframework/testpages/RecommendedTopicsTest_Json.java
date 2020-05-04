package com.FR_hybridframework.testpages;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FR_hybridframework.keywords.Keyword;
import com.FR_hybridframework.utilities.Custom_Listeners;
import com.FR_hybridframework.utilities.Logged1;
import com.FR_hybridframework.utilities.ReadJSON;
import com.FR_hybridframework.utilities.ReadORFile;

@Listeners(Custom_Listeners.class)
public class RecommendedTopicsTest_Json{
	
	static final Logger log = Logger.getLogger(Logged1.class);
	
	@Test
	public void tc_001() {
		log.info("************************browserName  Chrome*******************************");
		Keyword.openBrowser(ReadORFile.getProperty("browserName"));
		System.out.println( ReadORFile.getProperty("browserName")+" browser is opened");
	}
	
	@Test(description = "VerifyURL")
	public void tc_002() {
		log.info("*******************************Opening url*************************************");
		Keyword.openURL(ReadORFile.getProperty("amazon.customerUrl"));
		Assert.assertEquals(ReadORFile.getProperty("amazon.customerUrl"),"https://www.amazon.in/gp/help/customer/display.html?nodeId=200507590&ref_=nav_cs_help", "URL is failed");
	}
	
	@Test(description = "verifyRecommandedTopics")
	public void tc_003() {
		log.info("************************Test Recommanded topics >> json data verification test*******************************");
//		boolean istrue=ReadJSON.readJSONfile("Recommended Topics")........
//		Assert.assertTrue(istrue,"Content Mismatch");
		boolean isempty=ReadJSON.readJSONfile(Keyword.getElementfrom("CSS", "a.active").getText()).isEmpty();
		Assert.assertEquals(isempty, true,"Actual JSON : Content Mismatch ");
	}

}

