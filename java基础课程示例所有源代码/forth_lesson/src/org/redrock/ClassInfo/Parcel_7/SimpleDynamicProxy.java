package org.redrock.ClassInfo.Parcel_7;

import java.lang.reflect.*;

/**
 * 动态代理实现思路
 * 实现功能：通过Proxy的 newProxyInstance 返回代理对象
 * 1. 声明一段源码，动态产生代理
 * 2. 编译源码，产生新的类（代理类）
 * 3. 使用这个类的加载器（Loader）将类加载到内存中，产生一个新的对象（代理对象）
 * 4。return 代理对象
 * Created by wang on 2017/8/21.
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {this.proxied = proxied;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method.invoke(proxied, args);
        System.out.println("***** proxy: " + proxy.getClass() + ". method: " + ". args:" + args);
        if (args != null)
            for (Object arg: args)
                System.out.println(" " + arg);

        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface face) {
        face.doSomething();
        face.somethingElse("tst");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}
