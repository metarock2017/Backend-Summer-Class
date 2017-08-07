package org.redrock.Iterator;

import org.redrock.List.Pet;
import org.redrock.List.Pets;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel5 {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext())
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ";");

        System.out.println("-----------------");
        while (it.hasPrevious())
            System.out.print(it.previous().getName() + " ");

        System.out.println("\n-----------------");
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(new Pet("外星人"));
        }

        System.out.println(pets);
    }
}
