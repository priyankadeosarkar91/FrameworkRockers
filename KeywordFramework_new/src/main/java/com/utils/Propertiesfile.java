package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.keywords.Constant;

public class Propertiesfile {
	static String value = null;

	public static String getProperty(String key) throws FileNotFoundException {
		try {
			Constant.file = new FileInputStream("src/main/resources/OR.properties");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);
			value = Constant.prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to open Object Repository");
			e.printStackTrace();
		}
		return value;
	}

	public static String getProperty(String key, String filePath) {
		String value = null;
		try {
			Constant.file = new FileInputStream(filePath);
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);
			value = Constant.prop.getProperty(filePath);
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
			Constant.file = new FileInputStream("src/main/resources/OR.properties");
			Constant.prop = new Properties();
			Constant.prop.load(Constant.file);
			String part = Constant.prop.getProperty(Key);
			values = part.split("##");
			System.out.println("Locator type " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open Object repository");
			e.printStackTrace();
		}
		return values;
	}

	public static void main(String[] args) throws IOException {
		getLocator("#ap_email");
	}
}
