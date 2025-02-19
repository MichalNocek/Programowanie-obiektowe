package RunInput;

public class Los {

    public  int Losowanie(int a,int b) {
        return (int)(Math.random() * (b - a + 1) + a);
    }
}
