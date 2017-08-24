package org.redrock.Parcel_1;

/**
 * Created by wang on 2017/8/23.
 */
public class Holder<T> {
    private T a;

    public Holder(T a) {this.a = a;}

    public void setA(T a) {this.a = a;}

    public T getA() {return a;}

    public static void main(String[] args) {
        Holder<Integer> h = new Holder<>(new Integer(22));
        Integer i = h.getA();

        System.out.println(i);
    }
}
