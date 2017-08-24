package org.redrock.ClassInfo.Parcel_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by wang on 2017/8/11.
 */
public abstract class PetCreator {
    private Random rand = new Random(47);

    //用一个抽象方法来规定子类来实现
    public abstract List<Class<? extends Pet>> types();

    //随机获取一个宠物
    public Pet randomPet() {
        int n = rand.nextInt(types().size());
        Pet p = null;
        try {
            p = types().get(n).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return p;
    }

    //使用randomPet来填充数组
    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }

        return pets;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));

        return result;
    }

}
