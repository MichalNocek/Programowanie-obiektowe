package input_random_itp;

import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);
    //metoda do wczytywania typu int

    public int InputInt() {
        return scanner.nextInt();
    }
    public String Inputstring(){
        return scanner.nextLine();
    }



}
