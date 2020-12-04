package mainphase;

import initialmodel.phase01;
import java.io.*;
import java.util.*;

public class MainPhase {
	public interface fileinterferance {
		public void showAllFiles();
		public void addFile();
		public void deleteFile();
		abstract void searchFile();
	}

	public static void main(String[] args) {
		DisplayScreen();
		try {
			MenuOptions();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void DisplayScreen() {
		
		System.out.println("Welcome to the Screen");
		System.out.println("Phase-01 Project: LockedMe App");
		System.out.println("The project is developed by Harshad Kalantri");
	}
	
	public static void MenuOptions() throws FileNotFoundException {
		Scanner sc =new Scanner(System.in);
		phase01 obj = new phase01();
		int choose;
		do {
			System.out.println("Please select the Preferred Options: \n");
			System.out.println("\t1. Listing File names in Ascending Order \n");
			System.out.println("\t2. File Utilities \n");
			System.out.println("\t3. Terminate the Application \n");
			
			choose=sc.nextInt();
			switch(choose) {
			case 1:
				obj.showAllFiles();
				break;
			case 2 :
				int ch;
			do {
				System.out.println("Enter the File Choice");
				System.out.println("\t1. Add a File");
				System.out.println("\t2. Delete a File");
				System.out.println("\t3. Searching a File");
				System.out.println("\t4. Exit from App");
				ch=sc.nextInt();
			
				switch(ch) {
				case 1:
					obj.addFile();
					break;
				case 2:
					obj.deleteFile();
					break;
				case 3:
					obj.searchFile();
					break;
				case 4:
					System.out.println("Menu Exit");
					System.out.println("The end\n");
					break;
				default:
					System.out.println("Error");
					break;
				}
			}while(ch!=4);
			break;
			case 3:
				System.out.println("Closing the application...");
				break;
			default:
				System.out.println("Error");
			}
			
			}while(choose!=3);
			
		}

	}
