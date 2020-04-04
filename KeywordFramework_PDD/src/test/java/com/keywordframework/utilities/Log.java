package com.keywordframework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Log {
	public Logger logger;
	FileHandler fh;
	public Log(String fileName) {
		File f=new File(fileName);
		if(!f.exists()) {
			try {
				f.createNewFile();
				fh=new FileHandler(fileName, true);
				logger=Logger.getLogger("NewLog");
				logger.addHandler(fh);
				SimpleFormatter formatter=new SimpleFormatter();
				fh.setFormatter(formatter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
				
	}

}
