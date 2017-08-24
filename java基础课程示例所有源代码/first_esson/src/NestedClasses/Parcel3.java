package NestedClasses;

/**
 * 匿名内部类
 * Created by wang on 2017/8/2.
 */
interface Contents {
    int value();
}
public class Parcel3 {
    public Contents getContents() {
        return new Contents() {
            private int i = 88;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        System.out.print(p.getContents().value());
    }
}


