import FiguryGeometryczne.*;

import java.util.Scanner;

public class Run {

    Scanner scanner = new Scanner(System.in);

    public void Run(){

        System.out.println("wybierz figure która chcesz obliczyć");
        System.out.println("1.kolo\n2.kula\n3.kwadrat\n4.prostokat\n5.prostopadloscian\n6.stozek\n6.szescian\n7.trójkąt");

        switch(scanner.nextInt()){
            case 1:
                kolo();
                break;
            case 2:
                kula();
                break;
            case 3:
                kwadrat();//??
                break;
            case 4:
                prostokat();//?
                break;
            case 5:
                prostopadloscian();
                break;
            case 6:
                stozek();
                break;
            case 7:
                trojkat();
                break;
            default:
                System.out.println("nie ma takiej figury");

        }

    }

    private void trojkat() {
        System.out.println("Podaj bok A B C i wysokość trójkąta: ");
        Trojkat trojkat = new Trojkat(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Pole wynosi"+ trojkat.pole());
    }

    private void stozek() {
        System.out.println("Podaj promień podstawy i wysokosc");
        Stozek stozek = new Stozek(scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Objetosc wynosi: "+stozek.obliczObjetosc());
    }

    private void prostopadloscian() {
        System.out.println("Podaj bok A B C prostopadłoscianu");
        Prostopadloscian prostopadloscian = new Prostopadloscian(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Objętośc wynosi: " + prostopadloscian.obliczObjetosc());
        System.out.println("Pole powierzchni wynosi "+prostopadloscian.obliczPolePowierzchni());
        System.out.println("Przekątna wynosi "+ prostopadloscian.obliczPolePowierzchni());





    }

    private void prostokat() {

        System.out.println("Podaj bo a i b prostokata");
        Prosotat prosotat = new Prosotat(scanner.nextInt(),scanner.nextInt());
        System.out.println("Pole prostokąta wynosi"+ prosotat.pole());
    }

    private void kwadrat() {
        System.out.println("Podaj bok a i bok b kwadratu ");
        Kwadrat kwadrat = new Kwadrat(scanner.nextInt(), scanner.nextInt());
        System.out.println("Obwod wynosi"+kwadrat.obwod());
        System.out.println("Pole wynosi"+kwadrat.pole());;
    }

    private void kula() {
        System.out.println("Podaj promień:");
        Kula kula = new Kula();
        kula.setPromien(scanner.nextDouble());
        System.out.println("Srednica wynosi"+ kula.srednica());
        System.out.println("Objetosc wynosi"+ kula.objetosc());
        System.out.println("Powierzchnia wynosi"+ kula.powierzchnia());

    }

    private void kolo() {
        System.out.println("Podaj srednice ");
        Circle circle = new Circle();
        circle.setSrednica(scanner.nextInt());
        System.out.println("Srednica wynosi "+circle.getSrednica()+" Obwod wynosi: "+Math.round(circle.obwodkola()));


    }


}
