package org.redrock.Parcel_1;

/**
 * 元组
 * Created by wang on 2017/8/23.
 */
public class TwoTuple<A, B> {
    //为什么这里的成员使用了public修饰，而不是private，然后通过get方法获取?
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
