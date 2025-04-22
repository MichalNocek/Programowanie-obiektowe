import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Uczestnik> uczestnicy = new ArrayList<>();

        uczestnicy.add(new Uczestnik(1, "Jan", 17));
        uczestnicy.add(new Uczestnik(2, "Anna", 20));
        uczestnicy.add(new Uczestnik(3, "Ola", 15));

        System.out.println("Wszyscy uczestnicy:");
        for (Uczestnik u : uczestnicy) {
            System.out.println(u);
        }

        System.out.println("\nPełnoletni uczestnicy:");

        for (Uczestnik u : uczestnicy) {
            if (u.getWiek()>=18){
                System.out.println(u.toString());
            }
        }


















    }
}