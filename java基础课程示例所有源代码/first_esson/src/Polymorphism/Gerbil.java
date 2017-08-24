package Polymorphism;

/**
 * Created by wang on 2017/7/31.
 */
public class Gerbil extends Rodent {
    private int hunger = 150;
    private String name = "鼹鼠";

    public static void getStatic() {
        System.out.println("Gerbil");
    }

    @Override
    public void feed(int food) {
        this.hunger+=food;
        System.out.println(this.name + "现在的饥饿度为" + this.hunger);
    }

//    @Override
//    public void run() {
//        System.out.println(this.name + "正在奔跑!!" );
//        this.feed(-30);
//    }
}
