package org.redrock.ClassInfo;

import java.util.Random;

/**
 * 初始化有效的实现了尽可能的"惰性"
 * Created by wang on 2017/8/10.
 */
class Initable {
    //编译期常量
    static final int staticFinal = 44;
    static final int staticFinal2 = Parcel_2.rand.nextInt(1000);

    static {
        System.out.println("Initable-1");
    }
}

class Initable2 {
    //访问这个变量将强制进行类的初始化
    static int staticNonFinal = 147;

    static {
        System.out.println("Initable-2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("initable-3");
    }
}
public class Parcel_2 {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        //使用.class 获取类对象会延迟加载
        Class initable = Initable.class;
        System.out.println("after initialization");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);

        System.out.println(Initable2.staticNonFinal);

        //Class.forName() 强制进行初始化
        Class initable3 = Class.forName("org.redrock.ClassInfo.Initable3");
        System.out.println("after creating initable3");
        System.out.println(Initable3.staticNonFinal);
    }
}
