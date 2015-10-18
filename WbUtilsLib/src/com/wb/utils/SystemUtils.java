package com.wb.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

/**
 * 
 * @author Navjot singh
 * @version 1.0
 * @since   2015-06-26
 */
public class SystemUtils {

	/**
	 * 
	 * @param context Tur wifi on
	 * Use Permission
	 * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	 * <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
	 */
	public static void setWifiOn(Context context){
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE); 
		boolean wifiEnabled = wifiManager.isWifiEnabled();
		if(!wifiEnabled)wifiManager.setWifiEnabled(true);
	}

	/**
	 * 
	 * @param context Turn wifi off
	 * Use Permission
	 * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	 * <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
	 */
	public static void setWifiOff(Context context){
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE); 
		boolean wifiEnabled = wifiManager.isWifiEnabled();
		if(wifiEnabled)wifiManager.setWifiEnabled(false);
	}

	/**
	 *  turn on bluetooth on
	 *  Use permission
	 *  <uses-permission android:name="android.permission.BLUETOOTH" />
	 *  <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
	 */
	public static void setBluetoothOn() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		boolean isEnabled = bluetoothAdapter.isEnabled();
		if (!isEnabled) {
			bluetoothAdapter.enable(); 
		}
	}


	/**
	 *  turn on bluetooth off
	 *  Use permission
	 *  <uses-permission android:name="android.permission.BLUETOOTH" />
	 *  <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
	 */
	public static void setBluetoothOff() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		boolean isEnabled = bluetoothAdapter.isEnabled();
		if(isEnabled) {
			bluetoothAdapter.disable();
		}
	}

	/**
	 * 
	 * @param context
	 *  turn on Mobile data and use permission
	 *  <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setMobileDataEnabled(Context context) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
		final Class conmanClass = Class.forName(conman.getClass().getName());
		final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
		connectivityManagerField.setAccessible(true);
		final Object connectivityManager = connectivityManagerField.get(conman);
		final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
		final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
		setMobileDataEnabledMethod.setAccessible(true);

		setMobileDataEnabledMethod.invoke(connectivityManager, true);
	}

	/**
	 * 
	 * @param context
	 * turn off mobile data and use permission
	 * <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setMobileDataDisabled(Context context) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
		final Class conmanClass = Class.forName(conman.getClass().getName());
		final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
		connectivityManagerField.setAccessible(true);
		final Object connectivityManager = connectivityManagerField.get(conman);
		final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
		final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
		setMobileDataEnabledMethod.setAccessible(true);

		setMobileDataEnabledMethod.invoke(connectivityManager, false);
	}



}//SystemUtils
