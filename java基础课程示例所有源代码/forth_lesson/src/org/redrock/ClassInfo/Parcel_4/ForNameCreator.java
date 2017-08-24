package org.redrock.ClassInfo.Parcel_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/8/11.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames = {
            "org.redrock.ClassInfo.Parcel_4.Mutt",
            "org.redrock.ClassInfo.Parcel_4.Pug",
            "org.redrock.ClassInfo.Parcel_4.EgyptianMau",
            "org.redrock.ClassInfo.Parcel_4.Manx",
            "org.redrock.ClassInfo.Parcel_4.Cymric",
            "org.redrock.ClassInfo.Parcel_4.Rat",
            "org.redrock.ClassInfo.Parcel_4.Mouse",
            "org.redrock.ClassInfo.Parcel_4.Hamster",
    };

    //该注解不能置于静态初始化字句之上，重点关注如何出事化Types这个List的，这里实用的是Class.forName
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add((Class<? extends  Pet>)Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
