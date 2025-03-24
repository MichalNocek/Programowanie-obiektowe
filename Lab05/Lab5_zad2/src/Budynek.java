import java.time.LocalDate;
import java.time.Period;

public class Budynek {

    public String nazwa;
    public LocalDate dataBudowy;  // Teraz przechowujemy pełną datę
    public int liczbaPieter;


    public Budynek(String nazwa, LocalDate dataBudowy, int liczbaPieter) {
        this.nazwa = nazwa;
        this.dataBudowy = dataBudowy;
        this.liczbaPieter = liczbaPieter;
    }


    public Budynek(String nazwa, int rok, int miesiac, int dzien, int liczbaPieter) {
        this(nazwa, LocalDate.of(rok, miesiac, dzien), liczbaPieter);
    }


    public void wyswietlInformacje() {
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Data budowy: " + dataBudowy);
        System.out.println("Liczba pięter: " + liczbaPieter);
        System.out.println("Wiek budynku: " + obliczWiek() + " lat");
        System.out.println("------------------------");
    }


    public int obliczWiek() {
        return Period.between(dataBudowy, LocalDate.now()).getYears();
    }
}