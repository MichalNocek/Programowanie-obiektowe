package LibraryManagementSystem;
public interface BookInput {
    // Metoda do pobierania danych książki od użytkownika
    Book readBook() throws InvalidBookException;
}
