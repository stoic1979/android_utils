package com.wb.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * 
 * @author Navjot singh
 * @version 1.0
 * @since   2015-06-26
 */
public class Utils {

	/**
	 * show toast message
	 * @param context
	 * @param layout layout for toast
	 * @param gravity set gravity of toast
	 * @param duration set duration of toast
	 */
	public static void showToast(Context context, View layout, int gravity, int duration){  
		Toast toast = new Toast(context);
		toast.setDuration(duration);
		toast.setGravity(gravity, 0, 0);
		toast.setView(layout);
		toast.show();
	}

}//Utils
