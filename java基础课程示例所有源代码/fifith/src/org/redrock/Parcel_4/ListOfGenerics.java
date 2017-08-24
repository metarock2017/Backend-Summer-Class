package org.redrock.Parcel_4;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型数组
 * Created by wang on 2017/8/23.
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();
    public void add(T item) {array.add(item);}
    public T get(int index) {return array.get(index);}
}
