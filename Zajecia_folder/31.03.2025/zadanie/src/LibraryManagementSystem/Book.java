package LibraryManagementSystem;

public class Book {
    // Fields for title, author, and ISBN
    private String title;
    private String author;
    private String isbn;


    public Book(String title, String author, String isbn) throws InvalidBookException {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) throws InvalidBookException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidBookException("Title cannot be null or empty.");
        }
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) throws InvalidBookException {
        if (author == null || author.trim().isEmpty()) {
            throw new InvalidBookException("Author cannot be null or empty.");
        }
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) throws InvalidBookException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new InvalidBookException("ISBN cannot be null or empty.");
        }
        if (!isbn.matches("\\d{13}")) {
            throw new InvalidBookException("ISBN must be a 13-digit number.");
        }
        this.isbn = isbn;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    // Custom exception for invalid book information
    public static class InvalidBookException extends Exception {
        public InvalidBookException(String message) {
            super(message);
        }
    }
}
