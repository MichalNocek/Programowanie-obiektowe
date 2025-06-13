import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Podaj liczbę N (np. 5): ");
            try {
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Proszę podać liczbę nieujemną.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Błędne dane. Proszę podać liczbę całkowitą.");
                scanner.next();
            }
        }

        System.out.println("\nTworzenie i uruchamianie wątków dla N = " + n);


        SumThread sumThread = new SumThread(n);
        FactorialThread factorialThread = new FactorialThread(n);

        // Uruchomienie wątków
        sumThread.start();
        factorialThread.start();

        System.out.println("Wątek główny czeka na zakończenie wątków SumThread i FactorialThread...");

        try {
            // Czekanie na zakończenie obu wątków za pomocą metody join()
            sumThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            System.err.println("Wątek główny został przerwany podczas czekania na wątki potomne: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        System.out.println("\nWszystkie wątki zakończyły swoje działanie.");
        System.out.println("Ostateczne wyniki:");
        System.out.println("Suma od 1 do " + n + ": " + sumThread.getSum());
        System.out.println("Silnia z " + n + " (N!): " + factorialThread.getFactorial());

        scanner.close();
    }
}