package org.redrock.ClassInfo;

import java.lang.reflect.Field;

/**
 * Created by wang on 2017/8/10.
 */
class Shape {}
class Rhomboid extends Shape {}
class Circle extends Shape {}
class Rectangle extends Shape {}
class Square extends Rectangle {
    public int i = 0;
    private int j = 99;
    public void show() {
        System.out.println("Square show");
    }
}
public class Parcel_1_test {
    public static void main(String[] args) {
//        Rhomboid r = new Rhomboid();
//        Shape s = r;
//        if (s instanceof Circle) {
//            Circle c = (Circle) s;
//        }

        //Square s = new Square();
        //Class c = s.getClass();
        try {
            //Class c = Class.forName("org.redrock.ClassInfo.Square");
            Square s = new Square();
            Class c = s.getClass();
            Field f = c.getDeclaredField("j");
            System.out.println(f);
            f.setAccessible(true);
            System.out.println(f.get(s));
//            while (c != null) {
//                Parcel_1.printInfo(c);
//                c = c.getSuperclass();
//            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
