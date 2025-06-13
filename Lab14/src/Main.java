public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        ConsoleUI ui = new ConsoleUI(bankSystem);
        ui.start();
    }
}