package FiguryGeometryczne;

public class Kula {
    double promien;

    public void setPromien(double promien) {
        this.promien = promien;
    }

    public double srednica() {
        return 2*promien;
    }
    public double objetosc(){
        return ((double) 4 /3)*3.14*promien*promien*promien;
    }
    public double powierzchnia() {
        return 4*3.14*promien*promien;
    }


}
