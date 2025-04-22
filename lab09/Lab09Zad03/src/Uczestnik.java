import java.util.Objects;

public class Uczestnik {
    int id;
    String imie;
    int wiek;

    Uczestnik(int ID, String imie, int wiek) {
        this.id = ID;
        this.imie = imie;
        this.wiek = wiek;

    }

    public String toString(){
        return id +" "+imie + " " + wiek;
    }


    public int getWiek() {
        return wiek;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Uczestnik that = (Uczestnik) obj;
        return id == that.id && wiek == that.wiek && Objects.equals(imie, that.imie);
    }



}
