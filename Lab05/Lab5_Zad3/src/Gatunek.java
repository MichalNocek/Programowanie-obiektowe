class Gatunek {
    private String rodzaj;
    private String nazwaGatunkowa;
    private int chromosomy2n;
    private int chromosomyX;
    private String opis;

    public Gatunek(String rodzaj, String nazwaGatunkowa, int chromosomy2n, int chromosomyX, String opis) {
        this.rodzaj = rodzaj;
        this.nazwaGatunkowa = nazwaGatunkowa;
        this.chromosomy2n = chromosomy2n;
        this.chromosomyX = chromosomyX;
        this.opis = opis;
    }

    // Metoda zwracająca pełną nazwę
    public String getPelnaNazwa() {
        return rodzaj + " " + nazwaGatunkowa;
    }

    // Metoda zwracająca haploidalną liczbę chromosomów (n)
    public int getHaploidalnaLiczbaChromosomow() {
        return chromosomy2n / 2;
    }

    // Metoda wypisująca wszystkie dane
    public void wypiszDane() {
        System.out.println("Pełna nazwa: " + getPelnaNazwa());
        System.out.println("Liczba chromosomów 2n: " + chromosomy2n);
        System.out.println("Podstawowa liczba chromosomów x: " + chromosomyX);
        System.out.println("Haploidalna liczba chromosomów n: " + getHaploidalnaLiczbaChromosomow());
        System.out.println("Opis: " + opis);
    }

    // Metoda klonująca obiekt
    public Gatunek klonuj() {
        return new Gatunek(rodzaj, nazwaGatunkowa, chromosomy2n, chromosomyX, opis);
    }
}