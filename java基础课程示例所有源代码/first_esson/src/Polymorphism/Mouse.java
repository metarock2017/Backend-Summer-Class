package Polymorphism;

/**
 * Created by wang on 2017/7/31.
 */
public class Mouse extends Rodent {
    private int hunger = 80;
    private String name = "老鼠";

    public static void getStatic() {
        System.out.println("Mouse");
    }

    public void feed(int food) {
        this.hunger+=food;
        System.out.println("现在的饥饿度为" + this.hunger);
    }

    public void run() {
        System.out.println(this.name + "正在奔跑!!" );
        this.feed(-20);
    }
}
