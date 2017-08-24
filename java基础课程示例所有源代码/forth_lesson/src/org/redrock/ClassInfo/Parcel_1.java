package org.redrock.ClassInfo;

/**
 * Created by wang on 2017/8/10.
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    //如果下面这句话注释掉会发生什么
    Toy() { }
    Toy(int i) {}
    public void show() {
        System.out.println("Toy");
    }
}

class Fancytoy extends Toy implements HasBatteries, Waterproof, Shoots {
    Fancytoy() {super(1);}
    public void show() {
        System.out.println("FancyToy");
    }
}
public class Parcel_1 {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("org.redrock.ClassInfo.Fancytoy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //虚拟构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        printInfo(obj.getClass());

        // TODO 作业：1) 递归打印一个类在继承体系中的所有类 2)尝试获取私有属性的值
    }

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + ". is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }
}
