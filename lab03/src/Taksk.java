import static java.lang.Math.round;

public class Taksk {

    public static void  zad1(){

        Input input = new Input();
        int punkty=0;
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
        suma= round(suma);
        System.out.println(srednia);


    }

    public void






}
