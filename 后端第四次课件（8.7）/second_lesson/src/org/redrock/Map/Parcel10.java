package org.redrock.Map;

import org.redrock.List.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel10 {
    public static void main(String[] args) {
        Map<String, Pet> map = new HashMap<>();
        map.put("my cat", new Pet("小猫"));
        map.put("my dog", new Pet("小狗"));
        map.put("my hamster", new Pet("仓鼠"));
        System.out.println(map);
        Pet dog = map.get("my dog");
        System.out.println(dog);
        System.out.println(map.containsKey("my dog"));
        System.out.println(map.containsValue(dog));
    }
}
