package FiguryGeometryczne;

public class Stozek {

    public double r;
    public double h;


    public Stozek(double r, double h) {
        this.r = r;
        this.h = h;
    }
    public double obliczObjetosc() {
        return (1.0 / 3) * Math.PI * r * r * h;
    }



}
