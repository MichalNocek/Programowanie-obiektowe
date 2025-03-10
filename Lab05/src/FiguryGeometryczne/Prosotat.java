package FiguryGeometryczne;

public class Prosotat {
    int bok_a,bok_b;

    public Prosotat(int bok_a, int bok_b) {
        this.bok_a = bok_a;
        this.bok_b = bok_b;
    }

    public int getBok_a() {
        return bok_a;
    }

    public int getBok_b() {
        return bok_b;
    }

    public  int pole(){
        return bok_a*bok_b;
    }




}
