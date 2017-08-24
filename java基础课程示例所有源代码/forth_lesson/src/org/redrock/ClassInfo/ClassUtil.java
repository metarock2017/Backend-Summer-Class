package org.redrock.ClassInfo;

/**
 * Created by wang on 2017/8/10.
 */
public class ClassUtil {
    public static <T>T getClassInstance(Class clazz) throws IllegalAccessException, InstantiationException {
        return (T)clazz.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Square s = ClassUtil.getClassInstance(Square.class);
        s.show();
    }
}
