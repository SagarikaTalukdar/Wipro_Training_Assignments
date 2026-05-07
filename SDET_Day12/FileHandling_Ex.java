package SDET_Day12;

import java.io.*;

public class FileHandling_Ex {
	public static void main(String[] args) {
		
		try {
			File file = new File("koyel.txt");
			if(file.createNewFile()) {
				System.out.println("File Created Successfully!");
			}
			else {
				System.out.println("File Already Exist!");
			}
			
			 FileWriter writer = new FileWriter("example.txt");
			 writer.write("Hello, this is file handling in Java.\n");
	         writer.write("We are learning create, write and read.");
	         writer.close();
	         System.out.println("Data written successfully.");
	         BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
	         
	         String line;

	         System.out.println("\nReading file content:");
	         while ((line = reader.readLine()) != null) {
	        	 System.out.println(line);
	         }
	         reader.close();
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
