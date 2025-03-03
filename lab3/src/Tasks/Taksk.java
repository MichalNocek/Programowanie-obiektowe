package Tasks;

import run_input.Input;
import run_input.Random_number;


import static java.lang.Math.round;

public class Taksk {


    Input input = new Input();
    Random_number rand = new Random_number();
    public void zad1(){

        int punkty;
        double suma=0;

        System.out.println("Podaj ilość uczniów!");
        int n = input.InputInt();
        while(n<=0){
            System.out.println("Podałeś złe dane jeszcze raz");
            n=input.InputInt();
        }

        int ilosc_uczoiow=n;
        while(n>0){
            System.out.println("Podaj ilosć pkt od 0 do 10");
            punkty=input.InputInt();
            while(punkty>10||punkty<0){
                System.out.println("Podałeś złą ilość pkt jeszcze raz");
                punkty=input.InputInt();

            }
            suma=suma+punkty;


            n--;
        }
        double srednia = suma/ilosc_uczoiow;
        srednia= round(srednia);
        System.out.println(srednia);

    }

    public void zad2(){

        int dodatnie=0;
        int ujemne=0;
        int sumadodatnie=0;
        int sumaujemne=0;



        for(int i=1;i<=10;i++){
            System.out.println("Podaj "+i+" liczbe");
            int liczba=input.InputInt();

            if(liczba>0){
                sumadodatnie=sumadodatnie+liczba;
                dodatnie++;
            }else if(liczba<0){
                sumaujemne=sumaujemne+liczba;
                ujemne++;
            }


        }
        System.out.println("Suma liczb dodatnich wynosi: "+sumadodatnie);
        System.out.printf("Liczb dodatnich jest: "+dodatnie);
        System.out.println("Suma liczb ujemny: "+sumaujemne);
        System.out.printf("Liczb ujemny jest: "+ujemne);

    }

    public void zad3() {
        long suma = 0;
        System.out.println("Podaj ilość liczb ciągu : ");
        int n = input.InputInt();
        int liczba;

        for (int i = 1; i <= n; i++) {
            System.out.println("Podaj " + i + " liczbe");
            liczba = input.InputInt();
            if (liczba % 2 == 0) suma = suma + liczba;
        }
        System.out.println("Suma liczb dodatnich ciągu wynosi " + suma);
    }

    public void zad4() {
        System.out.println("Podaj n liczb");
        int suma = 0;
        int n = input.InputInt();
        int liczba= rand.random_int(-10,45);
        for (int i = 1; i <= n; i++) {
            System.out.println("Liczba losowa wynosi " + liczba);
            liczba= rand.random_int(-10,45);
            if (liczba % 2 == 0) suma = suma + liczba;
        }
        System.out.println("suma dodatnich liczb wynosi  " + suma);

    }

    public void zad5() {

        System.out.println("Podaj wyraz do sprawdzenia czy jest palindromem:");
        String word = input.Inputstring();

        word = word.toLowerCase();
        boolean sprawdzenie = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                sprawdzenie = false;
                break;
            }
        }
        if (sprawdzenie) {
            System.out.println("Podane słowo jest palindromem!");
        } else {
            System.out.println("Podane słowo NIE jest palindromem.");
        }


    }

}
