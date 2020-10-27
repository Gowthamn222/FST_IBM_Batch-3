package JavaActivity4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity4_2 {

	public static void main(String[] args) throws IOException {
		
		String filePath = "files/newfile.txt";

		try {
			File file = new File(filePath);
			boolean fStatus = file.createNewFile();
			if (fStatus) {
				System.out.println("File created successfully!");
			} else {
				System.out.println("File already exists at this path.");
			}
			
			FileWriter myWriter = new FileWriter(filePath); 
			myWriter.write("Files in Java might be tricky, but it is fun enough!"); 
			myWriter.close();

			// get the file Object
			File fileUtil = FileUtils.getFile(filePath);
			// Read file
			System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

			// Create directory
			File destDir = new File("resources");
			// Copy file to directory
			FileUtils.copyFileToDirectory(file, destDir);

			// Get file from new directory
			File newFile = FileUtils.getFile(destDir, "newfile.txt");
			// Read data from file
			String newFileData = FileUtils.readFileToString(newFile, "UTF8");
			// Print it
			System.out.println("Data in new file: " + newFileData);
		} catch (IOException errMessage) {
			System.out.println(errMessage);
		}

	}

}
