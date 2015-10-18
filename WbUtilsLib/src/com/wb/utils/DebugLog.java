package com.wb.utils;

import android.util.Log;

/**
 * 
 * @author Navjot singh
 * @version 1.0
 * @since   2015-06-26
 */
public class DebugLog{
	private static String TAG = "WBUtils";
	private static String className;
	private static int lineNumber;
	private static boolean Debug = true;

	private DebugLog(){
		/* Protect from instantiations */
	}

	private static boolean isDebuggable() {
		return Debug;
	}
	
	/**
	 * 
	 * @param Debug Set Debug log enable or disable
	 */
	public static void setDebuggable(boolean Debug) {
		DebugLog.Debug = Debug;
	}
	
	
	private static String createLog( String log ) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(lineNumber);
		buffer.append(":");
		buffer.append(className);
		buffer.append("]");
		buffer.append(TAG);
		buffer.append(": ");
		buffer.append(log);

		return buffer.toString();
	}

	private static void getMethodNames(StackTraceElement[] sElements){
		className  = sElements[1].getFileName();
		lineNumber = sElements[1].getLineNumber();
	}

	/**
	 * 
	 * @param message set error log message
	 */
	public static void e(String message){
		if (!isDebuggable())
			return;

		// Throwable instance must be created before any methods  
		getMethodNames(new Throwable().getStackTrace());
		Log.e(TAG, createLog(message));
	}

	/**
	 * 
	 * @param message set information log message
	 */
	public static void i(String message){
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.i(TAG, createLog(message));
	}

	/**
	 * 
	 * @param message set debug log messages
	 */
	public static void d(String message){
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.d(TAG, createLog(message));
	}

	/**
	 * 
	 * @param message set verbos log message
	 */
	public static void v(String message){
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.v(TAG, createLog(message));
	}

	/**
	 * 
	 * @param message set warning log messages
	 */
	public static void w(String message){
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.w(TAG, createLog(message));
	}

	/**
	 * 
	 * @param message
	 */
	public static void wtf(String message){
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.wtf(TAG, createLog(message));
	}
	
}//DebugLog
