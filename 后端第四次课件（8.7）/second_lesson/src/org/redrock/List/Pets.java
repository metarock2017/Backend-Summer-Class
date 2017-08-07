package org.redrock.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wang on 2017/8/6.
 */
public class Pets {
    private static String[] names = {"小猫", "小狗", "仓鼠", "鹦鹉", "变色龙"};

    public static List<Pet> arrayList(int n) {
        Random rand = new Random(47);
        List<Pet> petsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            petsList.add(new Pet(names[rand.nextInt(names.length)]));
        }
        return petsList;
    }
}
