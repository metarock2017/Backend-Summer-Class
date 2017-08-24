package org.redrock.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel9 {
    public static void main(String[] args) {
        Random rand = new Random(33);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }

        System.out.println(map);
    }
}
