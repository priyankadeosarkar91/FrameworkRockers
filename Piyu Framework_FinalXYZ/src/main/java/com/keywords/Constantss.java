package com.keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Constantss {
	public static WebDriver driver;
	public static String url;
	public static Actions action;
	public static AShot ashot;
	public static String parentWindowHandle;
	public static Object screenshot;
	public static Screenshot screenshot1;
public static FileInputStream file;
public static Properties prop;
public static ChromeOptions options;
}
