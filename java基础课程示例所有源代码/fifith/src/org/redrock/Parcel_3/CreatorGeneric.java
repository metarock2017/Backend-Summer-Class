package org.redrock.Parcel_3;

/**
 * Created by wang on 2017/8/23.
 */
abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate() {element = create();}
    abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {
    X create() { return new X();}
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

class OtherTest<T> {
    final T element;
    OtherTest(T t) {this.element = t;}
    public void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c= new Creator();
        c.f();

        OtherTest ot = new OtherTest(new X());
        ot.f();
    }
}
