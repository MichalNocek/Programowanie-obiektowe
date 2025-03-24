import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Budynek budynek1 = new Budynek("Biurowiec Omega",
                LocalDate.of(2010, 5, 15), 15);

        Budynek budynek2 = new Budynek("Galeri Handlowa Centrum",
                LocalDate.of(1995, 10, 1), 3);


        Budynek budynek3 = new Budynek("Apartamentowiec Marina",
                2020, 3, 20, 10);


        budynek1.wyswietlInformacje();
        budynek2.wyswietlInformacje();
        budynek3.wyswietlInformacje();



    }
}