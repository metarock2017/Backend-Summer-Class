package org.redrock.Parcel_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/8/23.
 */
class A {
    public void f() {
        System.out.println("this is A.f()");
    }
}

class B <T> {
    T obj;
    public B(T x) {this.obj = x;}
    public void test() {
        List<T> list = new ArrayList<T>();

        //由于擦除。java编译器无法将obj.f()这一需求映射到A有f()这个事实上
        //obj.f();
    }
}
public class ErasedTest {
    public static void main(String[] args) {
        A a = new A();
        B<A> b = new B<>(a);
        b.test();

        //因此只有你希望使用的类型参数比某个具体类型（以及它的所有子类）更加泛化时，也就是说你希望代码能跨多个类工作时，泛型才有所帮助
    }
}
