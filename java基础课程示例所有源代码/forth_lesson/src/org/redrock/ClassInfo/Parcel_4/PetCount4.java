package org.redrock.ClassInfo.Parcel_4;

/**
 * Created by wang on 2017/8/17.
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            counter.count(pet);
        }

        System.out.println(counter);
    }
}
