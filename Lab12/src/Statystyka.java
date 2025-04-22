import java.awt.*;
import java.util.List;

public class Statystyka {


    public void statystyka(List<Data> data) {

        System.out.println("Między 1950-1980 rokiem urodziło się: ");
        int sumaone  = 0;
        int sumatwo  = 0;
        int sumatthree = 0;
        int countone = 0;
        int counttwo = 0;
        int countthree = 0;
        for (Data d : data) {
            if(d.rok>=1950 && d.rok<=1980) {
                countone++;
                sumaone += d.rok;
            }
            else if(d.rok>1980 && d.rok<=2000) {
                counttwo++;
                sumatwo += d.rok;
            }
            else if(d.rok>2000 && d.rok<=2025) {
                countthree++;
                sumatthree += d.rok;
            }
        }

        System.out.println(countone);
        System.out.println("Średni wiek wynosi: " + (2025-(sumaone/countone)));
        System.out.println("Między 1981 - 2000 jest ");
        System.out.println(counttwo);
        System.out.println("Średni wiek wynosi: " + (2025-sumatwo/counttwo));
        System.out.println("Między 2001 - 2025 jest ");
        System.out.println(countthree);
        System.out.println("Średni wiek wynosi: " + (2025-sumatthree/countthree));

    }


















}
