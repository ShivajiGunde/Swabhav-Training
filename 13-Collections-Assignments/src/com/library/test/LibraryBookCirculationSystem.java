package com.library.test;

import java.util.Scanner;
import com.library.model.AcademicBook;
import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Magazine;


public class LibraryBookCirculationSystem {

	public static void main(String[] args) {

		Library library = new Library();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of books: ");
		int count = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < count; i++) {

			System.out.println("\nEnter details for books " + (i + 1));

			System.out.print("Enter ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter Title: ");
			String title = scanner.nextLine();

			System.out.print("Enter Author: ");
			String author = scanner.nextLine();

			System.out.println("Select Type: 1. AcademicBook  2. Magazine");
			int choice = scanner.nextInt();
			
			scanner.nextLine();

			Book b = null;

			switch (choice) {
			case 1:
				System.out.println("Enter subject");
				String subject = scanner.nextLine();
				
				b = new AcademicBook(id, title, author,subject);
				break;

			case 2:
				System.out.println("enter the issuedNumber");
				int issuedNumber = scanner.nextInt();
				
				scanner.nextLine();
				
				b = new Magazine(id, title, author,issuedNumber);
				break;

			default:
				System.out.println("Invalid choice...");
				continue;
			}

	
			library.addBook(b);
		}

		boolean sortAgain = true;

		while (sortAgain) {
			System.out.println("\nSelect an option:");
			System.out.println("1. sort by Id");
			System.out.println("2. Sort by Title");
			System.out.println("3. Request Book");
			System.out.println("4. Process request");
			System.out.println("5. Remove book");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume leftover newline

			switch (choice) {
			case 1:
				System.out.println("=======ById========");
				for (Book b : library.sortById()) {
					System.out.println(b);
				}
				break;

			case 2:
				System.out.println("=======SortByName========");
				for (Book b : library.sortByTitle()) {
					System.out.println(b);
				}
				break;


			case 3: 
				 System.out.print("Enter Book ID to request: ");
                 int reqId = scanner.nextInt();

                 Book found = null;
                 for (Book b : library.sortById()) {
                     if (b.getId() == reqId) {
                         found = b;
                         break;
                     }
                 }
                 if (found != null) {
                     library.requestBook(found);
                 } else {
                     System.out.println("Book not found.");
                 }
                 break;
			case 4:
				 System.out.println("\nProcessing Requests:");
                 library.processRequests();
                 break;
                 
			case 5:
				System.out.print("Enter Book ID to remove: ");
                int remId = scanner.nextInt();
                library.removeBook(remId);
                break;

				
			case 6:
				sortAgain = false;
				System.out.println("Exiting sorting menu.");
				continue; 

			default:
				System.out.println("Invalid option. Please select 1, 2, or 3");
			}

			// Ask user if they want to sort again
			if (sortAgain) {
				System.out.print("\nDo you want to sort again? (yes/no): ");
				String response = scanner.nextLine().trim().toLowerCase();
				if (!response.equals("yes")) {
					sortAgain = false;
					System.out.println("Exit sorting menu.");
				}
			}
		}

		scanner.close();

	}

}
