import java.util.*;

public class Main {
    public static void main(String[] args) {
        Osoba[] tablica = {
                new Osoba("Kasia"),
                new Osoba("Tomek"),
                new Osoba("Anna"),
                new Osoba("Jan"),
                new Osoba("Ola")
        };

        List<Osoba> lista = new ArrayList<>(Arrays.asList(tablica));

        System.out.println("Oryginalna lista:");
        System.out.println(lista);


        List<Osoba> podlista = lista.subList(1, 4);
        System.out.println("Podlista (1-4): " + podlista);


        podlista.clear();
        System.out.println("Po usunięciu podlisty:");
        System.out.println(lista);
    }
}
