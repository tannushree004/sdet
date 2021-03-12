package Activities;

import java.io.*;

import org.apache.commons.io.FileUtils;


public class Activity4_2 {

	public static void main(String[] args) throws IOException {
		try {
		File file = new File("src/Activities/newfile.txt");
		Boolean fstatus = file.createNewFile();
       if (fstatus) {
    	   System.out.println("File is created");
    	    }
       else {
    	   System.out.println(" The file is not created");
       }
		
		
		File fileUtil =   FileUtils.getFile("src/Activities/newfile.txt");
		 System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

         //Create directory
         File destDir = new File("resources");
         //Copy file to directory
         FileUtils.copyFileToDirectory(file, destDir);

         //Get file from new directory
         File newFile = FileUtils.getFile(destDir, "newfile.txt");
         //Read data from file
         String newFileData = FileUtils.readFileToString(newFile, "UTF8");
         //Print it
         System.out.println("Data in new file: " + newFileData);
     } 
	 catch(IOException errMessage) {
         System.out.println(errMessage);
     }
 }
}