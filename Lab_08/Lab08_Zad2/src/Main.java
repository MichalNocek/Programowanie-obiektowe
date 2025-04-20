import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Silnia silnia = new Silnia();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println(silnia.silnia(sc.nextInt()));
        }catch(BlednaWartoscDlaSilniException e){
            System.out.println(e.getMessage());
        }



    }
}