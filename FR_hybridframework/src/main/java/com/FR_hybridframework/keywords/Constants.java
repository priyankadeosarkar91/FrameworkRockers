package com.FR_hybridframework.keywords;


import java.awt.Rectangle;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Constants {
	public static WebDriver driver;
	public static String url;
	public static Actions action;
	public static Robot robot;
	public static ChromeOptions options;
	public static Select select;
	public static AShot ashot;
	public static Rectangle rect;
	public static Screenshot screenshot;
	public static String parentWindowHandle;
	public static String[] expectedSubNAvItem1= {""};
	public static String[] expectedSubNavItems2= {""};
	public static String[] expectedSubNavItems3= {""};

}
