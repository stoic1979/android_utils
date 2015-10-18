package com.example.wbutilstest;

import com.wb.utils.DebugLog;
import com.wb.utils.FileUtils;
import com.wb.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public String TAG = "MainActivity" ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * turn on wifi, bluetooth, and mobile data
		 */
		turnOnSystemServices();

		/*
		 * Show custom toast
		 */
		toast("Hello", R.drawable.ic_launcher);

		/*
		 * show debug log
		 */
		DebugLog.d("Testing");

		/*
		 * write external storage file
		 */
		FileUtils.writeFileExternalStorage("Hello Testing", Environment.getExternalStorageDirectory()+"/Test.txt");

		/*
		 * write internal storage file
		 */
		FileUtils.writeFileInternalStorage(this, "Hello Testing", "test.txt");
		
		/*
		 * read file from external storage
		 */
		DebugLog.d(FileUtils.getFileFromExternalStorage(Environment.getExternalStorageDirectory()+"/Test.txt"));
		
		/*
		 * read file from internal storage
		 */
		DebugLog.d(FileUtils.getFileFromInternalStorage(this, "test.txt"));
	}



	public void toast(String message, int resId){
		LayoutInflater li = this.getLayoutInflater();
		View layout = li.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_layout));
		TextView textView               = (TextView)layout.findViewById(R.id.custom_toast_message);
		ImageView custom_toast_image    = (ImageView)layout.findViewById(R.id.custom_toast_image);
		custom_toast_image.setImageResource(resId);
		textView.setText(message);
		Utils.showToast(this, layout, Gravity.CENTER_VERTICAL, Toast.LENGTH_LONG);
	}


	public void turnOnSystemServices(){
		/*   SystemUtils.setBluetoothOn();
	      SystemUtils.setWifiOn(this);
	      try {
			SystemUtils.setMobileDataEnabled(this);

		} catch (ClassNotFoundException | NoSuchFieldException
				| IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			e.printStackTrace();
		}*/
	}
}
