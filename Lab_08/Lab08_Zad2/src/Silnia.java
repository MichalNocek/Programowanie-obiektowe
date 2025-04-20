public class Silnia {
    public int silnia(int a) throws BlednaWartoscDlaSilniException {

       if(a<0){
           throw new BlednaWartoscDlaSilniException("Podana wartość jest mniejsza od 0");
       }

        int wynik = 1;
        while (a>0) {
            wynik = wynik*a;
            a--;
        }
        return wynik;




    }
}
