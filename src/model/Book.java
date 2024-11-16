package model;

// Represents a book in the library system
public class Book {
    private String title;      // Title of the book
    private String author;     // Author of the book
    private String isbn;       // Unique ISBN for the book
    private String genre;      // Genre of the book
    private int quantity;      // Number of copies available

    // Constructor to initialize a book
    public Book(String title, String author, String isbn, String genre, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.quantity = quantity;
    }

    // Getters and setters for book attributes
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Override toString to display book details
    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + isbn +
               ", Genre=" + genre + ", Quantity=" + quantity + "]";
    }
}
