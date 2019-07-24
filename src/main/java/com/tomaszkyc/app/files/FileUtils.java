package com.tomaszkyc.app.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class FileUtils {
	
	public static String readTextFromFile(String path) throws FileNotFoundException { 
		
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(new File(path));
		
		while( scanner.hasNext() ) { 
			
			stringBuilder.append( scanner.nextLine() );
			stringBuilder.append( System.lineSeparator() );		
			
		}
		
		return stringBuilder.toString();
	}
	
}
