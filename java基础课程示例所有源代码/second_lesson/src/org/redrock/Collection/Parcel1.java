package org.redrock.Collection;

import java.util.*;

/**
 * Created by wang on 2017/8/6.
 */
public class Parcel1 {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInt = {6, 7, 8, 9, 10};
        System.out.println(collection);

        collection.addAll(Arrays.asList(moreInt));
        System.out.println(collection);

        Collections.addAll(collection, 11 ,12, 13, 14, 15);
        System.out.println(collection);

        Collections.addAll(collection, moreInt);
        System.out.println(collection);

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        System.out.println(list);

        list.set(1, 99);
        System.out.println(list);
        //下面这条语句为什么会出错?
        //list.add(21);
    }
}
