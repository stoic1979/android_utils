package com.wb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * 
 * @author Navjot singh
 * @version 1.0
 * @since   2015-06-26
 */
public class FileUtils {

	/**
	 * 
	 * @param data to be saved
	 * @param savePath save path of file 
	 */
	public static void writeFileExternalStorage(String data, String savePath){
		try {
			OutputStream outstream = new FileOutputStream(savePath);
			byte[] contentInBytes = data.getBytes();
			//writing file 
			outstream.write(contentInBytes);
			outstream.flush();
			outstream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param path of file where it saved
	 * @return return the file text
	 */
	@SuppressLint("NewApi")
	public static String getFileFromExternalStorage(String path){
		StringBuilder text = null;
		try {
			File f=new File(path);

			//Read text from file
			text = new StringBuilder();

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			//reading file
			while ((line = br.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return text.toString();
	}
	
	/**
	 * 
	 * @param context
	 * @param data to be saved 
	 * @param fileName file name to be saved
	 * @return return save path of file
	 */
	public static String writeFileInternalStorage(Context context, String data, String fileName){
		ContextWrapper cw = new ContextWrapper(context);
		File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
		// Creating imageDir
		File mypath=new File(directory, fileName);

		FileOutputStream fos = null;
		try {           

			fos = new FileOutputStream(mypath);
			//writing file 
			byte[] contentInBytes = data.getBytes();
			fos.write(contentInBytes);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return mypath.getAbsolutePath();
	}

	
	/**
	 * @param context
	 * @param fileName name of file to be saved
	 * @return return the file text
	 */
	@SuppressLint("NewApi")
	public static String getFileFromInternalStorage(Context context, String fileName){
		
		ContextWrapper cw = new ContextWrapper(context);
		File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
		
		StringBuilder text = null;
		try {
			File f=new File(directory, fileName);

			//Read text from file
			text = new StringBuilder();

			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			//reading file
			while ((line = br.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
			br.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return text.toString();
	}
	
	
}//FileUtils
