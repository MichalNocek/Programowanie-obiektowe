package pliki;

public class Punkt {
    public double x;
    public double y;
    public Punkt(){
        x=0.0;
        y=0.0;
    }
    public Punkt(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    void  zeruj(){
        y=0.0;
        x=0.0;
    }
    void opis(){
        System.out.println(x+","+y);
    }
    void przesun(double xd, double yd){
        x=xd+x;
        y=yd+y;
    }




}
