package FiguryGeometryczne;

public class Kwadrat {
    int boka,bokb;


     public int obwod(){
        return (2*boka+2*bokb);
    }

     public int pole(){
        return boka*bokb;
    }

    public void setBoka(int boka) {
        this.boka = boka;
    }

    public void setBokb(int bokb) {
        this.bokb = bokb;
    }


    public Kwadrat(int boka, int bokb) {
        this.boka = boka;
        this.bokb = bokb;
    }
}
