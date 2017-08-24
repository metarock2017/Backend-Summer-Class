package org.redrock.Parcel_3;

/**
 * 擦除补偿
 * Created by wang on 2017/8/23.
 */
class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {this.kind = kind;}
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

//    public static void f(Object arg) {
//        if (arg instanceof T)
//            T var = new T();
//
//        T[] array = new T[3];
//        T[] array1 = (T) new Object()[3];
//    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
