package NestedClasses;

/**
 * 通过实例初始化，为匿名内部类创建一个构造器的效果
 * Created by wang on 2017/8/2.
 */

abstract class Base {
    public Base(int i) {
        System.out.println("Base Constructor, i = " + i);
    }

    public abstract void f();
}

public class Parcel5 {
    private static String name = "wws";
    public static Base getBase(int i, Parcel5 p) {
        return new Base(i) {
            private String name = p.getName();
            { System.out.println("Inside instance init"); }
            @Override
            public void f() {
                System.out.println("In anonymous f(), name = " + name);
            }
        };
    }

    public String getName() { return name; }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Base base = getBase(77, p);
        base.f();
    }
}

//如果定义一个匿名内部类，并且希望它使用一个外部定义的对象，那么编译器要求参数引用时final引用的
