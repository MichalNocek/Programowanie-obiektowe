package pliki;

public class Okrag {
    public Punkt srodek;
    public double promien;

    public Okrag(int x , int y,double promien) {
        srodek = new Punkt(x,y);
        this.promien = promien;
    }
    public Okrag(){
        srodek = new Punkt(0,0);
        promien = 0;
    }


    public double getpowierzchnia(){
        return 2*3.14*promien;

    }
    public double getSrednia(){
        return 2*promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }
    public double getPromien(){
        return promien;
    }
}
