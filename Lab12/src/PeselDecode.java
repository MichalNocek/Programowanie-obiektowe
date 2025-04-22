import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class PeselDecode {
    private int countmale=0;
    private  int countfemale=0;

    public void maleFemale(List<String> pesel) {

        for (String p : pesel){

            if (Integer.parseInt(p.substring(9,10)) % 2 == 0) {

                countfemale++;

            }else {
                countmale++;
            }

        }

        System.out.println("Jest kobiet: "+countfemale);
        System.out.println("Jest męzczyzn : "+countmale);
    }





        public static List<Data> parsujDatyUrodzenia(List<String> peselLista) {
            List<Data> wyniki = new ArrayList<>();

            for (String pesel : peselLista) {
                if (pesel.length() != 11) continue;

                try {
                    int rok = Integer.parseInt(pesel.substring(0, 2));
                    int miesiac = Integer.parseInt(pesel.substring(2, 4));
                    int dzien = Integer.parseInt(pesel.substring(4, 6));

                    int stulecie;

                    if (miesiac >= 1 && miesiac <= 12) {
                        stulecie = 1900;
                    } else if (miesiac >= 21 && miesiac <= 32) {
                        stulecie = 2000;
                        miesiac -= 20;
                    } else if (miesiac >= 41 && miesiac <= 52) {
                        stulecie = 2100;
                        miesiac -= 40;
                    } else if (miesiac >= 61 && miesiac <= 72) {
                        stulecie = 2200;
                        miesiac -= 60;
                    } else if (miesiac >= 81 && miesiac <= 92) {
                        stulecie = 1800;
                        miesiac -= 80;
                    } else {
                        continue; // nieprawidłowy miesiąc
                    }

                    rok += stulecie;

                    wyniki.add(new Data(dzien, miesiac, rok));

                } catch (Exception e) {
                    // zignoruj błędny PESEL
                }
            }

            return wyniki;
        }

    }
















