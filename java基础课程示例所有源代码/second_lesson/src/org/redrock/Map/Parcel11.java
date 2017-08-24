package org.redrock.Map;

import org.redrock.List.Pet;

import java.util.*;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel11 {
    public static Map<Person, List<? extends Pet>>
        pet_people = new HashMap<Person, List<? extends Pet>>();
    static {
        pet_people.put(new Person("将天星"), Arrays.asList(
                new Pet("小猫"), new Pet("小狗")
        ));
        pet_people.put(new Person("严澄"), Arrays.asList(
                new Pet("小猪"), new Pet("仓鼠")
        ));
        pet_people.put(new Person("查森云"), Arrays.asList(
                new Pet("鹦鹉")
        ));
    }

    public static void main(String[] args) {
        //keySet() 方法返回map中所有健组成的Set
        System.out.println("People: " + pet_people.keySet());
        System.out.println("Pets: " + pet_people.values());
        for (Person person : pet_people.keySet()) {
            System.out.println(person + " has: ");
            for (Pet pet : pet_people.get(person)) {
                System.out.print("    " + pet);
            }
            System.out.println(" ");
        }

        //作业：使用map嵌套map，并遍历打印
        //Map<Person, Map<Integer, List>> test =
    }
}

class Person {
    private String name;

    Person() {}

    Person(String name) {this.name = name;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
