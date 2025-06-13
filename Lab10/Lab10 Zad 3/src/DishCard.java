import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DishCard {

    private Map<String, Double> menu;

    public DishCard() {
        this.menu = new HashMap<>();
    }

    public void addDish(String name, double price) {
        menu.put(name, price);
        System.out.println("Dodano: " + name + " - " + String.format("%.2f", price) + " zł");
    }

    public void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("Karta dań jest pusta.");
            return;
        }
        System.out.println("--- Karta Dań ---");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.format("%.2f", entry.getValue()) + " zł");
        }
        System.out.println("-----------------");
    }

    public void removeDish(String name) {
        if (menu.containsKey(name)) {
            menu.remove(name);
            System.out.println("Usunięto: " + name);
        } else {
            System.out.println("Danie '" + name + "' nie istnieje w karcie.");
        }
    }

    public double calculateBill(List<String> orderedDishes) {
        double total = 0.0;
        List<String> foundDishes = new ArrayList<>();
        List<String> notFoundDishes = new ArrayList<>();

        for (String dishName : orderedDishes) {
            if (menu.containsKey(dishName)) {
                total += menu.get(dishName);
                foundDishes.add(dishName);
            } else {
                notFoundDishes.add(dishName);
            }
        }

        System.out.print("Rachunek za [");
        for (int i = 0; i < foundDishes.size(); i++) {
            System.out.print(foundDishes.get(i));
            if (i < foundDishes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]: " + String.format("%.2f", total) + " zł");
        System.out.println();

        if (!notFoundDishes.isEmpty()) {
            System.out.println("Uwaga: Następujące dania nie zostały znalezione w menu i nie zostały doliczone do rachunku: " + notFoundDishes);
        }
        return total;
    }

    public static void main(String[] args) {
        DishCard card = new DishCard();
        Scanner scanner = new Scanner(System.in);

        // Przykład działania
        card.addDish("Pizza Margherita", 25.00);
        card.addDish("Zupa pomidorowa", 12.00);
        card.addDish("Kawa", 8.50);

        System.out.println("\nPo dodaniu kilku dań:");
        card.displayMenu();

        card.removeDish("Kawa");
        System.out.println("\nPo usunięciu kawy:");
        card.displayMenu();

        System.out.println("\nObliczanie rachunku:");
        List<String> order1 = new ArrayList<>();
        order1.add("Pizza Margherita");
        order1.add("Zupa pomidorowa");
        card.calculateBill(order1);

        List<String> order2 = new ArrayList<>();
        order2.add("Pizza Margherita");
        order2.add("Makaron Carbonara"); // Danie spoza menu
        card.calculateBill(order2);

        scanner.close();
    }
}