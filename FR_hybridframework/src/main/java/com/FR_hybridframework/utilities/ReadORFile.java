package com.FR_hybridframework.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadORFile {
	public static String getProperty(String key) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/OR.properties");
			Properties prop = new Properties();
			prop.load(fis);
			value = (String) prop.get(key);
		} catch (IOException e) {
			System.out.println("Unable to open Object Repository");
			e.printStackTrace();
		}
		return value;
	}

	public static String getProperty(String key, String filePath) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(filePath);
		} catch (IOException e) {
			System.out.println(filePath + filePath + "file not found");
			e.printStackTrace();
			System.out.println("Unable to load file " + filePath);
		}

		return value;
	}

	public static String[] getLocator(String Key) throws IOException {
		String[] values = null;
		try {
			FileInputStream fis = new FileInputStream(
					"src/main/resources/OR.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String part = prop.getProperty(Key);
			values = part.split("##");
			System.out.println("Locator type " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open Object repository");
			e.printStackTrace();
		}
		return values;
	}

	/*
	 * 
	 * public static String getLocatorType(String key) { String
	 * value=getProperty(key); return value.split("##")[0]; }
	 * 
	 * public static String getLocatorValue(String key) { String
	 * value=getProperty(key); return value.split("##")[1]; }
	 */

}
