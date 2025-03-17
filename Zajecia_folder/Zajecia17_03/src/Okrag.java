public class Okrag {

    private Point srodek;
    private double promien;

    public Okrag(Point srodek, double promien) {
        this.srodek = srodek;
        this.promien = promien;
    }

    public Okrag(){
        srodek = new Point(0,0);
        promien = 0;
    }

    public double getPowierzchnia(){
        return (promien*promien)*Math.PI;
    }
    public double getSrednica(){
        return promien*2;
    }
    public void setPromien(double new_promien){
        promien= new_promien;
    }

    public  double getPromien(){
        return promien;
    }
    public boolean wSrodku(Point punkt_test){
        return (((punkt_test.x - srodek.x) * (punkt_test.x - srodek.x)) + ((punkt_test.y - srodek.y) * (punkt_test.y - srodek.y))) <= promien * promien;
    }
}
