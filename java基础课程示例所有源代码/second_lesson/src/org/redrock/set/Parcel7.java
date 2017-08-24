package org.redrock.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel7 {
    public static void main(String[] args) {
        Random rand = new Random(33);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 1000; i++) {
            set.add(rand.nextInt(30));
        }

        System.out.println(set);
    }

//    public static void main(String[] args) {
//        Random rand = new Random(33);
//        Set<Integer> set = new TreeSet<Integer>();
//        for (int i = 0; i < 1000; i++) {
//            set.add(rand.nextInt(30));
//        }
//
//        System.out.println(set);
//    }
}
