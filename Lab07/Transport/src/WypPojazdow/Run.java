package WypPojazdow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    static Scanner scanner = new Scanner(System.in);
    public static void RunMain(){
        boolean wyjscie = true;
        List<Pojazd> pojazdy = new ArrayList<>();
        pojazdy.add(new Samochod("s1","toyota"));
        pojazdy.add(new SamochodElektryczny("SE001","Kia"));
        pojazdy.add(new RowerElektryczny("RE001","Romet"));

        Scanner scanner = new Scanner(System.in);
        while(wyjscie){


        System.out.println("\n*************MENU**************");
        System.out.println("1.wyświetl dostępne pojazdy");
        System.out.println("2.Wypozdycz pojazd");
        System.out.println("3.Zwroc pojazd");
        System.out.println("4.Dodja pojazd");
        System.out.println("5.Wyjscie");
        System.out.println("Twój wybór: ");
        int wybor = scanner.nextInt();

        switch (wybor){
            case 1: vievPojazdy(pojazdy);
            break;
            case 2: wypozyczPojazd(pojazdy);
            break;
            case 3: zwrocPojazd(pojazdy);
            break;
            case 4: dodajPojazd(pojazdy);
            break;
            case 5: wyjscie = false;
        }
    }



    }

     private static void dodajPojazd(List<Pojazd> pojazdy){
         System.out.println("Jaki chcesz pojazd dodać?\n 1 - Rower elektryczny 2-Samochod 3-SamochodElektryczny");
         int wybor = scanner.nextInt();
         scanner.nextLine();
         System.out.println("Podaj ID");
         String id = scanner.nextLine();
         System.out.println("Podaj marke");
         String marka = scanner.nextLine();

         switch (wybor){
             case 1:  pojazdy.add(new RowerElektryczny(id,marka));
             break;
             case 2: pojazdy.add(new Samochod(id,marka));
             break;
             case 3:  pojazdy.add(new SamochodElektryczny(id,marka));
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

    private static void zwrocPojazd(List<Pojazd> pojazdy) {
        System.out.println("Podaj ID pojazdu do zwrócenia");
        String idWyp = scanner.nextLine();
        for(Pojazd p : pojazdy){
            if (p.getId().equals(idWyp)&& !p.isCzyDostepny()){
                p.zwroc();

            }
        }

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
