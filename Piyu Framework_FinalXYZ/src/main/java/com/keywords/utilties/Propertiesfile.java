package com.keywords.utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.keywords.Constantss;

public class Propertiesfile {
	static String value = null;

	public static String getProperty(String key) throws FileNotFoundException {
		try {
			Constantss.file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\XYZ\\src\\main\\resources\\OR.properties");
			Constantss.prop = new Properties();
			Constantss.prop.load(Constantss.file);
			value = Constantss.prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to open Object Repository");
			e.printStackTrace();
		}
		return value;
	}

	public static String getProperty(String key, String filePath) {
		String value = null;
		try {
			Constantss.file = new FileInputStream(filePath);
			Constantss.prop = new Properties();
			Constantss.prop.load(Constantss.file);
			value = Constantss.prop.getProperty(filePath);
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
			Constantss.file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\XYZ\\src\\main\\resources\\OR.properties");
			Constantss.prop = new Properties();
			Constantss.prop.load(Constantss.file);
			String part = Constantss.prop.getProperty(Key);
			values = part.split("##");
			System.out.println("Locator type " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open Object repository");
			e.printStackTrace();
		}
		return values;
	}



}



