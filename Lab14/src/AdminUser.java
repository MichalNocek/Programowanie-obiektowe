public class AdminUser extends User {
    public AdminUser(String username, String pin) {
        super(username, pin, true);
    }

    public AdminUser(int id, String username, String pinHash, double balance) {
        super(id, username, pinHash, balance, true);
    }
}