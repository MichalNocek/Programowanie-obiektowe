import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    private Map<String, String> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void addUser(String login, String password) {
        users.put(login, password);
        System.out.println("Dodano użytkownika: " + login);
    }

    public boolean login(String login, String password) {
        if (users.containsKey(login)) {
            if (users.get(login).equals(password)) {
                System.out.println("Zalogowano pomyślnie!");
                return true;
            } else {
                System.out.println("Błędne hasło.");
                return false;
            }
        } else {
            System.out.println("Użytkownik nie istnieje.");
            return false;
        }
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        // Przykład działania
        userManager.addUser("admin", "1234");

        System.out.println("Podaj login do logowania:");
        String loginInput = scanner.nextLine();
        System.out.println("Podaj hasło do logowania:");
        String passwordInput = scanner.nextLine();

        userManager.login(loginInput, passwordInput);

        scanner.close();
    }
}