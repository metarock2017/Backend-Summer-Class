package org.redrock.Test;

/**
 * Created by wang on 2017/8/22.
 */
public class CarProxy extends Car{
    public void run() {
        long starttime = System.currentTimeMillis();
        super.run();
        long endtime = System.currentTimeMillis();
        System.out.println("这辆车行驶了" + (endtime-starttime) + "us");
    }
}
