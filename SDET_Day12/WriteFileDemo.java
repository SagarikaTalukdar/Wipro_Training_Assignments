package SDET_Day12;

import java.io.FileWriter;
import java.io.IOException;
 
public class WriteFileDemo {
public static void main(String[] args)
	{
 
		try {
			FileWriter writer = new FileWriter("renu.txt");
			
			writer.write("Welcome to Java IO Classes");
			writer.write("\nLearning File Handling");
 
			writer.close();
			System.out.println("Data Written Successfully");
			}
 
		catch(IOException e)
            {
            	System.out.println(e);
            }
	}
	}