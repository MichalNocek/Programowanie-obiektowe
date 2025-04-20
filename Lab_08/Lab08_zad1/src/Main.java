import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę, którą chcesz spierwiastkować:");
        try {
            double liczba = scanner.nextDouble();
            if (liczba <= 0) {
                throw new IllegalArgumentException("Liczba musi być większa od zera.");
            }
            System.out.println("Pierwiastek z " + liczba + " to: " + Math.sqrt(liczba));
        } catch (InputMismatchException e) {
            System.out.println("Błąd: Wprowadź poprawną liczbę (np. 4.5).");
        }
    }
}
