package Polymorphism;

/**
 * Created by wang on 2017/7/31.
 */
public class Rodent {
    private int hunger = 100;
    private static String name = "啮齿动物";

    public static void getStatic() {
        System.out.println("Base Rodent");
    }

    public void feed(int food) {
        this.hunger+=food;
        System.out.println("现在的饥饿度为" + this.hunger);
    }

    public void run() {
        System.out.println(this.name + "正在奔跑!!" );
        this.feed(-10);
    }

    //在导出类中，对于基类中的private(被自动认为是final方法)的方法，最好采用不同的名字

    //问题：如果一个对象被其他多个对象公用时，消除对象时如何判断什么时候消除这个对象

    //   引用计数
}
