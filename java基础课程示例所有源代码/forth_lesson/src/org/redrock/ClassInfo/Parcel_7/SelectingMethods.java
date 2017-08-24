package org.redrock.ClassInfo.Parcel_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wang on 2017/8/21.
 */
class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {this.proxied = proxied;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //可以通过查看方法签名的其他方面，甚至可以搜索特定的参数值
        if (method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implementation implements  SomeMethods {

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting" + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[] {SomeMethods.class},
                new MethodSelector(new Implementation())
        );

        proxy.boring1();
        proxy.boring2();
        proxy.interesting("proxy ");
        proxy.boring3();
    }
}
