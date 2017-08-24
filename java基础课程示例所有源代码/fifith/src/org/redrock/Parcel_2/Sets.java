package org.redrock.Parcel_2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wang on 2017/8/23.
 */
public class Sets {
    //并集
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    //交集
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> res  = new HashSet<T>(a);
        res.retainAll(b);

        return res;
    }

    //差集
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<T>(a);
        res.removeAll(b);

        return res;
    }

    //补集
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
