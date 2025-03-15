package input_random_itp;

import java.util.Arrays;

public class Tasks {
    Input input = new Input();
    Random_number random_number = new Random_number();



    public void task1() {
        float suma=0;
        int[] tab = new int[10];
        //zapisanie tablicy od 1 do 100
        for (int i = 0; i < tab.length; i++) {
            tab[i]=random_number.random_int(0,100);
        }
        //obliczanie sumy i średniej
        for (int j : tab) {
            suma = suma + j;
        }
        System.out.println("Suma: "+(int)suma+"\nSrednia: "+suma/tab.length);
    }
    public void task2() {
        int[] tab_parzysta = new int[10];
        int[] tab_nparzysta = new int[9];

        for (int i = 0; i < tab_parzysta.length; i++) {
            tab_parzysta[i] = random_number.random_int(0,100);
        }
        for (int i = 0; i < tab_nparzysta.length; i++) {
            tab_nparzysta[i] = random_number.random_int(0,100);
        }
        System.out.println("Co druga liczba z tablicy parzystej");
        for (int i = 0; i < tab_parzysta.length; i=i+2) {
            System.out.print(tab_parzysta[i]+" ");
        }
        System.out.println("\nCo druga liczba z tablicy nieparzystej");
        for (int i = 0; i < tab_nparzysta.length; i=i+2) {
            System.out.print(tab_nparzysta[i]+" ");
        }



    }
    public void task3() {
        String[] tab = new String[10];
        for (int i = 0; i < tab.length; i++) {
            tab[i]=input.Inputstring();
        }

        for (String j : tab){
            System.out.print(j.toUpperCase()+" ");

        }

    }
    public void task4() {
        String[] tab = new String[5];
        System.out.println("Podaj 5 słów");
        String j;
        for (int i = 0; i < tab.length; i++) {
            tab[i]=input.Inputstring();
        }
        for (int i = tab.length-1; i >=0; i--) {
            j=tab[i];
            for (int k = j.length()-1; k >=0; k--) {
                System.out.print((j.charAt(k)));
            }
            System.out.print(" ");
        }
    }
    public void task5() {
        int[] tab = new int[8];
        for (int i = 0; i < tab.length; i++) {
            tab[i]=input.InputInt();
        }
        Arrays.sort(tab);
        for(int j :tab){
            System.out.print(j+" ");
        }
    }
    public void task6() {
        int[] tab = new int[5];
        int wynik = 1;
        for (int i = 0; i < tab.length; i++) {
            tab[i]=input.InputInt();
        }
        for (int j : tab) {

            for (int k = j; k >0; k--) {
                wynik=wynik*k;
            }
            System.out.println("Wynik: "+wynik);
            wynik = 0;
        }
    }
    public void task7() {
        String[] tab1 = {"Kacper","Kamil","Miłosz"};
        String[] tab2 = {"Kacper","Kamil","Miłosz"};




    }









}


