package LibraryManagementSystem;
import java.util.Scanner;
import java.util.SortedMap;

public class ConsoleBookInput implements BookInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Book readBook() throws InvalidBookException {
        // Wczytywanie danych z konsoli i tworzenie obiektu Book
        System.out.println("Podaj tytuł ksiązki");
        String title = scanner.nextLine();

        return null;
    }
}
