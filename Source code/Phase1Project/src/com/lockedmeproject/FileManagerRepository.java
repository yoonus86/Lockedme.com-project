package com.lockedmeproject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileManagerRepository {
	public static List<String> retrieveAllFiles(String path){
		// create a file object
		File file=new File(path); 
		
		//Fetching all files to file array
		File[] fileList=file.listFiles() ;
		
		// String list to store file names created
		List<String> namesOfFiles=new ArrayList<String>();
		
		// Looping through file array to get the name and save to the nameOfFiles
		for(File f: fileList) {
			namesOfFiles.add(f.getName());
		}
		// return the List of file names
		return namesOfFiles;
		
	}
	/**
	 * Using this method we can add new files into the directory
	 * @param fileName
	 * @param sentence
	 * @return
	 */
	public static boolean addFile(String path, String fileName,List<String> sentence) {
		
		try {
			File file=new File(path,fileName);
			FileWriter writer=new FileWriter(file) ;
			
			for(String words:sentence) {
				writer.write("new content" +words+"\n");
			}
			writer.close();
			return true;
		}
		catch(Exception Ex) {
			return false;
		}
		
		
	}
	/**
	 * Method to delete user entered files from directory
	 * @param path
	 * @param nameOfFile
	 * @return
	 */
	public static boolean deleteFiles(String path, String nameOfFile) {
		// file location
		File file = new File(path+"\\"+nameOfFile);
		// return true if file deleted successfully else false
		try {
			if(file.delete()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception Ex) {
			return false;
		}
	}
	/**
	 * this is a method to search a file in the directory
	 * @param path
	 * @param nameOfFile
	 * @return
	 */
	public static boolean searchFile(String path, String nameOfFile) {
		
		//file path to search
		File file=new File(path+"\\"+nameOfFile);
		// checking weather the file exists or not
		if(file.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
		
}	
