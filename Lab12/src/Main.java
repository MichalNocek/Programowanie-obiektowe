import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File plik = new File("./Lab12/pesele.txt");
        PeselDecode peselDecode = new PeselDecode();
        Scanner sc = new Scanner(plik);
        Statystyka statystyka = new Statystyka();
        List<String> pesel = new ArrayList<>();
        while (sc.hasNextLine()) {
            pesel.add(sc.nextLine());
        }
        peselDecode.maleFemale(pesel);
        List<Data> data = peselDecode.parsujDatyUrodzenia(pesel);
        statystyka.statystyka(data);

        BufferedWriter writer = new BufferedWriter(new FileWriter("./Lab12/wynik.txt")) ;
            String wynik = "";
        for(Data d : data) {
            wynik = d.rok + "-" + d.miesiac + "-" + d.dzien;
            System.out.println(wynik);
            writer.write(wynik);
            writer.newLine();
        }

        writer.close();




    sc.close();
    }
}