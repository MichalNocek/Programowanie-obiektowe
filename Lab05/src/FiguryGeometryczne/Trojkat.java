package FiguryGeometryczne;

public class Trojkat {

    int bok_a,bok_b,bok_c,h;

    public Trojkat(int bok_a, int bok_b, int bok_c, int h) {
        this.bok_a = bok_a;
        this.bok_b = bok_b;
        this.bok_c = bok_c;
        this.h = h;
    }

    public int pole(){
        return (bok_a*h)/2;
    }

    public int getBok_a() {
        return bok_a;
    }

    public int getBok_b() {
        return bok_b;
    }

    public int getBok_c() {
        return bok_c;
    }

    public int getH() {
        return h;
    }
}

