package WypPojazdow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Run {
    static Scanner scanner = new Scanner(System.in);
    public static void RunMain(){
        List<Pojazd> pojazdy = new ArrayList<>();
        pojazdy.add(new Samochod("s1","toyota"));
        pojazdy.add(new SamochodElektryczny("SE001","Kia"));
        pojazdy.add(new RowerElektryczny("RE001","Romet"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*************MENU**************");
        System.out.println("1.wyświetl dostępne pojazdy");
        System.out.println("2.Wypozdycz pojazd");
        System.out.println("3.Zwroc pojazd");
        System.out.println("Naladuj pojazd elektryczny");
        System.out.println("5.Wyjscie");
        System.out.println("Twój wybór: ");
        int wybor = scanner.nextInt();

        switch (wybor){
            case 1: vievPojazdy(pojazdy);
            case 2: wypozyczPojazd(pojazdy);
            case 3: zwrocPojazd();
            case 4: naladujPojazd();

        }




    }

    private static void naladujPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj ID pojazdu do naładowania");
        String idLaduj = scanner.nextLine();
        for(Pojazd p : pojazdy){
            if(p.getID().equals(idLaduj) && p instanceof Elektryczny){

            }
        }
    }

    private static void zwrocPojazd() {
        System.out.println("Podaj ID pojazdu do zwrócenia");



    }

    private static void wypozyczPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj ID pojazdu do wypozyczenia: ");
        String idWyp = scanner.nextLine();

        for(Pojazd p : pojazdy){
            if (p.getId().equals(idWyp)&&p.isCzyDostepny()){
                System.out.println("Na ile godzin chcesz wypozyczyc");
                int godzina = scanner.nextInt();
                p.wypozycz();
                System.out.println("Koszt wypozyczenia "+p.obliczkoszt(godzina) + " zł");

            }
        }

    }

    private static void vievPojazdy(List<Pojazd> pojazdy) {
        for (Pojazd p : pojazdy){
            System.out.println(p.getId() + " "+p.getModel()+ " - "+(p.isCzyDostepny() ? "Dostepny":"Niedostepny") );
        }
    }
}
