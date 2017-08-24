package Interface;

import java.util.Random;

/**
 * Created by wang on 2017/8/1.
 */
public class RandomDoubles {
    private static Random rand = new Random(47);
    public double next() {
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles randomDoubles = new RandomDoubles();
        for (int i = 0; i  < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
