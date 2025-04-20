public class Main {
    public static void main(String[] args)
    {
        try {
            Adres adres = new Adres("null", null, -20);
        }
        catch (NieprawidlowyAdresException ex) {
            System.out.println(ex.getMessage());
        }
    }
}