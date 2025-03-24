package WypPojazdow;

public class Samochod extends Pojazd{

    public Samochod(String id, String model) {
        super(id, model);
    }

    @Override
    public double obliczkoszt(int liczbagodzin) {
        return liczbagodzin*25.0;
    }

}
