package service;

import model.Book;
import model.Borrower;

import java.util.ArrayList;
import java.util.List;

// Service class containing all library management operations
public class LibraryService {
    private List<Book> books = new ArrayList<>();       // List to store books
    private List<Borrower> borrowers = new ArrayList<>(); // List to store borrowers

    // Adds a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Updates an existing book's details by ISBN
    public void updateBook(String isbn, String title, String author, int quantity) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setQuantity(quantity);
                System.out.println("Book updated: " + book);
                return;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
    }

    // Removes a book from the library by ISBN
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book removed with ISBN: " + isbn);
    }

    // Adds a new borrower to the library system
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println("Borrower added: " + borrower);
    }

    // Updates an existing borrower's contact details by membership ID
    public void updateBorrower(String membershipId, String contact) {
        for (Borrower borrower : borrowers) {
            if (borrower.getMembershipId().equals(membershipId)) {
                borrower.setContact(contact);
                System.out.println("Borrower updated: " + borrower);
                return;
            }
        }
        System.out.println("Borrower not found with Membership ID: " + membershipId);
    }

    // Removes a borrower from the system by membership ID
    public void removeBorrower(String membershipId) {
        borrowers.removeIf(borrower -> borrower.getMembershipId().equals(membershipId));
        System.out.println("Borrower removed with Membership ID: " + membershipId);
    }

    // Searches for books by keyword in title, author, or genre
    public void searchBooks(String keyword) {
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getGenre().contains(keyword)) {
                System.out.println(book);
            }
        }
    }

    // Handles the borrowing of a book by ISBN and borrower's membership ID
    public void borrowBook(String isbn, String membershipId) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
                System.out.println("Book borrowed: " + book);
                return;
            }
        }
        System.out.println("Book not available or not found.");
    }

    // Handles the return of a book by ISBN
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setQuantity(book.getQuantity() + 1);
                System.out.println("Book returned: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
