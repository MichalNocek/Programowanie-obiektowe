import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
    private BankSystem bankSystem;
    private Scanner scanner;

    public ConsoleUI(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            if (bankSystem.getLoggedInUser() == null) {
                showLoginMenu();
            } else {
                if (bankSystem.getLoggedInUser().isAdmin()) {
                    showAdminMenu();
                } else {
                    showUserMenu();
                }
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n--- Ekran logowania ---");
        System.out.print("Login: ");
        String username = scanner.nextLine();
        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        bankSystem.authenticate(username, pin);
    }

    private void showAdminMenu() {
        System.out.println("\n--- Menu Administratora ---");
        System.out.println("1. Zarejestruj nowego użytkownika");
        System.out.println("2. Wyświetl listę użytkowników");
        System.out.println("3. Wyloguj");
        System.out.print("Wybierz opcję: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                registerNewUserAdmin();
                break;
            case "2":
                bankSystem.listAllUsers();
                break;
            case "3":
                bankSystem.logout();
                break;
            default:
                System.out.println("Niepoprawna opcja.");
        }
    }

    private void registerNewUserAdmin() {
        System.out.print("Podaj login nowego użytkownika: ");
        String newUsername = scanner.nextLine();
        System.out.print("Podaj PIN nowego użytkownika: ");
        String newPin = scanner.nextLine();
        System.out.print("Czy to ma być Administrator? (tak/nie): ");
        String adminChoice = scanner.nextLine().toLowerCase();
        boolean isAdmin = adminChoice.equals("tak");

        bankSystem.registerNewUser(newUsername, newPin, isAdmin);
    }


    private void showUserMenu() {
        RegularUser currentUser = (RegularUser) bankSystem.getLoggedInUser();
        System.out.println("\n--- Menu Użytkownika (" + currentUser.getUsername() + ") ---");
        System.out.println("1. Wpłać pieniądze");
        System.out.println("2. Wypłać pieniądze");
        System.out.println("3. Sprawdź saldo");
        System.out.println("4. Zmień PIN");
        System.out.println("5. Historia transakcji");
        System.out.println("6. Wyloguj");
        System.out.print("Wybierz opcję: ");

        String choice = scanner.nextLine();
        double amount;
        switch (choice) {
            case "1":
                System.out.print("Podaj kwotę do wpłaty: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                    bankSystem.performDeposit(currentUser, amount);
                } catch (NumberFormatException e) {
                    System.out.println("Niepoprawna kwota.");
                }
                break;
            case "2":
                System.out.print("Podaj kwotę do wypłaty: ");
                try {
                    amount = Double.parseDouble(scanner.nextLine());
                    bankSystem.performWithdraw(currentUser, amount);
                } catch (NumberFormatException e) {
                    System.out.println("Niepoprawna kwota.");
                }
                break;
            case "3":
                currentUser.displayBalance();
                bankSystem.recordBalanceCheck(currentUser);
                break;
            case "4":
                System.out.print("Podaj nowy PIN: ");
                String newPin = scanner.nextLine();
                bankSystem.performPinChange(currentUser, newPin);
                System.out.println("PIN został zmieniony.");
                break;
            case "5":
                System.out.println("\n--- Twoja historia transakcji ---");

                List<String> history = bankSystem.userDAO.getTransactionHistory(currentUser.getId());
                if (history.isEmpty()) {
                    System.out.println("Brak transakcji.");
                } else {
                    for (String transaction : history) {
                        System.out.println("- " + transaction);
                    }
                }
                break;
            case "6":
                bankSystem.logout();
                break;
            default:
                System.out.println("Niepoprawna opcja.");
        }
    }
}