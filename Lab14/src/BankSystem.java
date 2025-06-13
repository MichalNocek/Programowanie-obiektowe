import java.util.List;

public class BankSystem {
    UserDAO userDAO;
    private User loggedInUser;

    public BankSystem() {
        userDAO = new UserDAO();
        if (userDAO.getUserByUsername("admin") == null) {
            User admin = new AdminUser("admin", "1234");
            userDAO.saveUser(admin);
            System.out.println("Dodano domyślnego administratora: admin/1234 do bazy danych.");
        }
    }

    public User authenticate(String username, String pin) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.checkPin(pin)) {
            loggedInUser = user;
            System.out.println("Logowanie udane dla: " + username);
            if (!user.isAdmin()) {
                ((RegularUser) user).addTransaction("Zalogowanie do systemu.");
                List<String> dbHistory = userDAO.getTransactionHistory(user.getId());
                user.getTransactionHistory().clear();
                user.getTransactionHistory().addAll(dbHistory);
            }
            return user;
        }
        System.out.println("Błędny login lub PIN.");
        return null;
    }

    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Wylogowano użytkownika: " + loggedInUser.getUsername());
            loggedInUser = null;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void registerNewUser(String username, String pin, boolean isAdmin) {
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
            System.out.println("Brak uprawnień. Tylko administrator może rejestrować użytkowników.");
            return;
        }

        if (userDAO.getUserByUsername(username) != null) {
            System.out.println("Użytkownik o nazwie '" + username + "' już istnieje.");
            return;
        }

        User newUser;
        if (isAdmin) {
            newUser = new AdminUser(username, pin);
        } else {
            newUser = new RegularUser(username, pin);
        }
        userDAO.saveUser(newUser);
        System.out.println("Zarejestrowano nowego użytkownika: " + username + " (Admin: " + isAdmin + ").");
        if (!isAdmin) {
            userDAO.addTransaction(newUser.getId(), "Konto założone", 0.0);
        }
    }

    public void listAllUsers() {
        if (loggedInUser == null || !loggedInUser.isAdmin()) {
            System.out.println("Brak uprawnień. Tylko administrator może wyświetlać listę użytkowników.");
            return;
        }
        List<User> allUsers = userDAO.getAllUsers();
        System.out.println("\n--- Lista zarejestrowanych użytkowników (z bazy danych) ---");
        if (allUsers.isEmpty()) {
            System.out.println("Brak zarejestrowanych użytkowników.");
            return;
        }
        for (User user : allUsers) {
            System.out.println("- " + user.getUsername() + " (Admin: " + user.isAdmin() + ", Saldo: " + user.getBalance() + " zł)");
        }
    }

    public void performDeposit(RegularUser user, double amount) {
        user.deposit(amount);
        userDAO.saveUser(user);
        userDAO.addTransaction(user.getId(), "Wpłata", amount);
        user.addTransaction("Wpłata: +" + amount + " zł. Nowe saldo: " + user.getBalance() + " zł.");
    }

    public void performWithdraw(RegularUser user, double amount) {
        double oldBalance = user.getBalance();
        user.withdraw(amount);
        if (user.getBalance() != oldBalance) {
            userDAO.saveUser(user);
            userDAO.addTransaction(user.getId(), "Wypłata", -amount);
            user.addTransaction("Wypłata: -" + amount + " zł. Nowe saldo: " + user.getBalance() + " zł.");
        }
    }

    public void performPinChange(RegularUser user, String newPin) {
        user.updatePin(newPin);
        userDAO.saveUser(user);
        userDAO.addTransaction(user.getId(), "Zmiana PIN", 0.0);
        user.addTransaction("PIN zmieniony.");
    }

    public void recordBalanceCheck(RegularUser user) {
        userDAO.addTransaction(user.getId(), "Sprawdzenie salda", 0.0);
        user.addTransaction("Sprawdzono saldo.");
    }
}