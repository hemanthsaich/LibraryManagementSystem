package main;

import model.Book;
import model.Borrower;
import service.LibraryService;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Borrower");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Update Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Remove Borrower");
            System.out.println("9. Exit");
            
            System.out.print("Enter Your response: ");
            String choiceStr = scanner.nextLine(); // Read input as String
            int choice;

            try {
                choice = Integer.parseInt(choiceStr); // Convert to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                continue; // Retry
            }

            switch (choice) {
                case 1: // Add Book
                    System.out.println("How many books do you want to add?");
                    int bookCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 1; i <= bookCount; i++) {
                        System.out.println("Enter details for Book " + i + " (Title, Author, ISBN, Genre, Quantity):");
                        String title = scanner.nextLine();
                        String author = scanner.nextLine();
                        String isbn = scanner.nextLine();
                        String genre = scanner.nextLine();
                        int quantity = Integer.parseInt(scanner.nextLine());
                        libraryService.addBook(new Book(title, author, isbn, genre, quantity));
                    }
                    break;

                case 2: // Add Borrower
                    System.out.println("How many borrowers do you want to add?");
                    int borrowerCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 1; i <= borrowerCount; i++) {
                        System.out.println("Enter details for Borrower " + i + " (Name, Contact, Membership ID):");
                        String name = scanner.nextLine();
                        String contact = scanner.nextLine();
                        String membershipId = scanner.nextLine();
                        libraryService.addBorrower(new Borrower(name, contact, membershipId));
                    }
                    break;

                case 3: // Borrow Book
                    System.out.println("How many books do you want to borrow?");
                    int borrowCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 1; i <= borrowCount; i++) {
                        System.out.println("Enter ISBN of the book to borrow:");
                        String borrowIsbn = scanner.nextLine();
                        System.out.println("Enter Membership ID of the borrower:");
                        String borrowerId = scanner.nextLine();
                        libraryService.borrowBook(borrowIsbn, borrowerId);
                    }
                    break;

                case 4: // Return Book
                    System.out.println("How many books do you want to return?");
                    int returnCount = Integer.parseInt(scanner.nextLine());
                    for (int i = 1; i <= returnCount; i++) {
                        System.out.println("Enter ISBN of the book to return:");
                        String returnIsbn = scanner.nextLine();
                        libraryService.returnBook(returnIsbn);
                    }
                    break;

                case 5: // Search Books
                    System.out.println("Enter a keyword to search books (Title, Author, or Genre):");
                    String keyword = scanner.nextLine();
                    libraryService.searchBooks(keyword);
                    break;

                case 6: // Update Book
                    System.out.println("Enter ISBN of the book to update:");
                    String updateIsbn = scanner.nextLine();
                    System.out.println("Enter new details (Title, Author, Quantity):");
                    String newTitle = scanner.nextLine();
                    String newAuthor = scanner.nextLine();
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    libraryService.updateBook(updateIsbn, newTitle, newAuthor, newQuantity);
                    break;

                case 7: // Remove Book
                    System.out.println("Enter ISBN of the book to remove:");
                    String removeIsbn = scanner.nextLine();
                    libraryService.removeBook(removeIsbn);
                    break;

                case 8: // Remove Borrower
                    System.out.println("Enter Membership ID of the borrower to remove:");
                    String removeMembershipId = scanner.nextLine();
                    libraryService.removeBorrower(removeMembershipId);
                    break;

                case 9: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
