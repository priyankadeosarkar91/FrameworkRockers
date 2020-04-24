package com.keywords.utilties;

import org.apache.log4j.Logger;

public class Logs {
	// initialize log4j instance
	private static Logger Log = Logger.getLogger(Logger.class.getName());

	// we can use it when starting tests
	public static void StartLog(String testClassName) {
		Log.info("Test is starting");
	}

	// we can use it while ending tests
	public static void endLog(String testClassName) {
		Log.info("Test is ending");
	}

	// Info level Logs
	public static void info(String message) {
		Log.info(message);
	}

	// Warn level logs
	public static void warn(String message) {
		Log.warn(message);
	}

	// Error level logs
	public static void error(String message) {
		Log.error(message);
	}

	// Fatal level logs
	public static void fatal(String message) {
		Log.fatal(message);
	}

	// Debug level logs
	public static void debug(String message) {
		Log.debug(message);

	}

	public static void assertLog(boolean b, String s) {
		Log.assertLog(false, s);
		
	}
}
