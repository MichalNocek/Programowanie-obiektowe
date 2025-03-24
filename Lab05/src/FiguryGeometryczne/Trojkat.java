package FiguryGeometryczne;

public class Trojkat {

    double bok_a,bok_b,bok_c,h;

    public Trojkat(double bok_a, double bok_b, double bok_c, double h) {
        this.bok_a = bok_a;
        this.bok_b = bok_b;
        this.bok_c = bok_c;
        this.h = h;
    }

    public double pole(){
        return (bok_a*h)/2;
    }

    public double getBok_a() {
        return bok_a;
    }

    public double getBok_b() {
        return bok_b;
    }

    public double getBok_c() {
        return bok_c;
    }

    public double getH() {
        return h;
    }
}

