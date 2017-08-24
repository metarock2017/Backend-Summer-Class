package org.redrock.ClassInfo.Parcel_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/8/12.
 */
public class MapData {
    public static Map<Class, Integer> map(List<Class<? extends Pet>> types, int n) {
        Map<Class, Integer> classMap = new HashMap<>();
        for (Class c : types) {
            classMap.put(c, n);
        }
        return classMap;
    }
}
