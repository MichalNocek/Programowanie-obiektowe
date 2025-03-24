package WypPojazdow;

public abstract class Pojazd {
    protected String id;
    protected String model;
    protected boolean czyDostepny= true;

    public Pojazd(String id, String model){
        this.id=id;
        this.model=model;
    }

    public void wypozycz(){
        czyDostepny = false;
    }
    public void  zwroc(){
        czyDostepny=true;
    }
    public  boolean isCzyDostepny(){
        return czyDostepny;
    }


    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public abstract double obliczkoszt (int liczbagodzin);



}
