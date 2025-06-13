public enum Swiatlo {
    CZERWONE("Stój!"),
    ZOLTE("Uwaga!"),
    ZIELONE("Jedź!");

    private final String komunikat;

    Swiatlo(String komunikat) {
        this.komunikat = komunikat;
    }

    public String getKomunikat() {
        return komunikat;
    }

    public static void main(String[] args) {
        // Przykład użycia
        Swiatlo aktualneSwiatlo = Swiatlo.CZERWONE;
        System.out.println("Aktualne światło: " + aktualneSwiatlo + " -> " + aktualneSwiatlo.getKomunikat());

        aktualneSwiatlo = Swiatlo.ZOLTE;
        System.out.println("Aktualne światło: " + aktualneSwiatlo + " -> " + aktualneSwiatlo.getKomunikat());

        aktualneSwiatlo = Swiatlo.ZIELONE;
        System.out.println("Aktualne światło: " + aktualneSwiatlo + " -> " + aktualneSwiatlo.getKomunikat());
    }
}