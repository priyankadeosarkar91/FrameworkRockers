package com.testingshastra.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilis {
	public static String getProperty(String key) throws FileNotFoundException {
		String value=null;
		//String path=System.getProperty("user.dir");
		//System.out.println(path);
		try {
			FileInputStream fis=new FileInputStream("D:\\Narayan\\Ecplise_program\\TestingShastraFramework\\src\\main\\resources\\OR.Properties");
			Properties prop=new Properties();
			prop.load(fis);
			value=(String) prop.getProperty(key);
			//System.out.println(value);
			
		} catch (IOException e) {
			System.out.println("Object Reposatory not Found");
			e.printStackTrace();
		}
		return value;
		

	}
	/*public static void main(String[] args) throws FileNotFoundException {
		getProperty("home.sunNavItem");
	}*/
}
