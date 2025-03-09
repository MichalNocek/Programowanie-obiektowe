package Input_random;

import java.util.Random;

public class Random_number {
    Random rand = new Random();


    public int random_int(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }





}
