import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> imiona = new HashSet<String>();

        String imie = scanner.nextLine();
            imiona.add(imie);
        while (true) {

            imie = scanner.nextLine();
            if(imie.equals("-")){
                break;
            }
            imiona.add(imie);
        }

        for(String element : imiona ){
            System.out.println(element);
        }





    }
}