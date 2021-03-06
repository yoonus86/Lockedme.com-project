package com.lockedmeproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class LockedMe {
    // Location Files
	static final String location="E:\\yoonus\\phase 1 project\\LockedMeFiles";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start=1;
		do {
			int character ;
			character= displayMenu();
		
			// switch method to perform the necessary method specified by user
			switch(character) {
				case 1 : fetchTheFile();
							break;
				case 2 : forgeFile();
							break;
				case 3 : deleteFile();
				            break;
				case 4 : searchFile();
				            break;
				case 5 : System.exit(0);
				            break;
				default : System.out.println("Invalid options");
							break;
			}
			
		}
		while(start>0);
	}
	/**
	 * display application menu
	 */
	public static int displayMenu() {
		Scanner obj = new Scanner(System.in);
		int character;
		
		System.out.println("=====================================================");
		System.out.println("\t\t LockedMe.com");
		System.out.println("=====================================================");
		System.out.println(" ------------------Apploation menu-------------------");
		System.out.println("(1)- View all files");
		System.out.println("(2)- Add file to the directory");
		System.out.println("(3)- Delete a file from the directory");
		System.out.println("(4)- Search a file in the directory");
		System.out.println("(5)- quit the aplication");
		System.out.println("Choose the option : ");
		character=Integer.parseInt(obj.nextLine());
		return character;
		
	}
	/**
	 * method that helps to get all file names
	 */
	public static void fetchTheFile() {
		List<String> fileNames=FileManagerRepository.retrieveAllFiles(location);
		
		if (fileNames.size()==0) {
			System.out.println("No such files exists");
			
		}
		else {
			System.out.println("------ File list------");
		}
		Collections.sort(fileNames);
		for(String f:fileNames) {
			System.out.println(f);
		}
	}
	
	/**
	 * method to add new file
	 */
	public static void forgeFile() {
		Scanner obj=new Scanner(System.in);
		String nameOftheFile;
		int lines;
		List<String> sentences=new ArrayList<String>();
		
		//Fetch the file name from the input
		System.out.println("Enter the file name : ");
		nameOftheFile=obj.nextLine();
		
		// specify the number of line to add to the file
		System.out.println("Enter how many lines to add to the file : ");
		lines=Integer.parseInt(obj.nextLine());
		
		//adding the content into teh file 
		for(int i=1;i<=lines;i++) {
			System.out.println(i+ " : ");
			sentences.add(obj.nextLine());
		}
		
		boolean saveTheWords=FileManagerRepository.addNewFile(location, nameOftheFile, sentences);
		
		if(saveTheWords) {
			System.out.println("A new file "+nameOftheFile+ " has added to the directory");
		}
		else {
			System.out.println("An error detected");
		}
		

	}
	
	/**
	 * this is a method to delete file
	 */
	public static void deleteFile() {
		String nameOfFile;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the file that has to be deleted");
		nameOfFile=obj.nextLine();
		
		boolean toDelete=FileManagerRepository.deleteFiles(location, nameOfFile);
		
		if(toDelete) {
			System.out.println("The file "+nameOfFile+" has been successfully deleted");
		}
		else {
			System.out.println("there is no such files in the directory ");
		}

	}
	/**
	 * method that helps to delete file
	 */
	public static void searchFile() {
		String nameOfFile;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the file that has to be searched");
		nameOfFile=obj.nextLine();
		
		boolean toSearch=FileManagerRepository.searchFile(location, nameOfFile);
		
		if(toSearch) {
			System.out.println("The file exists in the folder");
		}
		else {
			System.out.println("there is no such files in the directory ");
		}
	}
	
}
