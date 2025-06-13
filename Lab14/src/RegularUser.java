public class RegularUser extends User {
    public RegularUser(String username, String pin) {
        super(username, pin, false);
    }


    public RegularUser(int id, String username, String pinHash, double balance) {
        super(id, username, pinHash, balance, false);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);

            System.out.println("Wpłacono " + amount + " zł. Bieżące saldo: " + getBalance() + " zł.");
        } else {
            System.out.println("Kwota wpłaty musi być dodatnia.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);

                System.out.println("Wypłacono " + amount + " zł. Bieżące saldo: " + getBalance() + " zł.");
            } else {
                System.out.println("Brak wystarczających środków na koncie.");
            }
        } else {
            System.out.println("Kwota wypłaty musi być dodatnia.");
        }
    }

    public void displayBalance() {
        System.out.println("Twoje bieżące saldo: " + getBalance() + " zł.");
    }
}