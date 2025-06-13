import java.util.ArrayList; // Nadal używamy do tymczasowej listy transakcji, które można potem pobrać z bazy
import java.util.List;

public class User {
    protected int id; // ID z bazy danych
    protected String username;
    protected String pinHash;
    protected double balance;
    protected boolean isAdmin;
    protected List<String> transactionHistory; // Tutaj będziemy tymczasowo przechowywać transakcje pobrane z DB

    // Konstruktor do tworzenia nowego użytkownika (przed zapisem do DB)
    public User(String username, String pin, boolean isAdmin) {
        this.username = username;
        this.pinHash = hashPin(pin);
        this.balance = 0.0;
        this.isAdmin = isAdmin;
        this.transactionHistory = new ArrayList<>();
    }

    // Konstruktor do wczytywania użytkownika z bazy danych
    public User(int id, String username, String pinHash, double balance, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.pinHash = pinHash; // PIN jest już zahaszowany, więc przyjmujemy go bezpośrednio
        this.balance = balance;
        this.isAdmin = isAdmin;
        this.transactionHistory = new ArrayList<>();
    }

    private String hashPin(String pin) {
        return "hashed_" + pin; // Nadal "proste" hashowanie
    }

    public boolean checkPin(String pin) {
        return this.pinHash.equals(hashPin(pin));
    }

    public int getId() {
        return id;
    }

    // Setter dla ID (przydatny po wstawieniu do DB, gdy DB generuje ID)
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPinHash() {
        return pinHash;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updatePin(String newPin) {
        this.pinHash = hashPin(newPin);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void addTransaction(String transaction) {
        this.transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}