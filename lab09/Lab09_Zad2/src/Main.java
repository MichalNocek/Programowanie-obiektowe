import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pary> pary = new ArrayList<Pary>();


        String imie = "";
        String imie2 = "";

        do {
            pary.add(new Pary(imie, imie2));
            System.out.println("Podaj 1 imie");
            imie = scanner.nextLine();
            System.out.println("Podaj 2 imie");
            imie2 = scanner.nextLine();
        } while (!imie.equals("-"));

        System.out.println("Podaj imię a program wypisze partnera");
        imie = scanner.nextLine();
        for (Pary p : pary){
            if(p.imie1.equals(imie)){
                System.out.println(p.imie2);
            } else if (p.imie2.equals(imie)) {
                System.out.println(p.imie1);
            }



        }








    }
}