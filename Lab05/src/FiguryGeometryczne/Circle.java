package FiguryGeometryczne;

public class Circle {
    int srednica;

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }
    public double obwodkola() {
       return  (2*srednica*3.14);
    }

}
