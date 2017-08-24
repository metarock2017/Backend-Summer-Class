package Interface;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by wang on 2017/8/1.
 */
public class RandomWords implements Readable {
    private static Random rand = new Random(33);
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;

    public RandomWords(int count) {this.count = count;}

    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1;

        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }

//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();

        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) {
            System.out.print(s.next());
            System.out.print("\n");
        }
        s.close();
    }
}
