import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "your_mysql_password";

    public UserDAO() {
        // Upewnij się, że sterownik JDBC jest załadowany
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Błąd: Nie znaleziono sterownika JDBC MySQL. Upewnij się, że plik JAR jest w CLASSPATH.");
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT id, username, pin_hash, balance, is_admin FROM users WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String dbUsername = rs.getString("username");
                String pinHash = rs.getString("pin_hash");
                double balance = rs.getDouble("balance");
                boolean isAdmin = rs.getBoolean("is_admin");

                if (isAdmin) {
                    return new AdminUser(id, dbUsername, pinHash, balance);
                } else {
                    return new RegularUser(id, dbUsername, pinHash, balance);
                }
            }
        } catch (SQLException e) {
            System.err.println("Błąd pobierania użytkownika z bazy danych: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void saveUser(User user) {
        String sql;
        if (user.getId() == 0) { // Nowy użytkownik (ID nieustawione przez DB)
            sql = "INSERT INTO users (username, pin_hash, balance, is_admin) VALUES (?, ?, ?, ?)";
        } else { // Aktualizacja istniejącego użytkownika
            sql = "UPDATE users SET username = ?, pin_hash = ?, balance = ?, is_admin = ? WHERE id = ?";
        }

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPinHash());
            stmt.setDouble(3, user.getBalance());
            stmt.setBoolean(4, user.isAdmin());

            if (user.getId() != 0) { // Dla aktualizacji
                stmt.setInt(5, user.getId());
            }

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0 && user.getId() == 0) { // Jeśli to nowy użytkownik, pobierz wygenerowane ID
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Błąd zapisu/aktualizacji użytkownika w bazie danych: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, username, pin_hash, balance, is_admin FROM users";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String dbUsername = rs.getString("username");
                String pinHash = rs.getString("pin_hash");
                double balance = rs.getDouble("balance");
                boolean isAdmin = rs.getBoolean("is_admin");

                if (isAdmin) {
                    userList.add(new AdminUser(id, dbUsername, pinHash, balance));
                } else {
                    userList.add(new RegularUser(id, dbUsername, pinHash, balance));
                }
            }
        } catch (SQLException e) {
            System.err.println("Błąd pobierania wszystkich użytkowników z bazy danych: " + e.getMessage());
            e.printStackTrace();
        }
        return userList;
    }


    public void addTransaction(int userId, String type, double amount) {
        String sql = "INSERT INTO transactions (user_id, transaction_type, amount) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, type);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Błąd dodawania transakcji do bazy danych: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<String> getTransactionHistory(int userId) {
        List<String> history = new ArrayList<>();
        String sql = "SELECT transaction_type, amount, transaction_date FROM transactions WHERE user_id = ? ORDER BY transaction_date ASC";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("transaction_type");
                double amount = rs.getDouble("amount");
                Timestamp date = rs.getTimestamp("transaction_date");
                history.add(date.toString() + " - " + type + (amount != 0.0 ? ": " + amount + " zł" : ""));
            }
        } catch (SQLException e) {
            System.err.println("Błąd pobierania historii transakcji: " + e.getMessage());
            e.printStackTrace();
        }
        return history;
    }
}