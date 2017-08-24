package org.redrock.ClassInfo.Parcel_7;

/**
 * Created by wang on 2017/8/21.
 */
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class iProxy implements Interface {
    private Interface proxied;
    iProxy(Interface proxied) {this.proxied = proxied;}

    public void doSomething() {
        System.out.println("doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}
public class SimpleProxy {
    public static void consumer(Interface face) {
        face.doSomething();
        face.somethingElse("test");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("--------分隔符--------");
        consumer(new iProxy(new RealObject()));
    }
}
