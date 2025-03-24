package FiguryGeometryczne;

public class Prostopadloscian {

    public double a;
    public double b;
    public double c;


    public Prostopadloscian(double a, double c, double b) {
        this.a = a;
        this.c = c;
        this.b = b;
    }

    public double obliczObjetosc() {
        return a * b * c;
    }

    public double obliczPolePowierzchni() {
        return 2 * (a * b + a * c + b * c);
    }

    public double obliczPrzekatna() {
        return Math.sqrt(a * a + b * b + c * c);
    }



}
