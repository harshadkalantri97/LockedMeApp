package initialmodel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import mainphase.MainPhase.fileinterferance;

public class phase01 implements fileinterferance{ 
	List<String> retrieve= new ArrayList<String>();
	File[] bnk = new File("C:\\Users\\USER\\eclipse-workspace\\lockedmeproject").listFiles();
	@Override
	public void showAllFiles() {
		Arrays.sort(bnk, (f1, f2) -> {
	         if (f1.isDirectory() && !f2.isDirectory()) {
	            return -1;
	         } else if (!f1.isDirectory() && f2.isDirectory()) {
	            return 1;
	         } else {
	            return f1.compareTo(f2);
	         }
	         //Comparing the file types with each other before sorting
	      });
		for(File file : bnk) {
			if(file.isFile()) {
				retrieve.add(file.getName());
				//System.out.println(file.getName());
			}
		}
		retrieve.forEach(System.out::println);
		
	}
@Override
public void addFile() {
	System.out.println("Add your file");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	File K= new File(filename);
	//Creating a new file using create new file method
	try {
		boolean fvar = K.createNewFile();
	     if (fvar){
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("File already present at the specified location");
	     }
   	} catch (IOException e) {
   		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
}

public void deleteFile() {
	System.out.println("Enter the file name you want to delete");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	File K= new File(filename);
	try {
		boolean dvar = K.delete();
		if(dvar) {
			System.out.println("The file is successfully deleted");	
		}else {
		System.out.println("The file is not deleted");
		}
		} catch(Exception e) {
	           System.out.println("Exception occurred");
		e.printStackTrace();
	}
}

@Override
public void searchFile() {
	try {	
		Scanner scan= new Scanner(System.in);
		File directory = new File("C:\\Users\\USER\\eclipse-workspace\\lockedmeproject");
		System.out.println("Enter the file name which you want to search:");
		String Thefile=scan.nextLine();
        File[] files=directory.listFiles();
        int flag=0;
        for (File file : files) {
            String name = file.getName();
            if (name.equals(Thefile)) {
                   System.out.println("The filename "+Thefile+" is present in the directory");
    				File f= new File(Thefile);
    				Scanner sc1 = new Scanner(f);
    				while(sc1.hasNextLine()) {
    				System.out.println(sc1.nextLine());
    				}
    			flag=1;	
            }
		}
    if(flag==0) {
    	System.out.println("File not found");
    }
    	
	}catch(FileNotFoundException ex) {
		System.out.println("file not found");
	}
	
}
}