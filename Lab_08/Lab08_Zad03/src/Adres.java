public class Adres {
    private String ulica;
    private String miasto;
    private double nr_domu;
    private String ExoceptionMessage="";
    Adres(String ulica, String miasto, double nr_domu) throws NieprawidlowyAdresException {

        if(ulica==null) ExoceptionMessage+="\n Ulica jest null \n";
        else this.ulica = ulica;
        if(miasto==null)ExoceptionMessage+="  Miasto jest null \n";
        else this.miasto = miasto;
        if (nr_domu<=0) ExoceptionMessage+="  Nr domu jest mniejszy od zeta  ";
        else this.nr_domu = nr_domu;
        if(!ExoceptionMessage.isEmpty()){
             throw new NieprawidlowyAdresException(ExoceptionMessage);
        }

    }




}
