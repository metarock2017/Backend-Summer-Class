package org.redrock.Test;

/**
 * Created by wang on 2017/8/22.
 */
public class Car {
    private String name;
    private int speed;

    Car() {}

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void run() {
        System.out.println("这辆名叫" + name + "的汽车，正在以时速" + speed + "奔跑");
    }
}
