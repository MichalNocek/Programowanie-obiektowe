public class Main {
    public static void main(String[] args) {
        Gatunek wilk = new Gatunek("Canis", "lupus", 78, 39, "Drapieżnik z rodziny psowatych.");
        wilk.wypiszDane();

        System.out.println("\nKlonowanie obiektu...");
        Gatunek klonWilka = wilk.klonuj();
        klonWilka.wypiszDane();

    }
}